package edu.curso.agendacontatoapirest

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException


class AgendaContatoActivity : Activity() {

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_layout)
        val client = OkHttpClient()

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTel = findViewById<EditText>(R.id.edt_telefone)
        
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)

        val url = "https://tdsph-ee91f-default-rtdb.firebaseio.com/agenda.json"

        btnGravar.setOnClickListener {
            val jsonContato = """
            { 
                "nome": "${edtNome.text}",
                "email": "${edtEmail.text}",
                "telefone": "${edtTel.text}"
            }""".trimIndent()

            val mediaType = "application/json".toMediaTypeOrNull()
            val body = jsonContato.toRequestBody(mediaType)

            val request = Request.Builder()
                .url(url)
                .post(body)
                .build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AGENDA-CONTATO", e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val localBody = response.body
                    Log.i("AGENDA-CONTATO", "" + localBody?.string())
                    runOnUiThread {
                        val toast = Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato cadastrado com sucesso", Toast.LENGTH_LONG
                        )
                        toast.show()
                    }
                }
            }
            client.newCall(request).enqueue(response)
        }

        btnPesquisar.setOnClickListener {
            val query = "orderBy=\"nome\"&equalTo=\"${edtNome.text}\"&limitToLast=1"
            val request = Request.Builder()
                .url("$url?$query")
                .get()
                .build()
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("AGENDA-CONTATO", e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val localBody = response.body
                    Log.i("AGENDA-CONTATO", "" + localBody?.string())
                    runOnUiThread {
                        val toast = Toast.makeText(
                            this@AgendaContatoActivity,
                            "Pesquisa feita com sucesso", Toast.LENGTH_LONG
                        )
                        toast.show()
                    }
                }
            }
            client.newCall(request).enqueue(response)
        }
    }
}