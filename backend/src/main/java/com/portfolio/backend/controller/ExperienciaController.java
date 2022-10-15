package com.portfolio.backend.controller;

import com.portfolio.backend.Dto.dtoExperiencia;
import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.pinterface.IExperienciaService;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.ImpExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins="http://localhost:4200")


public class ExperienciaController {
    
    @Autowired ImpExperienciaService impExperienciaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK); 
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impExperienciaService.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getCargo(), dtoexp.getInicio(), dtoexp.getFin(), dtoexp.getTareas(), 
                dtoexp.getUrl_img(), dtoexp.getUrl());
        impExperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        
    }       
    
    
    @PutMapping("/update/(id)")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        
        //Valida si existe el ID
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        // Compara nombre de experiencia
        if(impExperienciaService.existsByNombreE(dtoexp.getNombreE()) && impExperienciaService.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //Controla que el nombre no esté en blanco
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setCargo(dtoexp.getCargo());
        experiencia.setInicio(dtoexp.getInicio());
        experiencia.setFin(dtoexp.getFin());
        experiencia.setTareas(dtoexp.getTareas());
        experiencia.setUrl_img(dtoexp.getUrl_img());
        experiencia.setUrl(dtoexp.getUrl());
        
        impExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        
}
    
  public ResponseEntity<?> delete(@PathVariable("id") int id) {
      //Valida si existe el ID
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        impExperienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
  }
    
  @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

}
