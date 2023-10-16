package com.example.melinastore.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE " + TABLE_NAME + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR NOT NULL," +
                    "username VARCHAR NOT NULL," +
                    "email VARCHAR NOT NULL," +
                    "password VARCHAR NOT NULL" +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    companion object {
        val TABLE_NAME = "Usuarios"
        val DB_NAME = "Clientes"
        val DB_VERSION = 3
    }
}