package com.example.agendacontatorcv

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agendacontatorcv.model.Contato
import com.example.agendacontatorcv.recyclerview.ContatoAdapter

class ContatoListActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_list_layout)

        val lista = ArrayList<Contato>()
        lista.add( Contato(0, "Joao Silva", "joao@teste.com", "(11) 1111"))
        lista.add( Contato(1, "Maria Silva", "maria@teste.com", "(11) 2222"))
        lista.add( Contato(2, "Jose Santos", "jose@teste.com", "(11) 3333"))

        val adapter = ContatoAdapter(this, lista)
        val recyclerView = findViewById<RecyclerView>(R.id.contato_rcv)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



    }
}