package edu.curso.agendacontatoapi

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException


class AgendaContatoActivity : Activity() {
    val BASE_URL = "https://tdspv-9707b-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)

        val cliente = OkHttpClient()

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)


        btnGravar.setOnClickListener {
            val contatoJson = """
                {
                    "nome": "${edtNome.text}",
                    "email": "${edtEmail.text}",
                    "telefone: "${edtTelefone.text}"
                }
            """.trimIndent()
            val request = Request.Builder()
                .url("$BASE_URL/contatos.json")
                .post(contatoJson.toRequestBody(
                    "application/json".toMediaType()
                ))
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    TODO("Not yet implemented")
                }
                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato gravado",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            cliente.newCall(request).enqueue(response)
        }

        btnPesquisar.setOnClickListener {
            val request = Request.Builder()
                .url("$BASE_URL/contatos.json")
                .get()
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AGENDA",
                        "Erro: ${e.message} ao fazer a consulta")
                }
                override fun onResponse(call: Call, response: Response) {
                    Log.i("AGENDA",
                        "Resposta: ${response.body?.string()}")
                }
            }
            cliente.newCall(request).enqueue(response)
        }
    }
}