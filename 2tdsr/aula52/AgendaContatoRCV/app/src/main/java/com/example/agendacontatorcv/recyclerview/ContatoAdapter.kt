package com.example.agendacontatorcv.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendacontatorcv.R
import com.example.agendacontatorcv.model.Contato

class ContatoAdapter(
    var contexto : Context,
    var lista : ArrayList<Contato> = ArrayList<Contato>()
) :
    RecyclerView.Adapter<ContatoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ContatoViewHolder {
        val inflater = LayoutInflater.from(contexto)

        val view = inflater.inflate(R.layout.contato_item_layout,
            parent, false)
        val cvh = ContatoViewHolder(view)
        return cvh
    }
    override fun getItemCount(): Int {
        return lista.size
    }
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        holder.txtNome.text = contato.nome
        holder.txtEmail.text = contato.email
        holder.txtTelefone.text = contato.telefone
    }
}