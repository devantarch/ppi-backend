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
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String tipo;
    
    @NotNull
    @Size(min = 1, max = 3, message = "Debe ser un valor en 1 y 100")
    private int porcentaje;
    
    
}
