package com.johannfjs.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.models.Persona;
import com.johannfjs.utils.Constant;

/**
 * Created by johannfjs on 30/06/15.
 */
public class Querys {
    private ManageOpenHelper dbConexion;

    public Querys(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void registrarPersona(Persona persona) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        dbProcesos.execSQL("INSERT INTO " + Constant.TB_PERSONA +
                "(" + Constant.C_NOMBRE + "," + Constant.C_APELLIDO +
                "," + Constant.C_USUARIO + "," + Constant.C_CONSTRASENA +
                ") VALUES('" + persona.getNombre() + "','" + persona.getApellido() +
                "','" + persona.getUsuario() + "','" + persona.getContrasena() + "')");
    }

    public boolean validarPersona(String usuario, String contrasena) {
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        Cursor cursor = dbProcesos.rawQuery("SELECT * FROM " + Constant.TB_PERSONA +
                " WHERE " + Constant.C_USUARIO + "='" + usuario + "' AND " +
                Constant.C_CONSTRASENA + "='" + contrasena + "'", null);
        return cursor != null ? (cursor.getCount() > 0 ? true : false) : false;
    }

    public void actualizarSesion(int existe) {
        SQLiteDatabase dbProcesos = dbConexion.getWritableDatabase();
        dbProcesos.execSQL("UPDATE " + Constant.TB_SESION +
                " SET " + Constant.C_EXISTE + "=" + existe);
    }

    public int verificarSesion() {
        int existe = -1;
        SQLiteDatabase dbProcesos = dbConexion.getReadableDatabase();
        Cursor cursor = dbProcesos.rawQuery("SELECT * FROM " + Constant.TB_SESION, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do {
                        existe = cursor.getInt(cursor.getColumnIndex(Constant.C_EXISTE));
                    } while (cursor.moveToNext());
                }
            }
        }
        return existe;
    }
}
