package edu.curso.agendacontato

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

data class Contato(var nome : String = "Anonimo",
    var telefone : String = "Não informado",
    var email : String = "Não informado") {}

class AgendaContatoActivity : Activity() {

    val lista = ArrayList<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.agenda_contato_form)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val edtEmail : EditText = findViewById(R.id.edt_email)
        val btnGravar : Button = findViewById(R.id.btn_gravar)
        val btnPesquisar  = findViewById<Button>(R.id.btn_pesquisar)

        btnGravar.setOnClickListener {
            val c1 = Contato(
                email=edtEmail.text.toString(),
                nome=edtNome.text.toString(),
                telefone=edtTelefone.text.toString())
            lista.add(c1)
            // Limpar os campos
            edtNome.setText("")
            edtTelefone.setText("")
            edtEmail.setText("")

            // Avisar na tela
            val toast = Toast.makeText(this,
                "Contato gravado com sucesso",
                Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 50)
            toast.show()

            // Mostrar na Log
            Log.v("AGENDA", "Lista: $lista")
        }

        btnPesquisar.setOnClickListener {
            val nome = edtNome.text.toString()
            for (contato in lista) {
                if (contato.nome.contains( nome )) {
                    edtNome.setText( contato.nome )
                    edtTelefone.setText( contato.telefone )
                    edtEmail.setText( contato.email )
                    break
                }
            }
        }
    }
}