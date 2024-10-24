package edu.curso.testelogin

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {

    private val repositorio = ContatoRepositorio()

    val lista = mutableStateListOf<Contato>()


    fun lerTodos() {
        repositorio.lerFirebase(lista)
    }
}