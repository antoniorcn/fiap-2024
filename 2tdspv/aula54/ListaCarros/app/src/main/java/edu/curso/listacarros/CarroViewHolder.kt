package edu.curso.listacarros


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarroViewHolder(view : View) :
            RecyclerView.ViewHolder(view) {
    var txtMarca = view.findViewById<TextView>(R.id.txt_item_marca)
    var txtModelo = view.findViewById<TextView>(R.id.txt_item_modelo)
    var txtValor = view.findViewById<TextView>(R.id.txt_item_valor)
    var txtAno = view.findViewById<TextView>(R.id.txt_item_ano)
}