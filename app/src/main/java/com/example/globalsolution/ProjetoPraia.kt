package com.example.globalsolution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Praia(val name: String, val city: String, val state: String)

class ProjetoPraia(private val Praias: MutableList<Praia>, private val onDeleteClick: (Praia) -> Unit) :
    RecyclerView.Adapter<ProjetoPraia.BeachViewHolder>() {
    class BeachViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val praia: TextView = view.findViewById(R.id.viewPraia)
        val cidade: TextView = view.findViewById(R.id.viewCidade)
        val estado: TextView = view.findViewById(R.id.viewEstado)
        val btnDeletar: Button = view.findViewById(R.id.btnDeletar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeachViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_praia, parent, false)
        return BeachViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeachViewHolder, position: Int) {
        val beach = Praias[position]
        holder.praia.text = beach.name
        holder.cidade.text = beach.city
        holder.estado.text = beach.state
        holder.btnDeletar.setOnClickListener {
            onDeleteClick(beach)
        }
    }

    override fun getItemCount(): Int = Praias.size
}