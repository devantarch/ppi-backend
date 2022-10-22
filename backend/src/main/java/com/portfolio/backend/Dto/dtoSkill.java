package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkill {

    @NotBlank
    private String nombre;
    @NotBlank
    private String tipo;
    @NotBlank
    private int porcentaje;

    public dtoSkill() {
    }

    public dtoSkill(String nombre, String tipo, int porcentaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
