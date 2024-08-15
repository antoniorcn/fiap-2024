package edu.curso.calculadorasoma

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CalculadoraActivity : Activity() {

    override fun onCreate( bundle : Bundle?) {
        super.onCreate( bundle )
        setContentView(R.layout.calculadora_layout)

        val edtNum1 = findViewById<EditText>(R.id.edtNumero1)
        val edtNum2 = findViewById<EditText>(R.id.edtNumero2)
        val btnSomar = findViewById<Button>(R.id.btnSomar)

        btnSomar.setOnClickListener {
            Log.v("CALCULADORA", "Botão pressionado")

            var num1 = edtNum1.text.toString().toDoubleOrNull()
            var num2 = edtNum2.text.toString().toDoubleOrNull()

            if (num1 == null) {
                num1 = 0.0
            }

            if (num2 == null) {
                num2 = 0.0
            }

            val resultado = num1 + num2
            Log.v("CALCULADORA", "Resultado: $resultado")
        }
    }
}