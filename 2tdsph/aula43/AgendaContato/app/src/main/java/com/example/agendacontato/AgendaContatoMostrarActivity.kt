package com.example.agendacontato

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AgendaContatoMostrarActivity : AppCompatActivity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.agenda_contato_mostrar_layout)

        val dados = intent.extras 
        val texto = dados.getString("NOME_COMPLETO")
        val edtTexto = findViewById<EditText>(R.id.edt_mostrar_texto)
        edtTexto.setText(texto)
    }

}