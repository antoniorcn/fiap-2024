package edu.curso.agendacontatorcv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContatoAdapter(
    val contexto : Context,
    val lista : ArrayList<Contato>) :
    RecyclerView.Adapter<ContatoViewHolder>() {
        val inflater = LayoutInflater.from(contexto)

        override fun onBindViewHolder( holder : ContatoViewHolder, pos : Int) {
            val contato = lista[pos]
            holder.txtNome.text = contato.nome
            holder.txtEmail.text = contato.email
            holder.txtTelefone.text = contato.telefone

        }
        override fun onCreateViewHolder( parent : ViewGroup, viewType : Int ) :
                ContatoViewHolder {
            val view = inflater.inflate(R.layout.contato_item_layout,
                parent, false)
            return ContatoViewHolder(view)
        }

    override fun getItemCount() : Int {
        return lista.size
    }
}