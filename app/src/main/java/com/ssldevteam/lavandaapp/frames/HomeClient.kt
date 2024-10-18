package com.ssldevteam.lavandaapp.frames

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ssldevteam.lavandaapp.R

class HomeClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_client)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar los botones con sus respectivos intents
        val btnHacerOferta = findViewById<Button>(R.id.BtnAgregar)
        val btnPerfil = findViewById<Button>(R.id.BtnPerfil)
        val btnInicio = findViewById<Button>(R.id.BtnInicio)

        btnHacerOferta.setOnClickListener {
            val intent = Intent(this, OfertaClient::class.java)
            startActivity(intent)
        }

        btnPerfil.setOnClickListener {
            val intent = Intent(this, GestionPerfilActivity::class.java)
            startActivity(intent)
        }

        btnInicio.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
