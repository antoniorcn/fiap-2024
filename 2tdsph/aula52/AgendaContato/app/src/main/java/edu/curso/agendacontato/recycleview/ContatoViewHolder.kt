package edu.curso.agendacontato.recycleview

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato

class ContatoViewHolder(var itemView : View,
                        var apagarClicado : ApagarClicado) :
    RecyclerView.ViewHolder(itemView) {
        var txtNome : TextView = itemView.findViewById(R.id.txt_item_nome)
        var txtEmail : TextView = itemView.findViewById(R.id.txt_item_email)
        var txtTelefone : TextView = itemView.findViewById(R.id.txt_item_telefone)
        var btnApagar : Button = itemView.findViewById(R.id.btn_item_apagar)
        var contato : Contato = Contato()

    init {
        btnApagar.setOnClickListener {
            // Log.d("AGENDA","Botão apagar acionado: $contato")
            apagarClicado.onApagarClicado(contato )
        }
    }
}