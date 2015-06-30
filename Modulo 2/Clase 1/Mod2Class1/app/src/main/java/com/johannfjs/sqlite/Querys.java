package com.johannfjs.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.models.Persona;
import com.johannfjs.utils.Constant;

import java.util.ArrayList;

/**
 * Created by johannfjs on 25/06/15.
 */
public class Querys {
    private ManageOpenHelper dbConexion;

    public Querys(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void insertarPersona(String nombre, String apellido, int edad, String sexo) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        //INSERT INTO TB_PERSONA(NOMBRE, APELLIDO, EDAD, SEXO)
        //VALUES('nombre', 'apellido', edad, 'sexo')
        dbProcesos.execSQL("INSERT INTO " + Constant.TB_PERSONA +
                "(" + Constant.C_NOMBRE + "," + Constant.C_APELLIDO + "," +
                Constant.C_EDAD + "," + Constant.C_SEXO + ") VALUES('" +
                nombre + "','" + apellido + "'," + edad + ",'" + sexo + "')");
    }

    public ArrayList<Persona> listarPersonas() {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        Cursor cursor = dbProcesos.rawQuery("SELECT * FROM " + Constant.TB_PERSONA, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    lista.add(new Persona(cursor.getInt(cursor.getColumnIndex(Constant.C_ID)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_NOMBRE)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_APELLIDO)),
                            cursor.getInt(cursor.getColumnIndex(Constant.C_EDAD)),
                            cursor.getString(cursor.getColumnIndex(Constant.C_SEXO))));
                } while (cursor.moveToNext());
            }
        }
        return lista;
    }

    public void eliminarPersona(int id) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        dbProcesos.execSQL("DELETE FROM " + Constant.TB_PERSONA + " WHERE " + Constant.C_ID + "=" + id);
    }
}
