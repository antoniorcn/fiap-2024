package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.gson.reflect.TypeToken
import edu.curso.agendacontato.R

class AgendaContatoListActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContentView(R.layout.agenda_contato_list)

        val listView = findViewById<ListView>(R.id.list_view)
        val btnForm = findViewById<Button>(R.id.btn_formulario)

        val listaContatosStr = ArrayList<String>()

        val listaSerialized = intent.extras?.getSerializable("LISTA")
        if (listaSerialized != null && listaSerialized is ArrayList<*>) {
            val listaTextos = listaSerialized as ArrayList<String>
            listaContatosStr.addAll( listaTextos )
        }

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, listaContatosStr
        )

        listView.adapter = adapter

        btnForm.setOnClickListener {
            val intent1 = Intent(this, AgendaContatoActivity::class.java)
            startActivity(intent1)
        }
    }
}