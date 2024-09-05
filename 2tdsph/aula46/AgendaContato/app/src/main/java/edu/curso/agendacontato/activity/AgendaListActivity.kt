package edu.curso.agendacontato.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import edu.curso.agendacontato.databinding.AgendaContatoListaLayoutBinding

class AgendaListActivity : Activity() {

    lateinit var binding : AgendaContatoListaLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = AgendaContatoListaLayoutBinding.inflate( layoutInflater )
        setContentView( binding.root )

        val textos = listOf("Contato 1", " Contato 2", "Contato 3")

        val adaptador = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, textos)

        binding.apply {
            listView.adapter = adaptador

            btnFormulario.setOnClickListener {
                val intent = Intent(this@AgendaListActivity, AgendaContatoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}