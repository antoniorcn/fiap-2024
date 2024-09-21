package edu.curso.agendacontato.activity
import edu.curso.agendacontato.R
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import edu.curso.agendacontato.model.Contato
class AgendaContatoFormActivity : Activity() {
    private val lista = ArrayList<Contato>()
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.agenda_contato_form)
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
//            contato.nome = edtNome.text.toString()
//            contato.email = edtEmail.text.toString()
//            contato.telefone = edtTelefone.text.toString()
            lista.add(contato)
        }
        btnListar.setOnClickListener{
            val nomeParaPesquisar = edtNome.text.toString()
            for (contato in lista) {
                if (contato.nome.contains(nomeParaPesquisar)) {
                    edtNome.setText(contato.nome)
                    edtEmail.setText(contato.email)
                    edtTelefone.setText(contato.telefone)
                    break
                }
            }
        }
    }
}