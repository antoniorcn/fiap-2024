package edu.curso.agendacontatocompleta.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.curso.agendacontatocompleta.R
import edu.curso.agendacontatocompleta.model.Contato
import edu.curso.agendacontatocompleta.repository.ContatoRepositorio
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ContatoFormActivity : AppCompatActivity() {
    val repository = ContatoRepositorio()
    val dtf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.contato_form_activity_layout)

        val edtNome=findViewById<EditText>(R.id.edt_nome)
        val edtTelefone=findViewById<EditText>(R.id.edt_telefone)
        val edtEmail=findViewById<EditText>(R.id.edt_email)
        val edtNascimento=findViewById<EditText>(R.id.edt_nascimento)

        val btnGravar=findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar=findViewById<Button>(R.id.btn_pesquisar)

        btnGravar.setOnClickListener {
            val dateNascimento = dtf.parse( edtNascimento.text.toString() )
            val c = Contato(
                nome=edtNome.text.toString(),
                email=edtEmail.text.toString(),
                telefone=edtTelefone.text.toString(),
                nascimento=dateNascimento
            )
            repository.gravar( c,
                onSucesso = {
                    runOnUiThread {
                        Toast.makeText(this,
                            "Contato gravado com sucesso",
                                Toast.LENGTH_LONG)
                            .show()
                        edtNome.setText("")
                        edtEmail.setText("")
                        edtTelefone.setText("")
                        val textoHoje = dtf.format(
                            Calendar.getInstance().time)
                        edtNascimento.setText( textoHoje )
                    }
                },
                onFalha = {
                    runOnUiThread {
                        Toast.makeText(
                            this,
                            "Erro ao gravar o contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }

        btnPesquisar.setOnClickListener {
            repository.pesquisar(edtNome.text.toString(),
                onSucesso = {
                    runOnUiThread {
                        Toast.makeText(
                            this,
                            "Contato localizado com sucesso",
                            Toast.LENGTH_LONG
                        ).show()
                        edtNome.setText( it.nome )
                        edtTelefone.setText( it.telefone )
                        edtEmail.setText( it.email )
                        val textoNascimento = dtf.format(it.nascimento)
                        edtNascimento.setText(textoNascimento)
                    }

                },
                onFalha = {
                    runOnUiThread {
                        Toast.makeText(
                            this,
                            "Erro ao procurar o contato",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            )
        }
    }

}