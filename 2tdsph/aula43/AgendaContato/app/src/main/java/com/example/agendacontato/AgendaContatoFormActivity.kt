package com.example.agendacontato

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.agendacontato.R.id.btnGravar

class AgendaContatoFormActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.agenda_contato_formulario_layout)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val edtNome = findViewById<EditText>(R.id.edt_form_nome)

        btnGravar.setOnClickListener {
            val intent = Intent(this,
                AgendaContatoMostrarActivity::class.java)
            intent.putExtra("NOME_COMPLETO", edtNome.text.toString())
            startActivity(intent)
        }
    }
}