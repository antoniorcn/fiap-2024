package edu.curso.agendacontato

import android.util.Log
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

    val httpClient = OkHttpClient()
    val gson = Gson()
    val URL_BASE = "https://tdspv-9707b-default-rtdb.firebaseio.com"

    fun salvarFirebase( contato : Contato, sucesso : () -> Unit, falha : () -> Unit ) {
        val contatoJson = gson.toJson( contato )
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post( contatoJson.toRequestBody(
                "application/json".toMediaType()) )
            .build()
        val response = object : Callback {
            override fun onResponse(call : Call, response : Response) {
                Log.i("AGENDA", "Contato gravado com sucesso")
                sucesso()
            }
            override fun onFailure( call : Call, e : IOException) {
                Log.e("AGENDA",
                    "Erro ${e.message} ao gravar o contato", e)
                falha()
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun lerContatosFirebase( sucesso : ( ArrayList<Contato> ) -> Unit,
                             falha : ( String ) -> Unit) {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()
        val response = object : Callback {
            override fun onFailure(call : Call, e : IOException) {
                Log.e("AGENDA",
                    "Erro ${e.message} ao ler os contatos do Firebase ", e)
                falha( e.message ?: "" )
            }
            override fun onResponse(call : Call, response : Response) {
                val contatosJson = response.body?.string()
                val listaContatos = ArrayList<Contato>()
                if (contatosJson != null && contatosJson != "null") {
                    val typeHash = object : TypeToken<HashMap<String?, Contato?>>(){}.type
                    val contatos : HashMap<String?, Contato?> =
                        gson.fromJson(contatosJson, typeHash)
                    for (item in contatos) {
                        if (item.value != null) {
                            val contato = item.value
                            listaContatos.add(contato!!)
                        }
                    }
                }
                Log.i("AGENDA", "Lista de Contatos carregados: $listaContatos")
                sucesso(listaContatos)
            }
        }
        httpClient.newCall(request).enqueue(response)
    }
}