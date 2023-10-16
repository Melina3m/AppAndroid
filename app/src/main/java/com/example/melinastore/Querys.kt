package com.example.melinastore

import com.example.melinastore.db.DatabaseHelper

object Querys {
    val AUTH_USER = "SELECT * FROM ${DatabaseHelper.TABLE_NAME} WHERE username"
}