package edu.curso.agendacontato.activity

import android.app.Activity
import android.app.AppComponentFactory
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato
import edu.curso.agendacontato.viewmodel.ContatoViewModel

class ContatoFormActivity : AppCompatActivity() {
//    val lista : MutableList<Contato> = mutableListOf(
//        Contato(0, "Joao Silva", "(11) 1111-1111", "joao@teste.com"),
//        Contato(0, "Maria Silva", "(11) 2222-2222", "maria@teste.com")
//    )]

    lateinit var viewModel : ContatoViewModel

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        viewModel = ViewModelProvider(this)[ContatoViewModel::class.java]

        setContentView(R.layout.contato_form_activity_layout)
        val txtNome = findViewById<EditText>(R.id.edt_nome)
        val txtEmail = findViewById<EditText>(R.id.edt_email)
        val txtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnListar = findViewById<Button>(R.id.btn_listar)
        btnGravar.setOnClickListener {
            val c = Contato(0, txtNome.text.toString(),
                txtTelefone.text.toString(), txtEmail.text.toString())
            viewModel.lista.value?.add(c)
        }
        btnListar.setOnClickListener {
            val bun = Bundle()
            val listaTemp = ArrayList<Contato>()
            listaTemp.addAll(viewModel.lista.value as ArrayList<Contato>)
            bun.putSerializable("LISTA", listaTemp)
            val intent1 = Intent(this, ContatoListaActivity::class.java)
            intent1.putExtras(bun)
            startActivity(intent1)
        }
    }
}