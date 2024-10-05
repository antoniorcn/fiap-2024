package edu.curso.listacarros

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CarroAdapter(
    val context : Context,
    val lista : ArrayList<Carro>
) : RecyclerView.Adapter<CarroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.carro_item_layout,
            parent, false)
        return CarroViewHolder(view)
    }
    override fun onBindViewHolder(
        holder: CarroViewHolder, position: Int) {
        val carro = lista[position]
        holder.txtMarca.text = carro.marca
        holder.txtModelo.text = carro.modelo
        holder.txtValor.text = carro.valor.toString()
        holder.txtAno.text = carro.ano.toString()
    }

    override fun getItemCount(): Int {
        return lista.size
    }


}