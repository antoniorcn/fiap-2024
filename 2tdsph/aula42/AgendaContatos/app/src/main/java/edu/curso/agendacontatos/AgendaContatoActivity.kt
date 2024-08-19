package edu.curso.agendacontatos
import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText

data class Cliente( var nome : String="Anonimo",
    var telefone : String="Não informado",
    var email : String="Não informado")

class AgendaContatoActivity : Activity() {

    val lista = ArrayList<Cliente>()

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_layout)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtTelefone = findViewById<EditText>(R.id.edtTelefone)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)

        val btnGravar = findViewById<Button>(R.id.btnGravar)
        val btnPesquisar = findViewById<Button>(R.id.btnPesquisar)

        btnGravar.setOnClickListener {
            val c1 = Cliente( nome = edtNome.text.toString(),
                            telefone = edtTelefone.text.toString(),
                            email = edtEmail.text.toString() )
            lista.add( c1 )
            Log.v("AGENDA", lista.toString())
            edtNome.setText("")
            edtTelefone.setText("")
            edtEmail.setText("")
        }

        btnPesquisar.setOnClickListener {
            val textoNome = edtNome.text.toString()
            lista.forEach {
                if (it.nome.contains(textoNome)) {
                    edtNome.setText(it.nome)
                    edtTelefone.setText(it.telefone)
                    edtEmail.setText(it.email)
                }
            }
        }

    }

}