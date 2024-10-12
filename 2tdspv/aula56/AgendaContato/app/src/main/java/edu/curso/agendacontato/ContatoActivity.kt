package edu.curso.agendacontato

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContatoActivity : Activity() {
    val control = ContatoControl()
    lateinit var edtNome : EditText
    lateinit var edtTelefone : EditText
    lateinit var edtEmail : EditText
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)
        edtNome = findViewById<EditText>(R.id.edt_nome)
        edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        edtEmail = findViewById<EditText>(R.id.edt_email)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        btnGravar.setOnClickListener {
            val contato = gerarContato()
            control.salvar( contato,
                onSucesso = {
                    runOnUiThread {
                        Toast.makeText(
                            this,
                            "Contato gravado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                onFalha = {
                    runOnUiThread {
                        Toast.makeText(
                            this,
                            "Erro ao gravar o contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)
        btnPesquisar.setOnClickListener {
            val contato = control.pesquisar(edtNome.text.toString())
            if (contato != null) {
                popularContatoNaTela( contato )
            }
        }
    }

    private fun gerarContato() : Contato {
        val contato = Contato(nome = edtNome.text.toString(),
            telefone = edtTelefone.text.toString(),
            email = edtEmail.text.toString())
        return contato
    }

    private fun popularContatoNaTela( contato : Contato ) {
        edtNome.setText( contato.nome )
        edtTelefone.setText( contato.telefone )
        edtEmail.setText( contato.email )
    }
}