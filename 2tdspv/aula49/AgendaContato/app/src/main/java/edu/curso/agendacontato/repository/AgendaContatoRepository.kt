package edu.curso.agendacontato.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.agendacontato.activity.ActivityCallBack
import edu.curso.agendacontato.model.Contato
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoRepository() {
    val BASE_URL = "https://tdspv-9707b-default-rtdb.firebaseio.com"

    // Acesso a API
    val cliente = OkHttpClient()
    val gson = Gson()

    fun pesquisarContato( callback : ActivityCallBack) {
        // Acesso a API
        val request = Request.Builder()
            .url("$BASE_URL/contatos.json")
            .get()
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA",
                    "Erro: ${e.message} ao fazer a consulta")
                callback.falha()
            }
            override fun onResponse(call: Call, response: Response) {
                val respostaBody = response.body?.string()
                Log.i("AGENDA",
                    "Resposta: $respostaBody")
                if (respostaBody != null && respostaBody !in arrayOf("null", "{}")) {
                    val type = object : TypeToken<HashMap<String, Contato>>() {}.type
                    val mapContatos: HashMap<String, Contato> =
                        gson.fromJson(respostaBody, type)

                    val listaContatosStr = ArrayList<String>()

                    for (contato in mapContatos.values) {
                        val texto = "Nome: ${contato.nome}\tTel: ${contato.telefone}\nEmail: ${contato.email}"
                        listaContatosStr.add(texto)
                    }
                    callback.sucesso( listaContatosStr )
                } else {
                    callback.falha()
                }
            }
        }
        cliente.newCall(request).enqueue(response)
    }


    fun gravarContato( contato : Contato, callback : ActivityCallBack ) {
        val contatoJson = gson.toJson( contato )
        val request = Request.Builder()
            .url("$BASE_URL/contatos.json")
            .post(contatoJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()
        Log.d("AGENDA", "JSON: $contatoJson")
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.falha()
            }
            override fun onResponse(call: Call, response: Response) {
                val resposta = response.body?.string()
                Log.d("AGENDA", "Resposta: $resposta")
                callback.sucesso( null )
            }
        }
        cliente.newCall(request).enqueue(response)
    }
}