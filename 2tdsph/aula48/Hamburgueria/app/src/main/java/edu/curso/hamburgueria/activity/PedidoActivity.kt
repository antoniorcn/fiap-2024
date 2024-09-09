package edu.curso.hamburgueria.activity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import edu.curso.hamburgueria.R
import edu.curso.hamburgueria.model.Pedido
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class PedidoActivity : Activity() {
    val BASE_URL = "https://tdsph-ee91f-default-rtdb.firebaseio.com"
    val lista = ArrayList<Pedido>()
    val cliente = OkHttpClient()
    val gson = Gson()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.pedido_form_layout)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtPreco = findViewById<EditText>(R.id.edt_preco)
        val edtQuantidade = findViewById<EditText>(R.id.edt_quantidade)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)
        val btnPedidosFeitos = findViewById<Button>(R.id.btn_pedidos_feitos)

        btnGravar.setOnClickListener {
            val pedido = Pedido()
            pedido.nome = edtNome.text.toString()
            try {
                pedido.quantidade = edtQuantidade.text.toString().toUInt()
                pedido.preco = edtPreco.text.toString().toDouble()
                lista.add(pedido)

                val pedidoJson = gson.toJson( pedido )

                val request = Request.Builder()
                    .url("$BASE_URL/pedidos.json")
                    .post(pedidoJson
                        .toRequestBody("application/json".toMediaType()))
                    .build()

                val response = object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.e("HAMBURGUERIA", "Erro: ${e.message}", e)
                        runOnUiThread {
                            Toast.makeText(
                                this@PedidoActivity,
                                """Erro ${e.message} ao gravar o pedido""",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onResponse(call: Call, response: Response) {
                        runOnUiThread {
                            Toast.makeText(
                                this@PedidoActivity,
                                """Pedido gravado com sucesso""",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
                cliente.newCall(request).enqueue(response)
            } catch( err : NumberFormatException) {
                Log.e("HAMBURGUERIA", "Erro: ${err.message}", err)
                Toast.makeText(this,
                    """A informação sobre quantidade e preço precisam ser 
                        números positivos""",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnPesquisar.setOnClickListener {
            val nome = edtNome.text.toString()
            for (pedido in lista) {
                if (pedido.nome.contains( nome )) {
                    edtNome.setText(pedido.nome)
                    edtQuantidade.setText(pedido.quantidade.toString())
                    edtPreco.setText(pedido.preco.toString())
                    break
                }
            }
        }

        btnPedidosFeitos.setOnClickListener {
            val intent = Intent(this, PedidoDetalheActivity::class.java)
//            val extra = Bundle()
//            intent.putExtras( extra )
            startActivity( intent )
        }
    }
}