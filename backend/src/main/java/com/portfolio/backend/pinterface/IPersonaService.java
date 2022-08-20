package com.portfolio.backend.pinterface;

import com.portfolio.backend.entity.Persona;
import java.util.List;



public interface IPersonaService {
    //Obtener lista de personas
    public List<Persona> getPersona();

    //Guardar objeto de tipo Persona
    public void savePersona(Persona persona);
            
    //Eliminar objeto de tipo Persona, por id
    public void deletePersona(Long id);

    //Buscar objeto de tipo Persona, por id
    public Persona findPersona(Long id);
    
}
