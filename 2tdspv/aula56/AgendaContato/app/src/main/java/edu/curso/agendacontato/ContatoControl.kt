package edu.curso.agendacontato

import android.app.Activity
import android.content.Context
import android.util.Log

class ContatoControl {

    val repository = ContatoRepository()
    val listaContatos = ArrayList<Contato>()

    fun salvar(contato : Contato, onSucesso : () -> Unit,
               onFalha : () -> Unit)  {
        repository.salvarFirebase( contato,
            sucesso = {
                lerTodos()
                onSucesso() },
            falha = { onFalha() } )

    }

    fun pesquisar( parteNome : String ) : Contato? {
        for (contato in listaContatos) {
            if(contato.nome.contains(parteNome)) {
                return contato
            }
        }
        return null
    }

    fun lerTodos() {
        repository.lerContatosFirebase(
            sucesso = {
                listaContatos.clear()
                listaContatos.addAll( it )
                Log.i("AGENDA", "ContatoControl recebeu lista com sucesso $listaContatos")
            },
            falha = {
                Log.e("AGENDA", "ContatoControl erro $it ao executar o LerTodos")
            })
    }
}