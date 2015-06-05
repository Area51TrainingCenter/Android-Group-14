package com.johannfjs.models;

/**
 * Created by johannfjs on 02/06/15.
 */
public class Item {
    private int id;
    private String textoUno, textoDos, textoTres, tiempo;
    private boolean cancel;

    public Item(int id, String textoUno, String textoDos, String textoTres, String tiempo, boolean cancel) {
        this.id = id;
        this.textoUno = textoUno;
        this.textoDos = textoDos;
        this.textoTres = textoTres;
        this.tiempo = tiempo;
        this.cancel = cancel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextoUno() {
        return textoUno;
    }

    public void setTextoUno(String textoUno) {
        this.textoUno = textoUno;
    }

    public String getTextoDos() {
        return textoDos;
    }

    public void setTextoDos(String textoDos) {
        this.textoDos = textoDos;
    }

    public String getTextoTres() {
        return textoTres;
    }

    public void setTextoTres(String textoTres) {
        this.textoTres = textoTres;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
