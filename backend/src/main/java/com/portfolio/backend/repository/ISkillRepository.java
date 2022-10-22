package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill,Integer> {
    Optional <Skill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
    
}
