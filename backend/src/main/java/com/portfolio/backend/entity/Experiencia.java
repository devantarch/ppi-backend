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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String nombreE;
    
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
    
    //Constructores

    public Experiencia() {
    }
    
    public Experiencia(String nombreE, String cargo, String inicio, String fin, String tareas, String url_img, String url) {
        this.nombreE = nombreE;
        this.cargo = cargo;
        this.inicio = inicio;
        this.fin = fin;
        this.tareas = tareas;
        this.url_img = url_img;
        this.url = url;
    }   
    
}
