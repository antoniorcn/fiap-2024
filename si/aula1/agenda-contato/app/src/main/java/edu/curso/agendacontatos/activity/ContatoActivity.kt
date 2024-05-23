package edu.curso.agendacontatos.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.curso.agendacontatos.R
import edu.curso.agendacontatos.model.Contato

class ContatoActivity : AppCompatActivity() {

    private val listaContatos = ArrayList<Contato>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle);
        setContentView(R.layout.contatos_layout)

        val txtNome = findViewById<TextView>(R.id.txtNome)
        val txtTelefone = findViewById<TextView>(R.id.txtTelefone)

        val btnGravar = findViewById<Button>(R.id.btnGravar)
        btnGravar.setOnClickListener {
            val contato = Contato(
                txtNome.text.toString(),
                txtTelefone.text.toString()
            )
            listaContatos.add(contato)
            Log.i("AGENDA-CONTATO","Contato gravado")
            Log.i("AGENDA-CONTATO", "Lista: $listaContatos")
        }

        val btnPesquisar = findViewById<Button>(R.id.btnPesquisar)
        btnPesquisar.setOnClickListener {
            listaContatos.forEach {
                if (it.nome.contains( txtNome.text.toString() )) {
                    txtNome.text = it.nome
                    txtTelefone.text = it.telefone
                }
            }
        }
    }

}