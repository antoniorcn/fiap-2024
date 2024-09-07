package edu.curso.agendacontatoapi

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

data class Contato(
    var nome : String = "",
    var telefone : String = "",
    var email : String = "",
)

class AgendaContatoActivity : Activity() {
    val BASE_URL = "https://tdspv-9707b-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        // Informação de tela
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)

        // Acesso a API
        val cliente = OkHttpClient()
        val gson = Gson()

        // Informação de tela
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)


        btnGravar.setOnClickListener {
            // Acesso a API
            // val contatoJson = """{ "nome": "${edtNome.text}", "email": "${edtEmail.text}", "telefone: "${edtTelefone.text}"}""".trimIndent()
            val contato = Contato(nome=edtNome.text.toString(),
                    telefone=edtTelefone.text.toString(),
                email=edtEmail.text.toString())
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
                    TODO("Not yet implemented")
                }
                override fun onResponse(call: Call, response: Response) {
                    val resposta = response.body?.string()
                    Log.d("AGENDA", "Resposta: $resposta")
                    runOnUiThread {
                        // Informação de tela
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato gravado $resposta",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            cliente.newCall(request).enqueue(response)
        }

        btnPesquisar.setOnClickListener {
            // Acesso a API
            val query = """orderBy="nome"&equalTo="${edtNome.text}"&limitToLast=1"""
            val request = Request.Builder()
                .url("$BASE_URL/contatos.json?$query")
                .get()
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AGENDA",
                        "Erro: ${e.message} ao fazer a consulta")
                }
                override fun onResponse(call: Call, response: Response) {
                    val respostaBody = response.body?.string()
                    Log.i("AGENDA",
                        "Resposta: $respostaBody")
                    var encontrou = false
                    if (respostaBody != null && respostaBody != "null") {
                        val type = object : TypeToken<HashMap<String, Contato>>() {}.type
                        val mapContatos: HashMap<String, Contato> =
                            gson.fromJson(respostaBody, type)

                        if (mapContatos.size > 0) {
                            encontrou = true
                            val c: Contato = mapContatos.values.elementAt(0)

                            runOnUiThread {
                                // Informação de tela
                                edtNome.setText(c.nome)
                                edtTelefone.setText(c.telefone)
                                edtEmail.setText(c.email)
                            }
                        }
                    }
                    if (!encontrou) {
                         runOnUiThread {
                             // Informação de tela
                            Toast.makeText(
                                this@AgendaContatoActivity,
                                "Não foi encontrado nenhum contato",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
            cliente.newCall(request).enqueue(response)
        }
    }
}