package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.pinterface.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaController {
    
    @Autowired IExperienciaService iExperienciaService;
    
    @GetMapping("/experiencias/traer")
    public List<Experiencia> getExperiencia() {
        return iExperienciaService.getExperiencia();
    }
    
    @PostMapping("/experiencias/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia) {
        iExperienciaService.saveExperiencia(experiencia);
        return "La experiencia fue creada exitosamente";
    }
    
    @DeleteMapping("/experiencias/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id) {
        iExperienciaService.deleteExperiencia(id);
        return "La experiencia fue borrada correctamente";
    }
   
    // URL: PUERTO/experiencias/editar/id/nombre_emp&cargo&inicio...
    @PutMapping("/experiencias/editar/{id}")
    public Experiencia editExperiencia (@PathVariable Long id,
                               @RequestParam("nombre_emp") String nuevoNombre_emp,
                               @RequestParam("cargo") String nuevoCargo,
                               @RequestParam("inicio") String nuevoInicio,
                               @RequestParam("fin") String nuevoFin,
                               @RequestParam("tareas") String nuevoTareas,
                               @RequestParam("url_img") String nuevoUrl_img,
                               @RequestParam("url") String nuevoUrl) {
        
        Experiencia experiencia = iExperienciaService.findExperiencia(id);
        
        experiencia.setNombre_emp(nuevoNombre_emp);
        experiencia.setCargo(nuevoCargo);
        experiencia.setInicio(nuevoInicio);
        experiencia.setFin(nuevoFin);
        experiencia.setTareas(nuevoTareas);
        experiencia.setUrl_img(nuevoUrl_img);
        experiencia.setUrl(nuevoUrl);
        
        iExperienciaService.saveExperiencia(experiencia);
        return experiencia;
    }  
}
