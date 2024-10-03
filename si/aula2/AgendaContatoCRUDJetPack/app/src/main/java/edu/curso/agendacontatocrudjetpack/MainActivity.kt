package edu.curso.agendacontatocrudjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.curso.agendacontatocrudjetpack.ui.theme.AgendaContatoCRUDJetPackTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ContatoViewModel>()

//    fun adicionar(contato : Contato) {
//        viewModel.listaContatos.add(contato)
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.lerContatos()
        setContent {
            AgendaContatoCRUDJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Cyan)
                        .padding(10.dp)) {
                        Column(
                        ) {
                            Formulario(viewModel)
                        }
                        Column(

                        ) {
                            LazyColumn() {
                                items(viewModel.listaContatos) {
                                    ContatoItem(contato = it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ContatoItem(contato : Contato) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("Nome: ${contato.nome}")
            Text("Telefone: ${contato.telefone}")
            Text("Email: ${contato.email}")
        }
    }
}

@Composable
fun Formulario(viewModel : ContatoViewModel) {
    var nome by remember { mutableStateOf("João Silva") }
    var telefone by remember { mutableStateOf("(11) 1111-1111") }
    var email by remember { mutableStateOf("joao@teste.com") }

    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            text = "Agenda Contato",
            fontSize = 28.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = nome,
            onValueChange = { nome = it },
            label = {Text("Nome: ")}
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = telefone,
            onValueChange = { telefone = it },
            label = {Text("Telefone: ")}
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            label = {Text("Email: ")}
        )
        Button(
            onClick = {
                val contato = Contato(null, nome, telefone, email)
                viewModel.gravarContato(contato)
                // viewModel.listaContatos.add( contato )
                // Log.i(Constantes.TAG_PRINCIPAL, "Contato adicionado na lista:  $contato ")
                // Log.i(Constantes.TAG_PRINCIPAL, "A lista tem agora ${viewModel.listaContatos.size} elementos")
            }
        ) {
            Text("Gravar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormularioPreview() {
    // Formulario()
}