package com.example.melinastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.melinastore.db.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRegister: TextView = findViewById(R.id.btnRegistrar)
        val buttonIngresar: Button = findViewById(R.id.btnIngresar)

        val username: EditText = findViewById(R.id.txtUsuario)
        val password: EditText = findViewById(R.id.txtClave)

        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonIngresar.setOnClickListener {
            val userManager = User(this)
            val valid = userManager.login(username.text.toString(), password.text.toString())

            Log.d("Edits", valid.toString())

            if(valid) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario no valido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}