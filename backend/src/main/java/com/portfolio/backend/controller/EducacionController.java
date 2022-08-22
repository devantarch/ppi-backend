package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.pinterface.IEducacionService;
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
public class EducacionController {
    
    @Autowired IEducacionService iEducacionService;
    
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion() {
        return iEducacionService.getEducacion();   
    }
    
    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion) {
        iEducacionService.saveEducacion(educacion);
        return "La educacion fue creada exitosamente";
    }
    
    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        iEducacionService.deleteEducacion(id);
        return "La educacion fue borrada correctamente";
    }
    
    // URL: PUERTO/educacion/editar/id/nombre_esc&titulo&inicio...
    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                    @RequestParam("nombre_esc") String nuevoNombre_esc,
                                    @RequestParam("titulo") String nuevoTitulo,
                                    @RequestParam("inicio") String nuevoInicio,
                                    @RequestParam("fin") String nuevoFin,
                                    @RequestParam("descripcion") String nuevoDescripcion,
                                    @RequestParam("url_img") String nuevoUrl_img,
                                    @RequestParam("url") String nuevoUrl) {
    
    Educacion educacion = iEducacionService.findEducacion(id);
    
    educacion.setNombre_esc(nuevoNombre_esc);
    educacion.setTitulo(nuevoTitulo);
    educacion.setInicio(nuevoInicio);
    educacion.setFin(nuevoFin);
    educacion.setDescripcion(nuevoDescripcion);
    educacion.setUrl_img(nuevoUrl_img);
    educacion.setUrl(nuevoUrl);
    
    iEducacionService.saveEducacion(educacion);
    return educacion; 
    }
    
}
