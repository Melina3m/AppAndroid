package com.example.melinastore.db

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.melinastore.Querys
import kotlin.Exception

class User(context: Context): DatabaseHelper(context), IUser {

    private val context = context

    override fun createUser(name: String, username: String, email: String, password: String): Long {
        val dbHelper = DatabaseHelper(this.context)
        val dbManager = dbHelper.writableDatabase

        var idValue: Long = 0

        try {
            val userValues = ContentValues()

            userValues.put("name", name)
            userValues.put("username", username)
            userValues.put("email", email)
            userValues.put("password", password)

            idValue = dbManager.insert(TABLE_NAME, null,  userValues)
            dbManager.close()
        } catch (ex: Exception) {
            ex.toString()
        }

        return idValue
    }

    override fun login(username: String, password: String): Boolean {
        // TODO: Login user
        var validUser = false

        try {
            val dbHelper = DatabaseHelper(this.context)
            val dbManager = dbHelper.writableDatabase

            val query = "${Querys.AUTH_USER}='${username}' AND password='${password}' LIMIT 1"
            Log.d("Querys", query)

            val userFounded = dbManager.rawQuery(query, null)

            validUser = userFounded.moveToFirst()
            userFounded.close()
        } catch (ex: Exception) {
            ex.toString()
        }

        return validUser
    }
}