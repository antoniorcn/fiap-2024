package edu.curso.agendacontatorcv.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.agendacontatorcv.model.Contato
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class ContatoRepositorio {

    private val URL_BASE = "https://tdsph-ee91f-default-rtdb.firebaseio.com"

    private val httpClient = OkHttpClient()
    private val gson = Gson()

    fun salvar(contato : Contato) {
        val textoJson = gson.toJson(contato)
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post(textoJson.toRequestBody("application/json".toMediaType()))
            .build()
        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                Log.d("AGENDA", "Contato salvo com sucesso")
            }
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA", "Erro ao salvar o contato", e)
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun listarTodos( sucesso : (ArrayList<Contato>) -> Unit ) {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()
        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val jsonContatos = response.body?.string() ?: "{}"

                val typeToken = object : TypeToken<HashMap<String?, Contato?>>(){}.type
                val contatos : HashMap<String?, Contato?> = gson.fromJson(jsonContatos, typeToken)
                val listaContatos = ArrayList<Contato>()
                for (contatoItem in contatos ) {
                    val contato = contatoItem.value ?: Contato()
                    val key = contatoItem.key
                    listaContatos.add(contato)
                }
                Log.d("AGENDA", "Contatos foram lidos com sucesso")
                sucesso( listaContatos )
            }
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA", "Erro ao salvar o contato", e)
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

}