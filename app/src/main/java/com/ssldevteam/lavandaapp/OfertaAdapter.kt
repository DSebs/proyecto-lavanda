package com.ssldevteam.lavandaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OfertaAdapter(private val ofertas: List<Oferta>) : RecyclerView.Adapter<OfertaAdapter.OfertaViewHolder>() {

    class OfertaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo = itemView.findViewById<TextView>(R.id.txtTituloOferta)
        val imagen = itemView.findViewById<ImageView>(R.id.imgOferta)
        val estado = itemView.findViewById<TextView>(R.id.txtEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfertaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return OfertaViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfertaViewHolder, position: Int) {
        val oferta = ofertas[position]
        holder.titulo.text = oferta.titulo
        holder.estado.text = "Estado: ${oferta.estado}"

        // Cargar la imagen
        holder.imagen.setImageResource(oferta.imagenResId)
    }

    override fun getItemCount(): Int = ofertas.size
}
