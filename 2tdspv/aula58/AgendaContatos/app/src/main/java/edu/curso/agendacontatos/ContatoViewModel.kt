package edu.curso.agendacontatos

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {
    val lista = mutableStateListOf<Contato>()

    val nome = mutableStateOf("")
    val email = mutableStateOf("")
    val telefone = mutableStateOf("")

    init {
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
        lista.add(Contato("Joao Silva", "joao@teste.com", "(11) 1111-1111"))
        lista.add(Contato("Maria Silva", "maria@teste.com", "(11) 2222-2222"))
    }
    
    fun gravar() {
        lista.add( Contato( nome.value, email.value, telefone.value ) );
    }

}