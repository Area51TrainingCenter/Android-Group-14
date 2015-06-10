package com.johannfjs.models;

/**
 * Created by johannfjs on 09/06/15.
 */
public class Item {
    private int id;
    private String rutaImagen;

    public Item(int id, String rutaImagen) {
        this.id = id;
        this.rutaImagen = rutaImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
