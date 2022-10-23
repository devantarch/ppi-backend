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
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String tipo;

    @NotNull
    private int porcentaje;

    // Constructores
    public Skill() {
    }

    public Skill(String nombre, String tipo, int porcentaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

}
