package edu.curso.agendacontatocrudjetpack

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import ru.gildor.coroutines.okhttp.await

class ContatoViewModel : ViewModel() {

    var listaContatos : ArrayList<Contato> by mutableStateOf(arrayListOf())
    private val clientHttp = OkHttpClient.Builder().build()
    private val gson = Gson()

    fun gravarContato(contato : Contato) {
        viewModelScope.launch(Dispatchers.IO) {
            gravarContatoWeb(contato)
            lerContatos()
        }
    }

    fun lerContatos() {
        viewModelScope.launch(Dispatchers.IO) {
            listaContatos = lerContatosWeb()
        }
    }

    private suspend fun gravarContatoWeb( contato : Contato ) {
        val contatoJson = """
            {
                "nome": "${contato.nome}",
                "telefone": "${contato.telefone}",
                "email": "${contato.email}"
            }
        """.trimIndent()
        val body = RequestBody.create(MediaType.parse("application/json"), contatoJson)

        val request = Request.Builder()
            .url(Constantes.BASE_URL)
            .post(body)
            .build()
        clientHttp.newCall(request).await()
    }

    private suspend fun lerContatosWeb() : ArrayList<Contato> {
        val tempLista = ArrayList<Contato>()
        val request = Request.Builder()
            .url(Constantes.BASE_URL)
            .get()
            .build()
        val response = clientHttp.newCall(request).await()
        val responseJson = response.body()!!.string()
        Log.i(Constantes.TAG_PRINCIPAL, "Texto recebido: $responseJson")
        val type = object : TypeToken<HashMap<String?, Contato?>>() {}.type
        val mapa : HashMap<String?, Contato?> = gson.fromJson(responseJson, type)
        mapa.keys.forEach {
            val chave = it
            val obj = mapa[it]
            if (obj != null) {
                tempLista.add(obj)
            }
        }
        return tempLista
    }

}