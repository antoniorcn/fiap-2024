package edu.curso.agendacontato.ui

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class ContatoRepository {
    private val URL_BASE = "https://tdsr-61a49-default-rtdb.firebaseio.com"
    private val gson = Gson()
    private val httpClient = OkHttpClient()

    fun adicionarContatoFirebase(contato : Contato,
                                 onSucesso : () -> Unit, onFalha : (IOException) -> Unit) {
        val contatoJson = gson.toJson(contato)
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post(contatoJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()
        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                Log.d("AGENDA", "Contato salvo com sucesso")
                onSucesso()
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("AGENDA", "Erro ${e.message} ao salvar o contato")
                onFalha( e )
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun lerTodosFirebase(lista: SnapshotStateList<Contato>) {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()
        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val contatosJson = response.body?.string()
                Log.d("AGENDA", "Lido $contatosJson")
                val mapType = object: TypeToken<HashMap<String?, Contato?>>(){}.type
                val contatoMap : HashMap<String?, Contato?> =
                        gson.fromJson(contatosJson,  mapType)
                lista.clear()
                for (entry in contatoMap) {
                    if (entry.value != null) {
                        val contato = entry.value!!
                        lista.add(contato)
                        Log.d("AGENDA", "Adicionando contato: $contato")
                    }
                }
                Log.d("AGENDA", "A lista ficou com ${lista.size} contatos")
            }
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA", "Erro  ${e.message} ao ler os contatos", e)
            }
        }
        httpClient.newCall(request).enqueue(response)
    }
}