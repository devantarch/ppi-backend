package com.portfolio.backend.pinterface;

import com.portfolio.backend.entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    //Obtener lista de experiencias
    public List<Experiencia> getExperiencia();
    
    //Guardar objeto de tipo Experiencia
    public void saveExperiencia (Experiencia experiencia);
    
    
    //Eliminar objeto de tipo Experiencia, por id
    public void deleteExperiencia(int id);
    
    //Buscar objeto de tipo Experiencia, por id
    public Experiencia findExperiencia(int id);
    
}
