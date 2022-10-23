package com.portfolio.backend.service;

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ImpProyectoService {

    @Autowired
    IProyectoRepository iProyectoRepository;

    public List<Proyecto> list() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return iProyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {
        return iProyectoRepository.findByNombre(nombre);
    }

    public void save(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    public void delete(int id) {
        iProyectoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iProyectoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iProyectoRepository.existsByNombre(nombre);
    }

}
