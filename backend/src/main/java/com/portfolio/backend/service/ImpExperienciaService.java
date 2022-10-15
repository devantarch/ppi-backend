package com.portfolio.backend.service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService  {
    
    @Autowired IExperienciaRepository iexperienciaRepository;
    
    //@Override
    //public List<Experiencia> getExperiencia() {
    //List<Experiencia> experiencia = iexperienciaRepository.findAll();
    //return experiencia;    
    
    
    public List<Experiencia> list(){
        return iexperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iexperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return iexperienciaRepository.findByNombreE(nombreE);
    }
    
    public void save(Experiencia expe){
        iexperienciaRepository.save(expe);
    }
    
    public void delete(int id){
        iexperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iexperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return iexperienciaRepository.existsByNombreE(nombreE);
    }
    
    
    
    
    
//    public void saveExperiencia(Experiencia experiencia) {
//        iexperienciaRepository.save(experiencia);
//    }
//
//    
//    public void deleteExperiencia(int id) {
//        iexperienciaRepository.deleteById(id);
//    }
//
//    
//    public Experiencia findExperiencia(int id) {
//        Experiencia experiencia = iexperienciaRepository.findById(id).orElse(null);
//        return experiencia;
//    }
    
    
}
