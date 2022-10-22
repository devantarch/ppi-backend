
package com.portfolio.backend.Dto;


import javax.validation.constraints.NotBlank;


public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String posicion;
    @NotBlank
    private String about;
    @NotBlank
    private String url_img; 
    @NotBlank
    private String url_back_img;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String posicion, String about, String url_img, String url_back_img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.about = about;
        this.url_img = url_img;
        this.url_back_img = url_back_img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl_back_img() {
        return url_back_img;
    }

    public void setUrl_back_img(String url_back_img) {
        this.url_back_img = url_back_img;
    }

    
}
