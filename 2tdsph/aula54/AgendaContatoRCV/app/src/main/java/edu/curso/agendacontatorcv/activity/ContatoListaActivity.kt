package edu.curso.agendacontatorcv.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.agendacontatorcv.R
import edu.curso.agendacontatorcv.databinding.ContatoListaActivityLayoutBinding
import edu.curso.agendacontatorcv.model.Contato
import edu.curso.agendacontatorcv.recyclerview.ContatoAdapter
import edu.curso.agendacontatorcv.viewmodel.ContatoViewModel

class ContatoListaActivity : AppCompatActivity() {
    lateinit var viewModel : ContatoViewModel
    lateinit var binding : ContatoListaActivityLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        viewModel = ViewModelProvider(this)[ContatoViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.contato_lista_activity_layout)
        binding.viewModel = viewModel
        setContentView(binding.root)
        viewModel.listar( this, binding )

        val adaptador = ContatoAdapter(this, viewModel )

        binding.rcvContatoLista.adapter = adaptador
        binding.rcvContatoLista.layoutManager = LinearLayoutManager(this)

        binding.btnVoltar.setOnClickListener {
            val intent1 = Intent(this, ContatoFormActivity::class.java)
            startActivity(intent1)
        }
    }
}