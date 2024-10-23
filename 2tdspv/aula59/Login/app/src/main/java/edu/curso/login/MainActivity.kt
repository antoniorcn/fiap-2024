package edu.curso.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import edu.curso.login.ui.theme.LoginTheme
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class MainActivity : ComponentActivity() {
    val email = mutableStateOf<String>("")
    val senha = mutableStateOf<String>("")
    val APIKEY = "AIzaSyAPsT_7KdOxKAi7mNERSMJgJQ-gnINawpo"
    val URL_BASE = "https://identitytoolkit.googleapis.com/v1"

    val httpClient = OkHttpClient()
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lerEmail()
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LoginScreen(email, senha, onGravar = {
                        gravarEmail()
                        registrar()
                    })
                }
            }
        }
    }
    fun gravarEmail() {
        val prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        prefs
            .edit()
            .putString("EMAIL", email.value)
            .apply()
    }

    fun registrar() {
        val url = "$URL_BASE/v1/accounts:signUp?key=$APIKEY"
        Log.d("URL: $url")
        val request = Request.Builder()
            .url(url)
            .post("""
                {   "email": "${email.value}",
                    "password": "${senha.value}",
                    "returnSecureToken": true
                }
            """ .trimIndent()
                .toRequestBody("application/json".toMediaType()))
            .build()

        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                Log.d("LOGIN", "Registrado com sucesso ${response.body?.string()}")
                runOnUiThread {
                    Toast.makeText(this@MainActivity,
                        "Registrado com sucesso",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity,
                        "Erro ao registrar no firebase",
                        Toast.LENGTH_LONG).show()
                }
            }
        }

        httpClient.newCall(request).enqueue(response)

    }

    fun lerEmail() {
        val prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        email.value = prefs.getString("EMAIL", "") ?: ""
    }
}
@Composable
fun LoginScreen(email: MutableState<String>,
                senha: MutableState<String>,
                onGravar : () -> Unit) {
    // Definir um layout em coluna centralizado
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título "Login"
        Text(
            text = "Login",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Campo de texto para "Email"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "email", fontSize = 18.sp, modifier = Modifier.padding(end = 16.dp))
            TextField(
                value = email.value,
                onValueChange = { texto ->
                    email.value = texto
                },
                modifier = Modifier
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Green.copy(alpha = 0.6f),
                                Green
                            )
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para "Senha"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "senha", fontSize = 18.sp, modifier = Modifier.padding(end = 16.dp))
            TextField(
                value = senha.value,
                onValueChange = {
                    senha.value = it
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Green.copy(alpha = 0.6f),
                                Green
                            )
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botões "Registrar" e "Logar"
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { onGravar() },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Registrar")
            }
            Button(
                onClick = { /* Ação de logar */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = "Logar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val email = remember { mutableStateOf("")}
    val senha = remember { mutableStateOf("")}
    LoginScreen(email, senha, onGravar={})
}