package edu.curso.agendacontatowebapi

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

class ContatoActivity : Activity() {
    lateinit var edtNome : EditText
    lateinit var edtEmail : EditText
    lateinit var edtTelefone : EditText
    val gson = Gson()
    val httpClient = OkHttpClient()
    val URL_BASE = "https://tdsr-61a49-default-rtdb.firebaseio.com"
    val lista = ArrayList<Contato>()
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_form_activity_layout)

        edtNome = findViewById(R.id.edt_nome)
        edtEmail = findViewById(R.id.edt_email)
        edtTelefone = findViewById(R.id.edt_telefone)

        lerFirebase()

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        btnGravar.setOnClickListener {
            val contato = gerarContato()
            gravarFirebase( contato )
        }
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)
        btnPesquisar.setOnClickListener {
            pesquisar()
        }
    }

    fun contatoParaTela( contato : Contato ) {
        edtNome.setText(contato.nome)
        edtEmail.setText(contato.email)
        edtTelefone.setText(contato.telefone)
    }

    fun pesquisar() {
        for (contato in lista) {
            if (contato.nome.contains( edtNome.text.toString() )) {
                contatoParaTela( contato )
                break
            }
        }
    }

    fun gerarContato() : Contato {
        val contato = Contato(
            nome = edtNome.text.toString(),
            telefone = edtTelefone.text.toString(),
            email = edtEmail.text.toString()
        )
        return contato
    }

    fun gravarFirebase( contato : Contato ) {
        val contatoJson = gson.toJson( contato )
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .post(contatoJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()
        val response = object : Callback {
            override fun onResponse(call : Call, response : Response) {
                Log.d("AGENDA", "Contato gravado com sucesso")
                lerFirebase()
            }

            override fun onFailure(call : Call, e : IOException) {
                Log.e("AGENDA",
                    "Erro ao gravar o contato ${e.message}", e)
            }
        }
        httpClient.newCall(request).enqueue(response)
    }

    fun lerFirebase() {
        val request = Request.Builder()
            .url("$URL_BASE/contatos.json")
            .get()
            .build()
        val response = object : Callback {
            override fun onResponse( call : Call, response : Response ) {
                val corpo = response.body?.string()
                if (corpo != null && corpo != "null") {
                    val typeToken = object : TypeToken<HashMap<String?, Contato?>>(){}.type
                    val mapa : HashMap<String?, Contato?> = gson.fromJson( corpo, typeToken )
                    lista.clear()
                    Log.d("AGENDA", "Foram lidos ${mapa.size} contatos do Firebase")
                    for (elemento in mapa) {
                        if (elemento.value != null) {
                            // Adicionar este contato na lista
                            lista.add( elemento.value!! )
                        }
                    }
                }
            }
            override fun onFailure( call : Call, e : IOException) {
                Log.e("AGENDA",
                    "Erro ao carregar os contatos ${e.message}", e)
            }
        }
        httpClient.newCall(request).enqueue(response)
    }
}