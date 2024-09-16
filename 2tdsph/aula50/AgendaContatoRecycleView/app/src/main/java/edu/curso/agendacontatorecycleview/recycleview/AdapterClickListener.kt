package edu.curso.agendacontatorecycleview.recycleview

import android.view.View
import edu.curso.agendacontatorecycleview.model.Contato

interface AdapterClickListener {
    fun onItemClick(contato : Contato, position : Int)
}
