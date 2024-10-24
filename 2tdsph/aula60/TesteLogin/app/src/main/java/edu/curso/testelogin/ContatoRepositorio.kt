package edu.curso.testelogin

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ContatoRepositorio {
    private val BASE_URL = "https://tdsph-ee91f-default-rtdb.firebaseio.com"
    private val httpClient = OkHttpClient()
    private val gson = Gson()

    fun lerFirebase(lista: SnapshotStateList<Contato>) {
        val request = Request.Builder()
            .url("$BASE_URL/contatos.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("AGENDA", "Erro ao ler os contato do firebase")
            }

            override fun onResponse(call: Call, response: Response) {
                val corpo = response.body?.string() ?: ""
                Log.d("AGENDA", "Contato do firebase lidos: $corpo")
                if (corpo != "" && corpo != "null") {
                    val typeToken = object : TypeToken<HashMap<String?, Contato?>>(){}.type
                    val mapContato : HashMap<String?, Contato?> = gson.fromJson(corpo, typeToken)
                    lista.clear()
                    for (item in mapContato) {
                        if (item.value != null) {
                            lista.add(item.value!!)
                        }
                    }
                }
            }
        }

        httpClient.newCall(request).enqueue(response)

    }



}