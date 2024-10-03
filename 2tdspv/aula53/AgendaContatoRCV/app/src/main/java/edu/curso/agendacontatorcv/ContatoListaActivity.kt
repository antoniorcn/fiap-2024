package edu.curso.agendacontatorcv

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContatoListaActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_lista_layout)

        val lista = ArrayList<Contato>()
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Jose Souza", "jose@teste.com", "(11) 3333-3333"))
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Jose Souza", "jose@teste.com", "(11) 3333-3333"))
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Jose Souza", "jose@teste.com", "(11) 3333-3333"))
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Jose Souza", "jose@teste.com", "(11) 3333-3333"))

        val contatoRCV = findViewById<RecyclerView>(R.id.rcv_contatos)
        contatoRCV.adapter = ContatoAdapter(this, lista)
        contatoRCV.layoutManager = LinearLayoutManager(this)

    }
}