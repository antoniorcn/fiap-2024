package edu.curso.listacompras

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var txtNome : TextView = itemView.findViewById(R.id.txt_row_nome)
    var txtQtd : TextView = itemView.findViewById(R.id.txt_row_quantidade)
    var txtPreco : TextView = itemView.findViewById(R.id.txt_row_preco)
}