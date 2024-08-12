package edu.curso.agendacontatos

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AgendaContatoActivity : AppCompatActivity() {

    override fun onCreate(bundle : Bundle?) {
        super.onCreate( bundle )
        setContentView(R.layout.agenda_contato_layout)
        val btnSomar = findViewById<Button>(R.id.btn_somar)
        val edtNumero1 = findViewById<EditText>(R.id.edt_numero1)
        val edtNumero2 = findViewById<EditText>(R.id.edt_numero2)
        val txtResultado = findViewById<TextView>(R.id.txt_resultado)
        // btnSomar.setBackgroundColor(Color.YELLOW)

//        val evento = View.OnClickListener() {
//            Log.v("CALCULADORA", "Botão Apertado")
//        }
//        btnSomar.setOnClickListener( evento )

        btnSomar.setOnClickListener {
            var numero1 = edtNumero1.text.toString().toDoubleOrNull()
            numero1 = numero1 ?: 0.0
            var numero2 = edtNumero2.text.toString().toDoubleOrNull()
            numero2 = numero2 ?: 0.0
            val soma = numero1 + numero2
            Log.v("CALCULADORA", "Soma: $soma")
            txtResultado.text = "Resultado: $soma"
        }

    }
}