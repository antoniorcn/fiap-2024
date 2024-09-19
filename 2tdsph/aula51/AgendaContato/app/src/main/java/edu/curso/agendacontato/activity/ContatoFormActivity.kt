package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import edu.curso.agendacontato.R
import edu.curso.agendacontato.model.Contato

class ContatoFormActivity : Activity() {
    val lista : MutableList<Contato> = mutableListOf()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_form_activity_layout)
        val txtNome = findViewById<EditText>(R.id.edt_nome)
        val txtEmail = findViewById<EditText>(R.id.edt_email)
        val txtTelefone = findViewById<EditText>(R.id.edt_telefone)
        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnListar = findViewById<Button>(R.id.btn_listar)
        btnGravar.setOnClickListener {
            val c = Contato(0, txtNome.text.toString(),
                txtTelefone.text.toString(), txtEmail.text.toString())
            lista.add(c)
        }
        btnListar.setOnClickListener {
            val bun = Bundle()
            val listaTemp = ArrayList<Contato>()
            listaTemp.addAll(lista)
            bun.putSerializable("LISTA", listaTemp)
            val intent1 = Intent(this, ContatoListaActivity::class.java)
            intent1.putExtras(bun)
            startActivity(intent1)
        }
    }
}