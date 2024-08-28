package com.example.calculadoranotas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NotasActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.notas_layout)

        val edtNota1 = findViewById<EditText>(R.id.edt_nota1)
        val edtNota2 = findViewById<EditText>(R.id.edt_nota2)
        val edtNota3 = findViewById<EditText>(R.id.edt_nota3)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        btnCalcular.setOnClickListener {

            val intent = Intent(this, MediaActivity::class.java)
            startActivity(intent)

        }
    }
}