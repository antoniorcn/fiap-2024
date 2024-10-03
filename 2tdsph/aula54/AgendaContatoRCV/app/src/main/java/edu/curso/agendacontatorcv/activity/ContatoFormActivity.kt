package edu.curso.agendacontatorcv.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import edu.curso.agendacontatorcv.R
import edu.curso.agendacontatorcv.databinding.ContatoFormActivityLayoutBinding
import edu.curso.agendacontatorcv.model.Contato
import edu.curso.agendacontatorcv.viewmodel.ContatoViewModel

class ContatoFormActivity : AppCompatActivity() {

    lateinit var viewModel : ContatoViewModel
    lateinit var binding : ContatoFormActivityLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        viewModel = ViewModelProvider(this)[ContatoViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.contato_form_activity_layout)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)


        binding.btnGravar.setOnClickListener {
            viewModel.salvar()
        }
        binding.btnListar.setOnClickListener {
            val intent1 = Intent(this, ContatoListaActivity::class.java)
            startActivity(intent1)
        }
    }
}