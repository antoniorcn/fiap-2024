package edu.curso.agendacontatoapi

import android.app.Activity
import android.os.Bundle
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
    val URL_FIREBASE = "https://tdsr-61a49-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.agenda_contato)

        val client = OkHttpClient()

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
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
                .url("$URL_FIREBASE/contatos.json")
                .post(
                    contatoJson
                        .toRequestBody(
                            "application/json".toMediaType()
                        )
                )
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    TODO("Not yet implemented")
                }
                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato gravado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            client.newCall(request).enqueue(response)
        }

    }
}