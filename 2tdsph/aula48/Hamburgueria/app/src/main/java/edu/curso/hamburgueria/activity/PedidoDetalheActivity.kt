package edu.curso.hamburgueria.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.curso.hamburgueria.R
import edu.curso.hamburgueria.model.Pedido
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class PedidoDetalheActivity : Activity() {
    private val BASE_URL = "https://tdsph-ee91f-default-rtdb.firebaseio.com"
    private val lista = ArrayList<Pedido>()
    private val cliente = OkHttpClient()
    private val gson = Gson()
    private var indice : Int = 0
    private lateinit var txtNome : TextView
    private lateinit var txtQuantidade : TextView
    private lateinit var txtPreco : TextView
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.pedido_detalhes_layout)

        txtNome = findViewById<TextView>(R.id.txt_nome)
        txtQuantidade = findViewById<TextView>(R.id.txt_quantidade)
        txtPreco = findViewById<TextView>(R.id.txt_preco)


        val btnAnterior = findViewById<Button>(R.id.btn_anterior)
        val btnProximo = findViewById<Button>(R.id.btn_proximo)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        val request = Request.Builder()
            .url("$BASE_URL/pedidos.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@PedidoDetalheActivity,
                        "Erro ${e.message} ao ler os pedidos",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseTexto = response.body?.string()
                val pedidosJson = responseTexto?:"{}"
                Log.d("HAMBURGUERIA", "Reponse: $responseTexto")

                val tipo = object : TypeToken<HashMap<String?, Pedido?>?>() {}.type
                val todosPedidos: HashMap<String?, Pedido?> =
                        gson.fromJson(pedidosJson, tipo)

                lista.clear()
                for (pedido in todosPedidos.values) {
                    if (pedido != null) {
                        lista.add(pedido)
                    }
                }
                runOnUiThread {
                    showItem()
                }
            }
        }
        cliente.newCall(request).enqueue(response)

        Log.v("HAMBURGUERIA", "Lista: $lista")
        btnAnterior.setOnClickListener {
            if (indice > 0) {
                indice--
            }
            showItem()
        }

        btnProximo.setOnClickListener {
            if (indice < lista.size) {
                indice++
            }
            showItem()
        }

        btnVoltar.setOnClickListener {
            val intent = Intent(this, PedidoActivity::class.java)
            startActivity(intent)
        }
    }

    fun showItem() : Unit {
        if (lista.size > indice) {
            val pedidoAtual = lista.get(indice)
            txtNome.text = pedidoAtual.nome
            txtQuantidade.text = pedidoAtual.quantidade.toString()
            txtPreco.text = pedidoAtual.preco.toString()
        }
    }
}