package edu.curso.agendacontato

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import edu.curso.agendacontato.ui.theme.AgendaContatoTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class MainActivity : ComponentActivity() {
    val URL_BASE = "https://identitytoolkit.googleapis.com/v1"
    val API_KEY = "PREENCHER SUA API_KEY"
    val httpClient = OkHttpClient()
    val gson = Gson()
    var pref : SharedPreferences? = null
    val token = mutableStateOf<String>("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = getSharedPreferences(
            "CONTATO", Context.MODE_PRIVATE)
        token.value = pref?.getString("TOKEN", "") ?: ""
        setContent {
            val nome = remember { mutableStateOf("") }
            AgendaContatoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    if (token.value.length > 5) {
                        ContactAgendaScreen(nome,
                            onGravar = {
                                pref?.edit()?.putString("NOME", nome.value)?.apply()
                            },
                            onPesquisar = {
                                nome.value =
                                    pref?.getString("NOME", "") ?: ""
                            })
                    } else {
                        Login( onRegistrar = { email, senha ->
                            registrarFirebase(email, senha)
                        })
                    }
                }
            }
        }
    }

    fun registrarFirebase(email : String, senha : String) {
        val registroJson = """
            { "email": "$email",
              "password": "$senha",
              "returnSecureToken": true
             }
        """.trimIndent().toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url("$URL_BASE/accounts:signUp?key=$API_KEY")
            .post(registroJson)
            .build()

        val response = object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val resposta = response.body?.string()
                val registroResp : RegistroResposta =
                        gson.fromJson(resposta, RegistroResposta::class.java)
                Log.d("AGENDA", "Token: ${registroResp.idToken}")
                if (response.code in 200..299) {
                    pref?.edit()?.putString("TOKEN", registroResp.idToken)?.apply()
                    token.value = registroResp.idToken
                    runOnUiThread{
                        Toast.makeText(this@MainActivity,
                            "Registrado com Sucesso", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread{
                    Toast.makeText(this@MainActivity,
                        "Erro ao registrar no firebase", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
        httpClient.newCall(request).enqueue(response)
    }
}

@Preview(showBackground = true)
@Composable
fun TesteLogin() {
    Login(onRegistrar = {email, senha -> })
}


@Composable
fun Login(onRegistrar : (String, String) -> Unit ) {
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }

    Column(modifier=Modifier.fillMaxSize()) {
        Text("Login", fontSize=38.sp)
        Row() {
            Text("Email")
            OutlinedTextField(value = email.value, onValueChange={
                email.value = it
            })
        }
        Row() {
            Text("Senha")
            OutlinedTextField(value = senha.value, onValueChange={
                senha.value = it
            },
                visualTransformation = PasswordVisualTransformation()
            )
        }
        Row() {
            Button(onClick = {
                onRegistrar(email.value, senha.value)
            }) {
                Text("Registrar")
            }
            Button(onClick = {}) {
                Text("Login")
            }
        }
    }
}


@Composable
fun ContactAgendaScreen(nome: MutableState<String>,
                        onGravar : () -> Unit,
                        onPesquisar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(
            text = "Agenda de Contatos",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Campos de texto
        ContactInputField(label = "Nome Completo",
            value=nome.value, onValueChange = {nome.value = it})
        Spacer(modifier = Modifier.height(16.dp))
        ContactInputField(label = "Email",
            value="", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        ContactInputField(label = "Telefone",
            value = "", onValueChange = {})

        // Espaço entre os campos de texto e os botões
        Spacer(modifier = Modifier.height(32.dp))

        // Botões
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ActionButton(text = "Gravar", onClick=onGravar)
            ActionButton(text = "Pesquisar", onClick=onPesquisar)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactInputField(label: String,
                      value : String,
                      onValueChange : (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label, color = Color.Red)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(12.dp), // Borda arredondada
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color(0xFFFFF176), // Fundo amarelo claro
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = Color.Black
        )
    )
}

@Composable
fun ActionButton(text: String, onClick : () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.height(35.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E88E5), // Cor azul dos botões
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewContactAgendaScreen() {
//    ContactAgendaScreen(nome)
//}