package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.pinterface.ISkillService;
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
public class SkillController {
    
    @Autowired ISkillService iSkillService;
    
    @GetMapping("/skill/traer")
    public List<Skill> getSkill() {
        return iSkillService.getSkill();
    }
     
    @PostMapping("skill/crear")
    public String createSkill(@RequestBody Skill skill){
        iSkillService.saveSkill(skill);
        return "La skill fue creada exitosamente";
    }
    
    @DeleteMapping("skill/borrar/{id}")
    public String deleteSkill(@PathVariable Long id){
        iSkillService.deleteSkill(id);
        return "La skill fue borrada correctamente";
    }
    
    // URL: PUERTO/personas/editar/id/nombre&tipo&porcentaje
    @PutMapping("/skill/editar/{id}")
    public Skill editSkill (@PathVariable Long id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("tipo") String nuevoTipo,
                            @RequestParam("porcentaje") String nuevoPorcentaje) {
        
        Skill skill = iSkillService.findSkill(id);
        
        skill.setNombre(nuevoNombre);
        skill.setTipo(nuevoTipo);
        skill.setPorcentaje(nuevoPorcentaje);
        
        iSkillService.saveSkill(skill);
        return skill;
    }
    
        
}
