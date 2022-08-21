package com.portfolio.backend.service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.pinterface.IExperienciaService;
import com.portfolio.backend.repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienciaService implements IExperienciaService {
    
    @Autowired IExperienciaRepository iexperienciaRepository;
    
    @Override
    public List<Experiencia> getExperiencia() {
    List<Experiencia> experiencia = iexperienciaRepository.findAll();
    return experiencia;
    
    
}
    @Override
    public void saveExperiencia(Experiencia experiencia) {
        iexperienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        iexperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia = iexperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
    
    
}
