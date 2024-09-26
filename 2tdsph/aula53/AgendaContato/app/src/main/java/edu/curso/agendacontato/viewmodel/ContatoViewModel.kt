package edu.curso.agendacontato.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.curso.agendacontato.model.Contato

class ContatoViewModel : ViewModel() {

    var lista = MutableLiveData<ArrayList<Contato>>()

}