package edu.curso.agendacontato.activity
import edu.curso.agendacontato.R
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.repository.ContatoRepositorio

class AgendaContatoFormActivity : Activity() {
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)
        val repositorio = ContatoRepositorio()
        val edtNome : EditText = findViewById(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnListar = findViewById<Button>(R.id.btn_listar)
        btnGravar.setOnClickListener {
            val contato = Contato(
                nome = edtNome.text.toString(),
                email = edtEmail.text.toString(),
                telefone = edtTelefone.text.toString()
            )
            repositorio.gravar(contato)
        }
        btnListar.setOnClickListener{
            val nomeParaPesquisar = edtNome.text.toString()
            repositorio.pesquisar(nomeParaPesquisar,
                {
                    Log.i("Agenda", "Pesquisado com sucesso")
                    runOnUiThread {
                        edtNome.setText(it.nome)
                        edtEmail.setText(it.email)
                        edtTelefone.setText(it.telefone)
                    }
                }, {
                    Log.e("Agenda", "Erro ao fazer a pesquisa")
                })
        }
    }
}