package com.johannfjs.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.johannfjs.utils.Constant;

/**
 * Created by johannfjs on 25/06/15.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.CREATE_PERSONA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constant.DROP_PERSONA);
        onCreate(db);
    }
}
