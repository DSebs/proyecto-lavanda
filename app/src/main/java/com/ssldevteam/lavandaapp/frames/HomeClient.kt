package com.ssldevteam.lavandaapp.frames

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssldevteam.lavandaapp.Oferta
import com.ssldevteam.lavandaapp.OfertaAdapter
import com.ssldevteam.lavandaapp.R

class HomeClient : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_client)

        // Configuración del RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val ofertas = listOf(
            Oferta("Tu Oferta: Casa Valparaiso", "PENDIENTE", R.drawable.sala1),
            Oferta("Tu Oferta: Apto Miraflores", "COMPLETADA", R.drawable.sala2),
            Oferta("Tu Oferta: Apto Arkaparaiso", "PENDIENTE", R.drawable.sala3)
        )

        recyclerView.adapter = OfertaAdapter(ofertas)

        // Mantener la navegación
        setupNavigation()
    }

    private fun setupNavigation() {
        val btnPerfil = findViewById<Button>(R.id.BtnPerfil)
        val btnInicio = findViewById<Button>(R.id.BtnInicio)


        btnPerfil.setOnClickListener {
            val intent = Intent(this, GestionPerfilActivity::class.java)
            startActivity(intent)
        }

        btnInicio.setOnClickListener {
            val intent = Intent(this, OfertaClient::class.java)
            startActivity(intent)
        }
    }
}
