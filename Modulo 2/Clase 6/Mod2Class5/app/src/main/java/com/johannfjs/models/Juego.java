package com.johannfjs.models;

import java.util.ArrayList;

/**
 * Created by johannfjs on 16/07/15.
 */
public class Juego {
    private String battleTag;


    private ArrayList<Heroes> listaHeroes;

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public ArrayList<Heroes> getListaHeroes() {
        return listaHeroes;
    }

    public void setListaHeroes(ArrayList<Heroes> listaHeroes) {
        this.listaHeroes = listaHeroes;
    }
}
