package com.example.melinastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.melinastore.db.User

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonRegister = findViewById<Button>(R.id.btn_register_second)
        val editName = findViewById<EditText>(R.id.txt_name_register)
        val editUsername = findViewById<EditText>(R.id.txt_username_register)
        val editEmail = findViewById<EditText>(R.id.txt_email_register)
        val editPassword = findViewById<EditText>(R.id.txt_password_register)

        buttonRegister.setOnClickListener {
            val username = editUsername.text.toString()
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            val name = editName.text.toString()


            val userManager = User(this)
            val resultInsertData = userManager.createUser(name, username, email, password)

            if (resultInsertData <= 0) {
                Log.d("DB_Proccess", "Cancelando...")
                Toast.makeText(this, "No se puedo registrar", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Log.d("DB_Proccess", "Guardando...")
                Toast.makeText(this, "¡Registro exitoso!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}