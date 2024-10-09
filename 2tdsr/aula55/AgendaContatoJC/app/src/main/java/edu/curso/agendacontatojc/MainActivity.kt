package edu.curso.agendacontatojc

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import edu.curso.agendacontatojc.ui.theme.AgendaContatoJCTheme
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Formulario( this )
        }
    }
}
@Composable
fun Formulario( contexto : ComponentActivity ) {
    val URL_BASE = "https://tdsr-61a49-default-rtdb.firebaseio.com"
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("")}
    var telefone by remember { mutableStateOf("")}

    val gson = Gson()
    val httpClient = OkHttpClient()

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Agenda de Contato", fontSize = 32.sp)
        OutlinedTextField(
            value = nome,
            onValueChange = {nome=it},
            label = {
                Text("Nome Completo")
            })
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = {
                Text("Endereço de e-mail")
            })
        OutlinedTextField(
            value = telefone,
            onValueChange = {telefone=it},
            label = {
                Text("(DDD) Telefone")
            })
        Button(onClick = {
            val contato = Contato(nome, email, telefone)
            Log.d("AGENDA", "Contato: $contato")
            val contatoJson = gson.toJson(contato)

            val request = Request.Builder()
                .url("$URL_BASE/contatos.json")
                .post(contatoJson.toRequestBody(
                    "application/json".toMediaType()
                ))
                .build()
            val response = object : Callback {
                override fun onResponse(call : Call, response : Response) {
                    contexto.runOnUiThread {
                        Toast.makeText(contexto, "Contato gravado com sucesso", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                override fun onFailure(call : Call, e : IOException) {
                    contexto.runOnUiThread {
                        Toast.makeText(contexto, "Erro ${e.message} ao gravar o contato", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
            httpClient.newCall(request).enqueue(response)
        }) {
            Text("Gravar")
        }
    }
}
