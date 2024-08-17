package edu.curso.calculadorasoma

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CalculadoraSoma : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate( bundle )
        Log.v("CALCULADORA", "onCreate executado")
        // Coloca o layout na Tela
        setContentView(R.layout.calculadora_soma_layout)

        // Edit Text Numero 1
        val edtNumero1 = findViewById<EditText>(R.id.edtNumero1)
        // Edit Text Numero 2
        val edtNumero2 = findViewById<EditText>(R.id.edtNumero2)
        // Botão Somar
        val btnSomar = findViewById<Button>(R.id.btnSomar)

        // O que fará quando o botão for pressionado
        btnSomar.setOnClickListener {
            // Captura o texto do EditText e converte para double se for possivel
            var num1 = edtNumero1.text.toString().toDoubleOrNull()
            var num2 = edtNumero2.text.toString().toDoubleOrNull()
            if (num1 == null) {
                num1 = 0.0
            }
            if (num2 == null) {
                num2 = 0.0
            }
            val resultado = num1 + num2
            Log.v("CALCULADORA", "Soma: $resultado")
        }
    }
}