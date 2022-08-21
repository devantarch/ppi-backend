package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    // En un futuro se integrará tipo de experiencia a partir de la relación con otra tabla.
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String nombre_emp;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String cargo;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String inicio;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String fin;
    
    @NotNull
    @Size(min = 1, max = 1000, message = "No cumple con regla de longitud")
    private String tareas;
    
    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url_img;
    
    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url;
    
            
    
}
