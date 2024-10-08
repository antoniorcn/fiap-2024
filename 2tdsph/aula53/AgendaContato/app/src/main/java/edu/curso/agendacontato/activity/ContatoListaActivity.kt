package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.recyclerview.ContatoAdapter

class ContatoListaActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_lista_activity_layout)

        val obj = intent.extras?.getSerializable("LISTA")
        val lista : ArrayList<Contato> = (obj as ArrayList<Contato>) ?: ArrayList<Contato>()
        val adaptador = ContatoAdapter(this, lista)

        val rcv = findViewById<RecyclerView>(R.id.rcv_contato_lista)
        rcv.adapter = adaptador
        rcv.layoutManager = LinearLayoutManager(this)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        btnVoltar.setOnClickListener {
            val intent1 = Intent(this, ContatoFormActivity::class.java)
            startActivity(intent1)
        }

    }
}