package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 100, message = "No cumple con regla de longitud")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String fecha;

    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url;

    //Constructores
    public Proyecto() {
    }

    public Proyecto(String nombre, String fecha, String url) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.url = url;
    }

}
