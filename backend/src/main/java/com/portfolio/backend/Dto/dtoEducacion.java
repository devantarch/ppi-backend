package com.portfolio.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreE;

    @NotBlank
    private String titulo;

    @NotBlank
    private String inicio;

    @NotBlank
    private String fin;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String url_img;

    @NotBlank
    private String url;

    //Constructores
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String titulo, String inicio, String fin, String descripcion, String url_img, String url) {
        this.nombreE = nombreE;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.url_img = url_img;
        this.url = url;
    }

    //Getters y Setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
