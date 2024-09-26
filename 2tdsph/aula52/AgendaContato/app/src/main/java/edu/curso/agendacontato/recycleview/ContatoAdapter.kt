package edu.curso.agendacontato.recycleview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato

class ContatoAdapter(
    val contexto : Context,
    val lista : MutableList<Contato> ) :
    RecyclerView.Adapter<ContatoViewHolder>(), ApagarClicado {

        // var recyclerView : RecyclerView? = null
//        override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//            super.onAttachedToRecyclerView(recyclerView)
//            this.recyclerView = recyclerView
//        }
        override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
            val contato = lista[position]
            holder.txtNome.text = contato.nome
            holder.txtEmail.text = contato.email
            holder.txtTelefone.text = contato.telefone
            holder.contato = contato
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
            val inflater = LayoutInflater.from( contexto )
            val view = inflater.inflate(R.layout.contato_lista_item_layout,
                parent, false)
            return ContatoViewHolder(view, this)
        }
        override fun getItemCount(): Int {
            return lista.size
        }

        override fun onApagarClicado(contato : Contato) {
            Log.d("AGENDA", "Apagar clicado executado a partir do ContatoAdapter")
            Log.d("AGENDA", "Contato passado como parâmetro: $contato")
            lista.remove(contato)
            // this.recyclerView?.invalidate()
            notifyDataSetChanged()
        }
}