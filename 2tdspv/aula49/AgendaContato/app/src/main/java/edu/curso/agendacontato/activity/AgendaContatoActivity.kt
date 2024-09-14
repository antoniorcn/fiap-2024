package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.repository.AgendaContatoRepository


interface ActivityCallBack {
    fun sucesso( lista : ArrayList<String>? )

    fun falha()
}

class AgendaContatoActivity : Activity() {

    lateinit var edtNome : EditText
    lateinit var edtEmail : EditText
    lateinit var edtTelefone : EditText

    val repository = AgendaContatoRepository()

    override fun onCreate(bundle: Bundle?) {
        // Informação de tela
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)

        // Informação de tela
        edtNome = findViewById(R.id.edt_nome)
        edtEmail = findViewById(R.id.edt_email)
        edtTelefone = findViewById(R.id.edt_telefone)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_listar)


        btnGravar.setOnClickListener {
            val contato = Contato(nome=edtNome.text.toString(),
                telefone=edtTelefone.text.toString(),
                email=edtEmail.text.toString())
            repository.gravarContato( contato, object : ActivityCallBack {
                override fun sucesso( lista : ArrayList<String>?) {
                    runOnUiThread {
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Contato gravado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                        edtNome.text.clear()
                        edtTelefone.text.clear()
                        edtEmail.text.clear()
                    }
                }
                override fun falha() {
                    runOnUiThread {
                       Toast.makeText(
                            this@AgendaContatoActivity,
                            "Erro ao gravar o contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        }

        btnPesquisar.setOnClickListener {
            repository.pesquisarContato( object : ActivityCallBack {
                override fun sucesso(lista : ArrayList<String>?) {
                    val intent1 = Intent(this@AgendaContatoActivity,
                        AgendaContatoListActivity::class.java)
                    val bun1 = Bundle()
                    bun1.putSerializable("LISTA", lista)
                    intent1.putExtras( bun1 )
                    startActivity(intent1)
                }

                override fun falha() {
                    runOnUiThread {
                        // Informação de tela
                        Toast.makeText(
                            this@AgendaContatoActivity,
                            "Não foi encontrado nenhum contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        }
    }

}