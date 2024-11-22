package com.ssldevteam.lavandaapp

import kotlin.random.Random

object OfertaRepository {
    val ofertas = mutableListOf(
        Oferta("Tu Oferta: Casa Valparaiso", "PENDIENTE", R.drawable.sala1),
        Oferta("Tu Oferta: Apto Miraflores", "COMPLETADA", R.drawable.sala2),
        Oferta("Tu Oferta: Apto Arkaparaiso", "PENDIENTE", R.drawable.sala3)
    )

    // Lista de imágenes disponibles
    private val imageResources = listOf(
        R.drawable.sala4,
        R.drawable.sala5,
        R.drawable.sala6,
    )

    fun getRandomImage(): Int {
        return imageResources[Random.nextInt(imageResources.size)]
    }
}