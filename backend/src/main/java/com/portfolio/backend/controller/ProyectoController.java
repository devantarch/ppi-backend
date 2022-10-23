package com.portfolio.backend.controller;

import com.portfolio.backend.Dto.dtoProyecto;
import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.ImpProyectoService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")

public class ProyectoController {

    @Autowired
    ImpProyectoService impProyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = impProyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = impProyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impProyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {

        if (StringUtils.isBlank(dtoproyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impProyectoService.existsByNombre(dtoproyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        }

        Proyecto proyecto = new Proyecto(
                dtoproyecto.getNombre(), dtoproyecto.getFecha(), dtoproyecto.getUrl()
        );

        impProyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto) {
        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (impProyectoService.existsByNombre(dtoproyecto.getNombre()) && impProyectoService.getByNombre(dtoproyecto.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = impProyectoService.getOne(id).get();

        proyecto.setNombre(dtoproyecto.getNombre());
        proyecto.setFecha(dtoproyecto.getFecha());
        proyecto.setUrl(dtoproyecto.getUrl());

        impProyectoService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }

}
