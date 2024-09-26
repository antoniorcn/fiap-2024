package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.recycleview.ContatoAdapter

class ContatoListaActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_lista_activity_layout)
        val rcvContatoLista =
            findViewById<RecyclerView>(R.id.rcv_contato_lista)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        val listaTemp = intent.extras?.getSerializable("LISTA")
        val lista : MutableList<Contato> = mutableListOf()
        if (listaTemp is List<*>) {
            lista.addAll(listaTemp as List<Contato>)
        }
        val adapter = ContatoAdapter(this, lista)
        rcvContatoLista.adapter = adapter
        rcvContatoLista.layoutManager =
            LinearLayoutManager(this)
        btnVoltar.setOnClickListener {
            val intent1 = Intent(this, ContatoFormActivity::class.java)
            startActivity(intent1)
        }
    }
}