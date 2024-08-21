package com.example.exerciciolayout

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

data class Contato(var nome : String="", var email : String = "")
class AgendaContatoActivity : Activity(){
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_layout)
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnGravar = findViewById<Button>(R.id.btnGravar)
        btnGravar.setOnClickListener {
            val c1 = Contato(nome=edtNome.text.toString(),
                email=edtEmail.text.toString())
            Log.v("AGENDA", c1.toString())
        }
    }

}