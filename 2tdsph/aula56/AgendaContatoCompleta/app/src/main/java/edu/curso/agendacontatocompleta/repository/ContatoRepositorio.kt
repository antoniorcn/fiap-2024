package edu.curso.agendacontatocompleta.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.agendacontatocompleta.model.Contato
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class ContatoRepositorio {
    val URL_BASE = "https://tdsph-ee91f-default-rtdb.firebaseio.com"
    val httpClient = OkHttpClient()
    val gson = Gson()
    fun gravar( c : Contato, onSucesso : () -> Unit, onFalha : () -> Unit ) {
        val contatoJson = gson.toJson(c)
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post(contatoJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()
        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                Log.d("AGENDA", "Contato gravado com sucesso");
                onSucesso();
            }
            override fun onFailure(call : Call, e : IOException) {
                Log.e("AGENDA", "Erro ao gravar o contato ${e.message}", e)
                onFalha();
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun pesquisar(parteNome : String, onSucesso: ( Contato ) -> Unit, onFalha : () -> Unit) {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onResponse( call : Call, response : Response ){
                val contatosJson = response.body?.string()
                if (contatosJson != null && contatosJson != "null") {
                    val token = object : TypeToken<HashMap<String?, Contato?>>(){}.type
                    val map : HashMap<String?, Contato?> = gson.fromJson(contatosJson, token)
                    for (item in map) {
                        val contato = item.value
                        if (contato != null) {
                            if (contato.nome.contains(parteNome)) {
                                Log.i("AGENDA", "Contato encontrado: ")
                                Log.i("AGENDA", contato.toString())
                                onSucesso( contato )
                                break
                            }
                        }
                    }
                }
            }
            override fun onFailure( call : Call, e : IOException) {
                Log.e("AGENDA", "Erro ao pesquisar o contato ${e.message}", e)
                onFalha()
            }
        }
        httpClient.newCall(request).enqueue(response)
    }
}