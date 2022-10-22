package com.portfolio.backend.service;

import com.portfolio.backend.entity.Skill;
import com.portfolio.backend.repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ImpSkillService {
    
    @Autowired ISkillRepository iSkillRepository;
    
    public List<Skill> list (){
    return iSkillRepository.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return iSkillRepository.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombre){
        return iSkillRepository.findByNombre(nombre);
    }
    
    public void save(Skill skill){
        iSkillRepository.save(skill);
    }
    
    public void delete(int id){
        iSkillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iSkillRepository.existsByNombre(nombre);
    }
    
    
    
    
    
//    @Override
//    public List<Skill> getSkill(){
//        List<Skill> skill = iSkillRepository.findAll();
//        return skill;
//    }
//    
//    @Override
//    public void saveSkill(Skill skill){
//        iSkillRepository.save(skill);        
//    }
//    
//    @Override
//    public void deleteSkill(Long id){
//        iSkillRepository.deleteById(id);
//    }    
//    
//    @Override
//    public Skill findSkill(Long id){
//        Skill skill = iSkillRepository.findById(id).orElse(null);
//        return skill;
//    }  
    
    
}
