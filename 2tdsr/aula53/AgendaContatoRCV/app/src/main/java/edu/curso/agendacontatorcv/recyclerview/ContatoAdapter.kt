package edu.curso.agendacontatorcv.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorcv.R
import edu.curso.agendacontatorcv.model.Contato

class ContatoAdapter(
    val contexto : Context,
    val lista : ArrayList<Contato> = ArrayList() ) :
    RecyclerView.Adapter<ContatoViewHolder>() {

    override fun onBindViewHolder(holder: ContatoViewHolder,
                                  position: Int) {
        if (position < lista.size) {
            val contato = lista[position]
            holder.txtNome.text = contato.nome
            holder.txtTelefone.text = contato.telefone
            holder.txtEmail.text = contato.email
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int):
            ContatoViewHolder {
        val inflater = LayoutInflater.from(contexto)
        val view = inflater.inflate(R.layout.contato_item_layout,
            parent, false)
        return ContatoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}