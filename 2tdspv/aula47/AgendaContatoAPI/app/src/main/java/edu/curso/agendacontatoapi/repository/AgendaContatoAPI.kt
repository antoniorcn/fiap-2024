package edu.curso.agendacontatoapi.repository

import android.widget.Toast
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

//class AgendaContatoAPI {
//    val BASE_URL = "https://tdspv-9707b-default-rtdb.firebaseio.com"
//    // Acesso a API
//    val cliente = OkHttpClient()
//    val gson = Gson()
//
//    fun gravar() {
//        // Acesso a API
//        val contatoJson = """
//                {
//                    "nome": "${edtNome.text}",
//                    "email": "${edtEmail.text}",
//                    "telefone: "${edtTelefone.text}"
//                }
//            """.trimIndent()
//        val request = Request.Builder()
//            .url("$BASE_URL/contatos.json")
//            .post(contatoJson.toRequestBody(
//                "application/json".toMediaType()
//            ))
//            .build()
//        val response = object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                TODO("Not yet implemented")
//            }
//            override fun onResponse(call: Call, response: Response) {
//                runOnUiThread {
//                    // Informação de tela
//                    Toast.makeText(
//                        this@AgendaContatoActivity,
//                        "Contato gravado",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            }
//        }
//        cliente.newCall(request).enqueue(response)
//    }
//
//}