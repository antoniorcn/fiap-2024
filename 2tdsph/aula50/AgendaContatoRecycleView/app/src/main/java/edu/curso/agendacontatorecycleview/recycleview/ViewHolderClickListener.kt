package edu.curso.agendacontatorecycleview.recycleview

import android.view.View
import edu.curso.agendacontatorecycleview.model.Contato

fun interface ViewHolderClickListener {
    fun onItemClick(view : View?)
}
