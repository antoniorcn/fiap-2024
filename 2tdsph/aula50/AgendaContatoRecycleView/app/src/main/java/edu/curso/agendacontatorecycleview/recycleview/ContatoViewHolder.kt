package edu.curso.agendacontatorecycleview.recycleview

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorecycleview.R
class ContatoViewHolder(itemView : View,
                        var clickListener: ViewHolderClickListener? = null)
    : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var txtNome : TextView
    var txtEmail : TextView
    var txtTelefone : TextView
    init {
        txtNome = itemView.findViewById(R.id.row_txt_nome)
        txtEmail = itemView.findViewById(R.id.row_txt_email)
        txtTelefone = itemView.findViewById(R.id.row_txt_telefone)
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("AGENDA", "Clicado no ViewHolder: $v")
        clickListener?.onItemClick(v)
    }
}