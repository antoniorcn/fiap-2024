package edu.curso.agendacontato.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato

class ContatoAdapter(
    val contexto : Context,
    val lista : MutableList<Contato> ) :
    RecyclerView.Adapter<ContatoViewHolder>() {
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        holder.txtNome.text = contato.nome
        holder.txtEmail.text = contato.email
        holder.txtTelefone.text = contato.telefone
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val inflater = LayoutInflater.from( contexto )
        val view = inflater.inflate(R.layout.contato_lista_item_layout,
            parent, false)
        return ContatoViewHolder(view)
    }
    override fun getItemCount(): Int {
        return lista.size
    }
}