package com.portfolio.backend.pinterface;

import com.portfolio.backend.entity.Educacion;
import java.util.List;


public interface IEducacionService {
    
    //Obtener listado de educaciones
    public List<Educacion> getEducacion();
    
    //Guardar objeto de tipo Educacion
    public void saveEducacion(Educacion educacion);
    
    //Borrar objeto de tipo Educacion, por id
    public void deleteEducacion(Long id);
            
    //Buscar objeto de tipo Educacion, por id
    public Educacion findEducacion(Long id);
}
