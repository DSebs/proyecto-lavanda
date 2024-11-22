package com.ssldevteam.lavandaapp.frames

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ssldevteam.lavandaapp.Oferta
import com.ssldevteam.lavandaapp.OfertaRepository
import com.ssldevteam.lavandaapp.R

class OfertaClient : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oferta_client)

        val btnOfertar = findViewById<Button>(R.id.BtnOfertar)

        btnOfertar.setOnClickListener {
            OfertaRepository.ofertas.add(
                Oferta("Nueva Oferta", "PENDIENTE", OfertaRepository.getRandomImage())
            )

            Toast.makeText(this, "¡Oferta creada!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeClient::class.java)
            startActivity(intent)
            finish()
        }
    }
}
