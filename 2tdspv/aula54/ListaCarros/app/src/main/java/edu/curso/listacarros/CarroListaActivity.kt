package edu.curso.listacarros

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarroListaActivity : Activity() {

    val lista = ArrayList<Carro>()

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.carro_lista_layout)

        lista.add(Carro("Fiat", "Mobi", 2022, 45000.0f))
        lista.add(Carro("Renault", "Kwid", 2020, 35000.0f))
        lista.add(Carro("Volkswagen", "Polo", 2023, 65000.0f))
        lista.add(Carro("Hyundai", "HB20", 2024, 75000.0f))
        lista.add(Carro("Fiat", "Mobi", 2022, 45000.0f))
        lista.add(Carro("Renault", "Kwid", 2020, 35000.0f))
        lista.add(Carro("Volkswagen", "Polo", 2023, 65000.0f))
        lista.add(Carro("Hyundai", "HB20", 2024, 75000.0f))
        lista.add(Carro("Fiat", "Mobi", 2022, 45000.0f))
        lista.add(Carro("Renault", "Kwid", 2020, 35000.0f))
        lista.add(Carro("Volkswagen", "Polo", 2023, 65000.0f))
        lista.add(Carro("Hyundai", "HB20", 2024, 75000.0f))

        val rcvCarros = findViewById<RecyclerView>(R.id.rcv_carros)
        val adapter = CarroAdapter(this, lista)
        rcvCarros.adapter = adapter
        rcvCarros.layoutManager = LinearLayoutManager(this)
    }
}