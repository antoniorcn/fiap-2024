package edu.curso.testelogin

import android.content.SharedPreferences
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

    var currentPrefs: MutableState<SharedPreferences?> = mutableStateOf(null)
    val URL_AUTH_BASE="https://identitytoolkit.googleapis.com/v1"

    var token : MutableState<String> = mutableStateOf("")
    var email : MutableState<String> = mutableStateOf("")
    var senha : MutableState<String> = mutableStateOf("")

    val httpClient = OkHttpClient()
    val gson = Gson()

    fun registrar() {
        val usuarioJson = """ {
            "email":"${email.value}",
            "password":"${senha.value}",
            "returnSecureToken": true
        }""".trimIndent()

        val URL = "$URL_AUTH_BASE/accounts:signUp?key=${BuildConfig.API_KEY}"
        Log.d("TESTE", "Url de acesso: $URL")
        val request = Request.Builder()
            .url(URL)
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
                    val prefs = currentPrefs.value
                    prefs?.edit()?.putString("TOKEN", token.value)?.apply()

                }
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun isLogged() : Boolean {
        token.value = if (token.value == "")
            currentPrefs.value?.getString("TOKEN", "").toString() else token.value
        return token.value != ""
    }
}