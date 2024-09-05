package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.agendacontato.databinding.AgendaContatoLayoutBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException
import edu.curso.agendacontato.model.Contato

class AgendaContatoActivity : Activity() {

    private lateinit var binding : AgendaContatoLayoutBinding

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        binding = AgendaContatoLayoutBinding.inflate( layoutInflater )
        binding.contato = Contato(nome="João",
            telefone="(11)",
            email="joao@teste.com")
        setContentView(binding.root)
        val client = OkHttpClient()
        val gson = Gson()
//
//        val edtNome = findViewById<EditText>(R.id.edt_nome)
//        val edtEmail = findViewById<EditText>(R.id.edt_email)
//        val edtTel = findViewById<EditText>(R.id.edt_telefone)
//
//        val btnGravar = findViewById<Button>(R.id.btn_gravar)
//        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)

        val url = "https://tdsph-ee91f-default-rtdb.firebaseio.com/agenda.json"

        binding.apply {
            btnGravar.setOnClickListener {
                val jsonContato = """
            { 
                "nome": "${edtNome.text}",
                "email": "${edtEmail.text}",
                "telefone": "${edtTelefone.text}"
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
                        val textoJson = localBody?.string()
                        Log.i("AGENDA-CONTATO", "" + textoJson)
                        // Tipo do Hashmap para converter o texto JSON para este Map
                        val type = object : TypeToken<HashMap<String?, Contato?>?>() {}.type
                        // Converte o texto Json para o HashMap
                        try {
                            val elemento: HashMap<String?, Contato?> =
                                gson.fromJson(textoJson, type)

                            runOnUiThread {
                                elemento.values.forEach {
                                    // Para cada valor no Hashmap, pega o Contato na variavel
                                    // it e coloca os dados na tela
                                    Log.v("AGENDA-CONTATO", it.toString())
                                    if (it != null) {
                                        contato?.nome = it.nome
                                        contato?.telefone = it.telefone
                                        contato?.email = it.email
                                    }
                                    // edtNome.setText(it?.nome)
                                    // edtTelefone.setText(it?.telefone)
                                    // edtEmail.setText(it?.email)
                                }

                                val toast = Toast.makeText(
                                    this@AgendaContatoActivity,
                                    "Pesquisa feita com sucesso", Toast.LENGTH_LONG
                                )
                                toast.show()
                            }
                        } catch (err : Exception) {
                            runOnUiThread {
                                val toast = Toast.makeText(
                                    this@AgendaContatoActivity,
                                    "Contato não encontrado", Toast.LENGTH_LONG
                                )
                                toast.show()
                            }
                        }
                    }
                }
                client.newCall(request).enqueue(response)
            }

            btnLista.setOnClickListener {
                val intent = Intent(this@AgendaContatoActivity, AgendaListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}