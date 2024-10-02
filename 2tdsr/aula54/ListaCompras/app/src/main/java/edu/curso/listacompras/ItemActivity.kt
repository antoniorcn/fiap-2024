package edu.curso.listacompras

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemActivity : AppCompatActivity() {
    val listaCompras = ArrayList<Item>()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.item_activity_layout)

        listaCompras.add(Item(0, "Detergente", 2.50, 4))
        listaCompras.add(Item(0, "Coca Cola 2L", 11.50, 1))
        listaCompras.add(Item(0, "Amaciante MonBiju 2L", 14.00, 1))
        listaCompras.add(Item(0, "Papel Higienico FD", 32.00, 1))
        listaCompras.add(Item(0, "Miojo", 2.30, 5))
        listaCompras.add(Item(0, "Sucrillos 1Kg", 23.00, 1))

        val rcvListaCompras =
            findViewById<RecyclerView>(R.id.rcv_lista_compras)
        rcvListaCompras.adapter = ItemAdapter(this, listaCompras)
        rcvListaCompras.layoutManager = LinearLayoutManager(this)
    }
}