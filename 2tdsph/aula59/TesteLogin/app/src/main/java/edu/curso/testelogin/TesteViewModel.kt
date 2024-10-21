package edu.curso.testelogin

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class TesteViewModel : ViewModel() {

    val URL_AUTH_BASE="https://identitytoolkit.googleapis.com/v1"

    var token : MutableState<String> = mutableStateOf<String>("")
    var email : MutableState<String> = mutableStateOf<String>("")
    var senha : MutableState<String> = mutableStateOf<String>("")

    val httpClient = OkHttpClient()
    val gson = Gson()

    fun registrar() {
        val usuarioJson = """ {
            "email":"${email.value}",
            "password":"${senha.value}",
            "returnSecureToken": true
        }""".trimIndent()

        val request = Request.Builder()
            .url("$URL_AUTH_BASE/accounts:signUp?key=${BuildConfig.API_KEY}")
            .post( usuarioJson.toRequestBody(
                "application/json".toMediaType()))
            .build()
        val response = object : Callback {
            override fun onFailure(call : Call, e : IOException) {
                Log.e("TESTE", "Erro ${e.message} ao fazer o registro", e)
            }
            override fun onResponse(call : Call, resp : Response) {
                val corpo = resp.body?.string()
                Log.d("TESTE", "Registro com sucesso: $corpo")
                if (corpo != null && corpo != "null") {
                    val signupResponse = gson
                        .fromJson(corpo, SignUpResponseDTO::class.java)
                    token.value = signupResponse.idToken
                    Log.d("TESTE", "Token recebido: ${token.value}")
                }
            }
        }
        httpClient.newCall(request).enqueue(response)
    }
}