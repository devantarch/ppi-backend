package com.portfolio.backend.pinterface;

import com.portfolio.backend.entity.Skill;
import java.util.List;


public interface ISkillService {
    
    //Obtener listado de skills
    public List<Skill> getSkill();
    
    //Guardar objeto de tipo Skill
    public void saveSkill(Skill skill);
    
    //Borrar objeto de tipo Skill, por id
    public void deleteSkill(Long id);
    
    //Buscar objeto de tipo Skill, por id
    public Skill findSkill(Long id);   
    
}
