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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String nombre_esc;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String incio;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String fin;
    
    @NotNull
    @Size(min = 1, max = 1000, message = "No cumple con regla de longitud")
    private String descripcion;
    
    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url_img;
    
    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url;
    
}
