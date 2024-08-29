package edu.curso.calculadoranotas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class NotasActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.notas_layout)
        val edtNota1 = findViewById<EditText>(R.id.edt_nota1)
        val edtNota2 : EditText = findViewById(R.id.edt_nota2)
        val edtNota3 = findViewById<EditText>(R.id.edt_nota3)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val n1 = edtNota1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = edtNota2.text.toString().toDoubleOrNull() ?: 0.0
            val n3 = edtNota3.text.toString().toDoubleOrNull() ?: 0.0
            val media = (n1 + n2 + n3) / 3
            Log.v("NOTAS", "Media: $media")

            val intent1 = Intent(this, MediaActivity::class.java)
            val bundleData = Bundle()
            bundleData.putDouble("MEDIA", media)
            intent1.putExtras(bundleData)

            startActivity( intent1 )
        }
    }
}