package com.portfolio.backend.controller;


import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.pinterface.IProyectoService;
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
public class ProyectoController {
    
    @Autowired IProyectoService iProyectoService;
    
    @GetMapping("/proyecto/traer")
    public List<Proyecto> getProyecto() {
        return iProyectoService.getProyecto();   
    }
    
    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proyecto) {
        iProyectoService.saveProyecto(proyecto);
        return "El proyecto fue creado exitosamente";
    }
    
    @DeleteMapping("proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        iProyectoService.deleteProyecto(id);
        return "El proyecto fue borrado correctamente";
    }
    
    // URL: PUERTO/proyecto/editar/id/nombre&fecha&url
    @PutMapping("proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("fecha") String nuevoFecha,
                                 @RequestParam("url") String nuevoUrl) {
        
        Proyecto proyecto = iProyectoService.findProyecto(id);
        
        proyecto.setNombre(nuevoNombre);
        proyecto.setFecha(nuevoFecha);
        proyecto.setUrl(nuevoUrl);
        
        iProyectoService.saveProyecto(proyecto);
        return proyecto;        
    }
    
}
    

    
