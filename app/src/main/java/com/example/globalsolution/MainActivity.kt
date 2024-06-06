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
            val name = nomePraia.text.toString().trim()
            val city = nomeCidade.text.toString().trim()
            val state = nomeEstado.text.toString().trim()

            if (name.isEmpty() || city.isEmpty() || state.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else if (name.length < 3 || city.length < 3 || state.length < 2) {
                Toast.makeText(this, "Verifique os tamanhos mínimos dos campos", Toast.LENGTH_SHORT).show()
            } else {
                val beach = Beach(name, city, state)
                beachList.add(beach)
                beachAdapter.notifyDataSetChanged()
                etBeachName.text.clear()
                etCity.text.clear()
                etState.text.clear()
            }
        }
    }
}