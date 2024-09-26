package edu.curso.agendacontatorcv.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorcv.R
import edu.curso.agendacontatorcv.model.Contato
import edu.curso.agendacontatorcv.recyclerview.ContatoAdapter

class ContatoListaActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_lista_activity_layout)

        val obj = intent.extras?.getSerializable("LISTA" ) ?: ArrayList<Contato>()
        val lista = obj as ArrayList<Contato>

//        val lista = ArrayList<Contato>()
//        lista.add(Contato("0", "Joao Silva", "(11) 1111", "joao@teste.com"))
//        lista.add(Contato("0", "Maria Silva", "(11) 2222", "maria@teste.com"))

        val rcvContato = findViewById<RecyclerView>(R.id.contato_rcv)
        val adaptador = ContatoAdapter(this, lista)
        rcvContato.adapter = adaptador
        rcvContato.layoutManager = LinearLayoutManager(this)
    }
}