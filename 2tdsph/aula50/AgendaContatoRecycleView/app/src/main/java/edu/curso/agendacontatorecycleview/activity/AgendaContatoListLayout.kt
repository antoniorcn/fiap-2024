package edu.curso.agendacontatorecycleview.activity
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorecycleview.R
import edu.curso.agendacontatorecycleview.model.Contato
import edu.curso.agendacontatorecycleview.recycleview.AdapterClickListener
import edu.curso.agendacontatorecycleview.recycleview.ContatoAdapter

class AgendaContatoListLayout : Activity() {
    val contatos = ArrayList<Contato>()
    init {
        contatos.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        contatos.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        contatos.add(Contato("Jose Silva", "jose@teste.com", "(11) 3333-3333"))
        contatos.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        contatos.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        contatos.add(Contato("Jose Silva", "jose@teste.com", "(11) 3333-3333"))
        contatos.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        contatos.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        contatos.add(Contato("Jose Silva", "jose@teste.com", "(11) 3333-3333"))
        contatos.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        contatos.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        contatos.add(Contato("Jose Silva", "jose@teste.com", "(11) 3333-3333"))
        contatos.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        contatos.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        contatos.add(Contato("Jose Silva", "jose@teste.com", "(11) 3333-3333"))
    }
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_lista_layout)

        val recycleView = findViewById<RecyclerView>(R.id.lista_contatos_recycle_view)
        val adapter = ContatoAdapter(this, contatos,
            object : AdapterClickListener {
                override fun onItemClick(contato : Contato, position: Int) {
                    Toast.makeText(this@AgendaContatoListLayout,
                        "Contato ${contato.nome} clicado", Toast.LENGTH_LONG
                        ).show()
                }
            })

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }
}