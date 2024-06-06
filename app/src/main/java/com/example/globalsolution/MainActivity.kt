package com.example.globalsolution

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var projetoPraia: ProjetoPraia
    private val listaPraias = mutableListOf<Praia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val nomePraia: EditText = findViewById(R.id.nomePraia)
        val nomeCidade: EditText = findViewById(R.id.nomeCidade)
        val nomeEstado: EditText = findViewById(R.id.nomeEstado)
        val btnIncluir: Button = findViewById(R.id.btnIncluir)

        projetoPraia = ProjetoPraia(listaPraias) { beach ->
            listaPraias.remove(beach)
            projetoPraia.notifyDataSetChanged()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = projetoPraia

        btnIncluir.setOnClickListener {
            val nome = nomePraia.text.toString().trim()
            val cidade = nomeCidade.text.toString().trim()
            val estado = nomeEstado.text.toString().trim()

            val retornoPraia = Praia(nome, cidade, estado)
            listaPraias.add(retornoPraia)
            //ProjetoPraia.notifyDataSetChanged()
            nomePraia.text.clear()
            nomeCidade.text.clear()
            nomeEstado.text.clear()
        }
    }
}