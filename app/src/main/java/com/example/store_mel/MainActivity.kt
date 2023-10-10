package com.example.store_mel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.store_mel.R.layout.activity_main)

        val buttonR: Button = findViewById(R.id.buttonR)

        buttonR.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            Log.d("registrar", "Click en boton registar")

        }
    }
}
