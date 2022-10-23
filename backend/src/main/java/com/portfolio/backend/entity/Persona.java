package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String apellido;

    @NotNull
    @Size(min = 1, max = 45, message = "No cumple con regla de longitud")
    private String posicion;

    @NotNull
    @Size(min = 1, max = 1000, message = "No cumple con regla de longitud")
    private String about;

    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url_img;

    @NotNull
    @Size(min = 1, max = 255, message = "No cumple con regla de longitud")
    private String url_back_img;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String posicion, String about, String url_img, String url_back_img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.about = about;
        this.url_img = url_img;
        this.url_back_img = url_back_img;
    }

    // Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
