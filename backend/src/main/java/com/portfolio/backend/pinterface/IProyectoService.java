package com.portfolio.backend.pinterface;

import com.portfolio.backend.entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    //Obtener listado de proyectos
    public List<Proyecto> getProyecto();
    
    //Guardar objeto de tipo Proyecto
    public void saveProyecto(Proyecto proyecto);
    
    //Borrar objeto de tipo Proyecto, por id
    public void deleteProyecto(Long id);
    
    //Buscar objeto de tipo Proyecto, por id
    public Proyecto findProyecto(Long id);
    
}
