package edu.curso.agendacontato.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R

class ContatoViewHolder(itemView : View) :
    RecyclerView.ViewHolder(itemView) {
    val txtNome = itemView.findViewById<TextView>(R.id.txt_item_nome)
    val txtEmail = itemView.findViewById<TextView>(R.id.txt_item_email)
    val txtTelefone = itemView.findViewById<TextView>(R.id.txt_item_telefone)
}