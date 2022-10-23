package com.portfolio.backend.controller;

import com.portfolio.backend.Dto.dtoEducacion;
import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.security.controller.Mensaje;
import com.portfolio.backend.service.ImpEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class EducacionController {

    @Autowired
    ImpEducacionService impEducacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {

        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impEducacionService.existsByNombreE(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        }

        Educacion educacion = new Educacion(
                dtoeducacion.getNombreE(), dtoeducacion.getTitulo(), dtoeducacion.getInicio(), dtoeducacion.getFin(),
                dtoeducacion.getDescripcion(), dtoeducacion.getUrl_img(), dtoeducacion.getUrl()
        );

        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {
        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (impEducacionService.existsByNombreE(dtoeducacion.getNombreE()) && impEducacionService.getByNombreE(dtoeducacion.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getNombreE())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = impEducacionService.getOne(id).get();

        educacion.setNombreE(dtoeducacion.getNombreE());
        educacion.setTitulo(dtoeducacion.getTitulo());
        educacion.setInicio(dtoeducacion.getInicio());
        educacion.setFin(dtoeducacion.getFin());
        educacion.setDescripcion(dtoeducacion.getDescripcion());
        educacion.setUrl_img(dtoeducacion.getUrl_img());
        educacion.setUrl(dtoeducacion.getUrl());

        impEducacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);

    }

}
