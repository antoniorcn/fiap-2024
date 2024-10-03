package edu.curso.agendacontatorcv.viewmodel

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.curso.agendacontatorcv.databinding.ContatoListaActivityLayoutBinding
import edu.curso.agendacontatorcv.model.Contato
import edu.curso.agendacontatorcv.repository.ContatoRepositorio

class ContatoViewModel : ViewModel() {

    var lista = MutableLiveData<ArrayList<Contato>>()
    var nome = MutableLiveData<String>()
    var telefone = MutableLiveData<String>()
    var email = MutableLiveData<String>()

    val repositorio = ContatoRepositorio()

    init {
        lista.value = ArrayList()
    }

    fun salvar() {
        val contato = Contato(id = 0,
            nome=this.nome.value ?: "",
            telefone=this.telefone.value ?: "",
            email=this.email.value ?: ""
        )
        repositorio.salvar( contato )
    }

    fun listar(contexto : Activity, binding : ContatoListaActivityLayoutBinding ) {
        repositorio.listarTodos(
            sucesso =  {
                lista.value?.clear()
                lista.value?.addAll(it)
                for (contato in lista?.value ?: ArrayList<Contato>()) {
                    Log.d("AGENDA", "Contato: $contato")
                }
                contexto.runOnUiThread {
                    binding.rcvContatoLista.adapter?.notifyDataSetChanged()
                }
        })
    }

}