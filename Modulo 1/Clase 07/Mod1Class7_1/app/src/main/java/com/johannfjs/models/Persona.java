package com.johannfjs.models;

/**
 * Created by johannfjs on 16/06/15.
 */
public class Persona {
    private int id;
    private String nombre;
    private String sexo;
    private int edad;
    private String rutaImagen;

    public Persona(int id, String nombre, String sexo, int edad, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.rutaImagen = rutaImagen;
    }

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
