package edu.curso.agendacontatorcv

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoViewHolder(itemView : View) :
        RecyclerView.ViewHolder(itemView) {

    var txtNome = itemView.findViewById<TextView>(R.id.txt_item_nome)
    var txtEmail = itemView.findViewById<TextView>(R.id.txt_item_email)
    var txtTelefone = itemView.findViewById<TextView>(R.id.txt_item_telefone)
}