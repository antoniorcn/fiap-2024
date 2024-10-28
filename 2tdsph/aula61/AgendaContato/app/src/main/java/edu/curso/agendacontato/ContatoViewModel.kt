package edu.curso.agendacontato

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ContatoViewModel : ViewModel() {

    val listaContatos = mutableStateListOf<Contato>()
    val contatoAtual = mutableStateOf<Contato?>(null)

    val httpClient = OkHttpClient()
    val gson = Gson()
    private var URL_BASE = "https://tdsph-ee91f-default-rtdb.firebaseio.com"

    fun carregarContatos() {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("AGENDA", "Erro ao carregar os contatos")
            }

            override fun onResponse(call: Call, response: Response) {
                val corpo = response.body?.string() ?: ""
                Log.d("AGENDA", "Carregando os contatos")
                Log.d("AGENDA", "Corpo: $corpo")
                if (!listOf("", "null").contains( corpo)) {
                    val typeToken =
                        object: TypeToken<HashMap<String?, Contato?>>(){}.type
                    val mapaContatos : HashMap<String?, Contato?> =
                        gson.fromJson(corpo, typeToken)
                    listaContatos.clear()
                    for (contatoEntry in mapaContatos) {
                        val chave = contatoEntry.key
                        val contato = contatoEntry.value
                        if (chave != null && contato != null) {
                            contato.id = chave
                            listaContatos.add( contato )
                        }
                    }
                    Log.d("AGENDA", "Lista de Contatos: $listaContatos")
                }
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

}