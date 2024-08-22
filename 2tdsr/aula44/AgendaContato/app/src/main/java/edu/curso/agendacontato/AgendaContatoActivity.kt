package edu.curso.agendacontato

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

data class Contato(var nome : String="",
    var telefone:String="",
    var email:String="")
class AgendaContatoActivity : Activity() {

    val listaContatos = ArrayList<Contato>()

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato)
        val btnGravar = findViewById<Button>(R.id.btnGravar)
        val btnPesquisar = findViewById<Button>(R.id.btnPesquisar)
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        btnGravar.setOnClickListener {
            // btnGravar.setBackgroundColor(0xFFFFFF00.toInt())
            Log.v("AGENDA", "Botão apertado")
            val c1 = Contato(nome = edtNome.text.toString(),
                email = edtEmail.text.toString(),
                telefone = edtTelefone.text.toString())
            listaContatos.add( c1 )
            Log.v("AGENDA", "Dados do Contato: $c1")
            Log.v("AGENDA", "Lista: $listaContatos")
            val toast = Toast.makeText(this,
                "Contato cadastrado com sucesso",
                Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,0, 50)
            toast.show()

            edtNome.setText("")
            edtTelefone.setText("")
            edtEmail.setText("")
        }

        btnPesquisar.setOnClickListener {
            for (contato in listaContatos) {
                if (contato.email.contains( edtEmail.text.toString(), true)) {
                    edtNome.setText(contato.nome)
                    edtTelefone.setText(contato.telefone)
                    edtEmail.setText(contato.email)
                    break
                }
            }
        }
    }
}