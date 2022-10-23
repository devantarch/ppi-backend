package com.portfolio.backend.controller;

import com.portfolio.backend.Dto.dtoPersona;
import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.ImpPersonaService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

// Sección creada por consistencia pero sin uso por como está planteada la web actualmente
//    
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id){
//        if(!impPersonaService.existsById(id)){
//            return new ResponseEntity(new Mensaje("No existe la persona"), HttpStatus.NOT_FOUND);
//        }
//        impPersonaService.delete(id);
//        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
//    }
//    
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
//        //En este if sumar todos los campos y acomodar mensaje, son todos obligatorios. Ver lo mismo en experiencia
//        if(StringUtils.isBlank(dtopersona.getNombre())) {
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
//        }
//        if(impPersonaService.existsByNombreE(dtopersona.getNombre())){
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//            
//        }
//        
//        Persona persona = new Persona(
//            dtopersona.getNombre(), dtopersona.getApellido(), dtopersona.getPosicion(), dtopersona.getAbout(), dtopersona.getUrl_img(), dtopersona.getUrl_back_img()
//        );
//        
//        impPersonaService.save(persona);
//        return new ResponseEntity (new Mensaje ("Persona creada"), HttpStatus.OK);
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (impPersonaService.existsByNombre(dtopersona.getNombre()) && impPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();

        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setPosicion(dtopersona.getPosicion());
        persona.setAbout(dtopersona.getAbout());
        persona.setUrl_img(dtopersona.getUrl_img());
        persona.setUrl_back_img(dtopersona.getUrl_back_img());

        impPersonaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);

    }
}
