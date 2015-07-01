package com.johannfjs.utils;

/**
 * Created by johannfjs on 30/06/15.
 */
public class Constant {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "mod2class2.db";

    public static final String TB_PERSONA = "tb_persona";
    public static final String TB_SESION = "tb_sesion";

    public static final String C_EXISTE = "existe";
    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_APELLIDO = "apellido";
    public static final String C_USUARIO = "usuario";
    public static final String C_CONSTRASENA = "contrasena";

    public static final String CREATE_PERSONA = "CREATE TABLE " + TB_PERSONA +
            "(" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            C_NOMBRE + " TEXT," +
            C_APELLIDO + " TEXT," +
            C_USUARIO + " TEXT," +
            C_CONSTRASENA + " TEXT)";
    public static final String DROP_PERSONA = "DROP TABLE " + TB_PERSONA;

    public static final String CREATE_SESION = "CREATE TABLE " + TB_SESION +
            "(" + C_EXISTE + " INTEGER)";
    public static final String DROP_SESION = "DROP TABLE " + TB_SESION;

    public static final String INSERT_SESION = "INSERT INTO " + TB_SESION +
            "(" + C_EXISTE + ") VALUES(0)";
}
