
package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String cargo;
    @NotBlank
    private String inicio;
    @NotBlank
    private String fin;
    @NotBlank
    private String tareas;
    @NotBlank
    private String url_img;
    @NotBlank
    private String url;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String cargo, String inicio, String fin, String tareas, String url_img, String url) {
        this.nombreE = nombreE;
        this.cargo = cargo;
        this.inicio = inicio;
        this.fin = fin;
        this.tareas = tareas;
        this.url_img = url_img;
        this.url = url;
    }
    
    //Getters & Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
