package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String fecha;

    @NotBlank
    private String url;

    //Constructores
    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String fecha, String url) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.url = url;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
