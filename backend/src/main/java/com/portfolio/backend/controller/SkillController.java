package com.portfolio.backend.controller;

import com.portfolio.backend.Dto.dtoSkill;
import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.ImpSkillService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    ImpSkillService impSkillService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = impSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!impSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = impSkillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impSkillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impSkillService.existsByNombre(dtoskill.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(dtoskill.getNombre(), dtoskill.getTipo(), dtoskill.getPorcentaje());
        impSkillService.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregado"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill) {

        //Valida si existe el ID
        if (!impSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // Compara nombre de experiencia
        if (impSkillService.existsByNombre(dtoskill.getNombre()) && impSkillService.getByNombre(dtoskill.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Controla que el nombre no esté en blanco
        if (StringUtils.isBlank(dtoskill.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = impSkillService.getOne(id).get();
        skill.setNombre(dtoskill.getNombre());
        skill.setTipo(dtoskill.getTipo());
        skill.setPorcentaje(dtoskill.getPorcentaje());

        impSkillService.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);

    }

}
