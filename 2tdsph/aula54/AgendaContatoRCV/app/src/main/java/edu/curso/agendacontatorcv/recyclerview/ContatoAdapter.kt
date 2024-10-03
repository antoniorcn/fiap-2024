package edu.curso.agendacontatorcv.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorcv.R
import edu.curso.agendacontatorcv.viewmodel.ContatoViewModel

class ContatoAdapter(
    val contexto : Context,
    val viewModel : ContatoViewModel) : RecyclerView.Adapter<ContatoViewHolder>() {

    private val inflater = LayoutInflater.from( contexto )
    override fun onCreateViewHolder(parent : ViewGroup,
                                    viewType : Int ) : ContatoViewHolder {
        val view = inflater.inflate(R.layout.contato_lista_item_layout,
            parent, false)
        return ContatoViewHolder( view )
    }
    override fun onBindViewHolder(holder : ContatoViewHolder, pos : Int) {
        if (viewModel.lista.value != null) {
            val contato = viewModel.lista.value!![pos]
            holder.txtNome.text = contato.nome
            holder.txtEmail.text = contato.email
            holder.txtTelefone.text = contato.telefone
        }
    }
    override fun getItemCount() : Int {
        return viewModel.lista.value?.size ?: 0
    }

}