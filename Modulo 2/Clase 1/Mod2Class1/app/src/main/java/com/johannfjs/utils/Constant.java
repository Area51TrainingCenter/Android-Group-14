package com.johannfjs.utils;

/**
 * Created by johannfjs on 25/06/15.
 */
public class Constant {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "mod2class1.db";

    public static final String TB_PERSONA = "tb_persona";
    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_APELLIDO = "apellido";
    public static final String C_EDAD = "edad";
    public static final String C_SEXO = "sexo";

    //CREATE TABLE TB_PERSONA(ID INTEGER PRIMARY KEY AUTOINCREMENT,
    // NOMBRE TEXT, APELLIDO TEXT, EDAD INTEGER, SEXO TEXT)
    public static final String CREATE_PERSONA = "CREATE TABLE " + TB_PERSONA +
            "(" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            C_NOMBRE + " TEXT," +
            C_APELLIDO + " TEXT," +
            C_EDAD + " INTEGER," +
            C_SEXO + " TEXT)";
    public static final String DROP_PERSONA = "DROP TABLE " + TB_PERSONA;
}
