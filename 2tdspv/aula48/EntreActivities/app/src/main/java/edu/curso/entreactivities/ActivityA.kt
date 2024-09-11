package edu.curso.entreactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.Serializable

data class Contato(val nome : String = "", val email : String = "") : Serializable

class ActivityA : Activity() {

    private val lista = ArrayList<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.layout_a)

        val c1 = Contato("Joao Silva", "joao@teste.com")
        val c2 = Contato("Maria Silva", "maria@teste.com")
        val c3 = Contato("Alberto Silva", "alberto@teste.com")

        lista.add(c1)
        lista.add(c2)
        lista.add(c3)

        // Pega o Botão Ir para a ActivityB e o Edit Texto Digite Algo
        val btnIrB = findViewById<Button>(R.id.btn_ir_activity_b)
        val edtAlgo = findViewById<EditText>(R.id.edt_digite_algo)
        btnIrB.setOnClickListener {
            // Cria a Intent para ir à Activity B
            val intent1 = Intent(this, ActivityB::class.java)
            // Cria um Bundle para passar informações a Activity B
            val b1 = Bundle()
            // Coloca o texto digitado no campo edtAlgo dentro do Bundle sob a chave "TEXTO_A"
            b1.putString("TEXTO_A", edtAlgo.text.toString())
            b1.putSerializable("CONTATOS", lista)
            // Coloca o bundle dentro do intent
            intent1.putExtras(b1)

            // Pede para o Android acionar o Intent
            startActivity( intent1 )

        }


    }
}