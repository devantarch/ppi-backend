package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.pinterface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }
    
    
    // URL: PUERTO/personas/editar/id/nombre&apellido&posicion...
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("posicion") String nuevoPosicion,
                               @RequestParam("about") String nuevoAbout,
                               @RequestParam("url_img") String nuevoUrl,
                               @RequestParam("url_back_img") String nuevoURL_back_img) {
        
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setPosicion(nuevoPosicion);
        persona.setAbout(nuevoAbout);
        persona.setUrl_img(nuevoUrl);
        persona.setUrl_back_img(nuevoURL_back_img);
        
        ipersonaService.savePersona(persona);
        return persona;
    }        
}
