package edu.curso.agendacontato.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.agendacontato.model.Contato
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class ContatoRepositorio {
    val URL_BASE = "https://tdspv-9707b-default-rtdb.firebaseio.com"
    val clienteHttp = OkHttpClient()
    val gson = Gson()

    fun gravar(contato : Contato) {
        val contatoJson = gson.toJson(contato)
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post(contatoJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()
        val response = object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AGENDA", "Erro ao gravar o contato", e)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("AGENDA", "Contato gravado com sucesso")
            }
        }
        clienteHttp.newCall(request).enqueue(response)
    }

    fun pesquisar(nomeAPesquisar : String = "", onSucesso : ( contato : Contato ) -> Unit, onErro : () -> Unit) {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()
        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onErro()
            }
            override fun onResponse(call: Call, response: Response) {
                val contatoJson = response.body?.string() ?: "[]"
                val token = object : TypeToken<HashMap<String?, Contato?>>(){}.type
                val mapa : HashMap<String?, Contato?> = gson.fromJson(contatoJson, token)
                if (mapa.size > 0) {
                    for (contato in mapa.values) {
                        if (contato != null && contato.nome.contains(nomeAPesquisar)) {
                            onSucesso(contato)
                            break
                        }
                    }
                } else {
                    onSucesso(Contato())
                }
            }
        }
        clienteHttp.newCall(request).enqueue(response)
    }
}