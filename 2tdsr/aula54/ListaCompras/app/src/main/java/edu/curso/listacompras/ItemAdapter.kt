package edu.curso.listacompras

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var context : Context,
                  var lista : ArrayList<Item>) : RecyclerView.Adapter<ItemViewHolder>() {

    var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = inflater.inflate(
            R.layout.item_row_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = lista[position]
        holder.txtNome.text = item.nome
        holder.txtPreco.text = "R$%7.2f".format(item.preco)
        holder.txtQtd.text = item.quantidade.toString()

    }
    // override fun getItemCount() = lista.size
    override fun getItemCount(): Int {
        return lista.size
    }

}