package edu.curso.carrosusados.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.carrosusados.R
import edu.curso.carrosusados.model.Carro
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class CarroActivity : Activity() {

    val lista = ArrayList<Carro>()
    lateinit var edtMarca : EditText
    lateinit var edtModelo : EditText
    lateinit var edtPlaca : EditText
    lateinit var edtAno : EditText

    private val cliente = OkHttpClient()
    private val gson = Gson()
    val URLBASE = "https://tdsr-61a49-default-rtdb.firebaseio.com"

    fun gravarLista() {
        val carro = Carro(
            edtMarca.text.toString(),
            edtModelo.text.toString(),
            edtPlaca.text.toString(),
            edtAno.text.toString().toInt()
        )
        // carro.marca = edtMarca.text.toString()
        lista.add( carro )
        Toast.makeText(this,
            "Carro foi gravado com sucesso",
            Toast.LENGTH_LONG).show()
        edtMarca.text.clear()
        edtModelo.text.clear()
        edtPlaca.text.clear()
        edtAno.text.clear()

    }

    fun pesquisarLista() {
        for (carro in lista) {
            if (carro.placa.contains(edtPlaca.text.toString())) {
                edtMarca.setText(carro.marca)
                edtModelo.setText(carro.modelo)
                edtPlaca.setText(carro.placa)
                edtAno.setText(carro.ano.toString())
                break;
            }
        }
    }

    fun gravarFirebase() {
        val carro = Carro(
            edtMarca.text.toString(),
            edtModelo.text.toString(),
            edtPlaca.text.toString(),
            edtAno.text.toString().toInt()
        )
        val carroJson = gson.toJson(carro)
        val request = Request.Builder()
            .url("$URLBASE/carros.json")
            .post(carroJson.toRequestBody(
                "application/json".toMediaType()
            ))
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(
                        this@CarroActivity,
                        "Erro ${e.message} ao gravar o carro",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {
                    Toast.makeText(
                        this@CarroActivity,
                        "Carro gravado com sucesso",
                        Toast.LENGTH_LONG
                    ).show()
                    edtMarca.text.clear()
                    edtModelo.text.clear()
                    edtPlaca.text.clear()
                    edtAno.text.clear()
                }
            }
        }
        cliente.newCall(request).enqueue(response)
    }

    fun pesquisarFirebase() {
        val request = Request.Builder()
            .url("$URLBASE/carros.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(
                        this@CarroActivity,
                        "Erro ${e.message} ao pesquisar o carro",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            override fun onResponse(call: Call, response: Response) {
                val reponseJson = response.body?.string()?:""
                val tipo = object : TypeToken<HashMap<String?, Carro?>>(){}.type
                val carros : HashMap<String, Carro> =
                    gson.fromJson(reponseJson, tipo)
                for (carro in carros.values) {
                    if (carro.placa.contains(edtPlaca.text.toString())) {
                        runOnUiThread {
                            edtMarca.setText(carro.marca)
                            edtModelo.setText(carro.modelo)
                            edtPlaca.setText(carro.placa)
                            edtAno.setText(carro.ano.toString())
                        }
                        break
                    }
                }
            }
        }
        cliente.newCall(request).enqueue(response)
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.carros_usados_form_layout)

        edtMarca = findViewById<EditText>(R.id.edt_marca)
        edtModelo = findViewById<EditText>(R.id.edt_modelo)
        edtPlaca = findViewById<EditText>(R.id.edt_placa)
        edtAno = findViewById<EditText>(R.id.edt_ano)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)

        btnGravar.setOnClickListener {
            // gravarLista()
            gravarFirebase()
        }

        btnPesquisar.setOnClickListener {
           // pesquisarLista()
            pesquisarFirebase()
        }
    }
}