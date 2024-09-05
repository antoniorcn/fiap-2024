package edu.curso.agendacontato.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.curso.agendacontato.model.Contato

class ContatoViewModel : ViewModel() {

    private val _contatoData = MutableLiveData<Contato>()
    val contatoData : LiveData<Contato> = _contatoData

    private val _contatoList = MutableLiveData<ArrayList<Contato>>()
    val contatoList : LiveData<ArrayList<Contato>> = _contatoList

    init {
        _contatoData.value = Contato()
        _contatoList.value = ArrayList()
    }

}