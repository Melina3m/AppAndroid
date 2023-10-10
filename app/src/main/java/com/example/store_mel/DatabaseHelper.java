package com.example.store_mel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends  SQLiteOpenHelper{

    public static final String TABLE_NAME = "Usuarios";

    public  static final String DB_NAME= "Clientes";
    public  static final int DB_VERSION=1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE_TABLE"+TABLE_NAME+"(" +
                "Id INTEGER PRIMATY KEY AUTOINCREMENT," +
                "User TEXT NOT NULL," +
                "Clave TEXT NO NULL" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}

