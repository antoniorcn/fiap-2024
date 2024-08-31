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
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class AgendaContatoActivity : Activity() {
    val FIREBASE_URL = "https://tdspv-9707b-default-rtdb.firebaseio.com"
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)

        val client = OkHttpClient()

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)

        btnGravar.setOnClickListener {
            val txtJson = """
                {
                    "nome": "${edtNome.text}",
                    "email": "${edtEmail.text}",
                    "telefone": "${edtTelefone.text}"
                }
            """.trimIndent()
            Log.v("AGENDA", txtJson)

            // Limpar Campos
            edtNome.setText("")
            edtEmail.setText("")
            edtTelefone.setText("")

            // Montando o Body baseado no texto JSON construido
            // para ser encaminhado no Request
            val body = txtJson.toRequestBody(
                "application/json".toMediaType()
            )

            // Criação do Request indicando a URL e o método que é POST
            // O metodo POST necessita de um body, que foi criado anteriormente
            val request = Request.Builder()
                .url("$FIREBASE_URL/contatos.json")
                .post(body)
                .build()

            // Aguarda a resposta, e executa uma das funções dependendo do resultado
            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(this@AgendaContatoActivity,
                        "Erro ${e.message} ao gravar o contato", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    // Executa na Thread da tela
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato cadastrado com sucesso", Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            // Encaminha o request para a API Web pode meio de uma Thread diferente
            // da Thread de tela e assim que tiver a resposta, vai executar a
            // função correspondente no Callback de acordo com o resultado (Ok ou Falha)
            client.newCall(request).enqueue(response)
        }

        btnPesquisar.setOnClickListener {

            val url = "$FIREBASE_URL/contatos.json?orderBy=\"nome\"&equalTo=\"${edtNome.text}\""

            val request = Request.Builder()
                .url(url)
                .get()
                .build()

            val response = object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    runOnUiThread {
                        Toast.makeText(this@AgendaContatoActivity,
                            "Erro ${e.message} ao consultar o contato", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onResponse(call: Call, response: Response) {
                    val body = response.body
                    val textoResposta = body?.string()
                    Log.v("AGENDA", "Texto: $textoResposta")
                    runOnUiThread {
                        Toast.makeText(this@AgendaContatoActivity,
                            "Pesquisa efetuada com sucesso", Toast.LENGTH_LONG).show()
                    }
                }
            }
            client.newCall(request).enqueue(response)
        }

    }
}