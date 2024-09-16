package edu.curso.agendacontatorecycleview.recycleview
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorecycleview.model.Contato
import edu.curso.agendacontatorecycleview.R
class ContatoAdapter(contexto : Context,
                     private val contatos : ArrayList<Contato>,
                    var itemClick : AdapterClickListener? = null)
        : RecyclerView.Adapter<ContatoViewHolder>() {
            var inflater = LayoutInflater.from(contexto)
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = contatos[position]
        holder.txtNome.text = contato.nome
        holder.txtEmail.text = contato.email
        holder.txtTelefone.text = contato.telefone
        holder.clickListener = ViewHolderClickListener {
            Log.d("AGENDA", "ClickListener do Adapter acionado")
            itemClick?.onItemClick(contato, position)
            Log.d("AGENDA", "Position: $position, Contato: $contato")
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ContatoViewHolder {
        val viewTemp =
            inflater.inflate(R.layout.contato_row_layout, parent, false)
        return ContatoViewHolder( viewTemp )
    }
    override fun getItemCount(): Int {
        return contatos.size
    }
}