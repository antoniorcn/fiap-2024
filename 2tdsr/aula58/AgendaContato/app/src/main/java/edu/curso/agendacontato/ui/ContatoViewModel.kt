package edu.curso.agendacontato.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {
    var nome by mutableStateOf("")
    var email by mutableStateOf("")
    var telefone by mutableStateOf("")


    var lista = mutableStateListOf<Contato>()
    val repository = ContatoRepository()

    fun adicionarContato() {
        val contato = Contato("", nome, telefone, email)
        Log.d("AGENDA", "Cadastrando contato: $contato")
        repository.adicionarContatoFirebase(contato,
            {
                lerTodos()
        }, { erro ->
            Log.e("AGENDA","Erro ${erro.message} recebido e colocando na Log ")
        })
        Log.d("AGENDA", "Há ${lista.size} contatos na lista")
    }

    fun lerTodos() {
        repository.lerTodosFirebase( lista )
    }
}