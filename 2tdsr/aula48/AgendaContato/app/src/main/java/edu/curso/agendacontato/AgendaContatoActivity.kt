package edu.curso.agendacontato

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoActivity : Activity() {
    val BASE_URL = "https://tdsr-61a49-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato)

        val cliente = OkHttpClient()

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val btnGravar = findViewById<Button>(R.id.btnGravar)
        val btnPesquisar = findViewById<Button>(R.id.btnPesquisar)

        btnGravar.setOnClickListener {
            val contatoJson = """
                {
                    "nome": "${edtNome.text}",
                    "email": "${edtEmail.text}",
                    "telefone": "${edtTelefone.text}"
                }
            """.trimIndent()
            val request = Request.Builder()
                .url("$BASE_URL/contatos.json")
                .post(
                    contatoJson.toRequestBody(
                        "application/json".toMediaType()
                    )
                )
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Erro: ${e.message} ao gravar o contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato gravado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                        edtNome.setText("")
                        edtEmail.setText("")
                        edtTelefone.setText("")
                    }
                }
            }
            cliente.newCall(request).enqueue(response)
        }

        btnPesquisar.setOnClickListener {
            val request = Request.Builder()
                .url("$BASE_URL/contatos.json?orderBy=\"nome\"&equalTo=\"${edtNome.text}\"")
                .get()
                .build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AGENDA", "Erro: ${e.message} ao acessar o Firebase")
                }
                override fun onResponse(call: Call, response: Response) {
                    Log.v("AGENDA", "Resposta: ${response.body?.string()}")
                }
            }
            cliente.newCall(request).enqueue(response)
        }
    }
}