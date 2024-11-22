package com.ssldevteam.lavandaapp.frames

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssldevteam.lavandaapp.OfertaAdapter
import com.ssldevteam.lavandaapp.OfertaRepository
import com.ssldevteam.lavandaapp.R

class HomeClient : AppCompatActivity() {

    private lateinit var adapter: OfertaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_client)

        // Configuración del RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = OfertaAdapter(OfertaRepository.ofertas)
        recyclerView.adapter = adapter

        // Botones de navegación
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

    override fun onResume() {
        super.onResume()
        // Notifica al adaptador que la lista cambió
        adapter.notifyDataSetChanged()
    }
}
