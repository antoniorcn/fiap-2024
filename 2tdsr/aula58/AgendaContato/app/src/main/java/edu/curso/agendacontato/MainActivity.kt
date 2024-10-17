package edu.curso.agendacontato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.curso.agendacontato.ui.ContatoViewModel
import edu.curso.agendacontato.ui.theme.AgendaContatoTheme

class MainActivity : ComponentActivity() {
    val viewModel : ContatoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendaContatoTheme {
                Tela(viewModel)
            }
        }
    }
}

@Composable
fun Tela(viewModel: ContatoViewModel) {
    Column( modifier = Modifier.fillMaxSize() )  {
        Formulario(viewModel)
        Lista(viewModel)
    }
}

@Composable
fun Formulario(viewModel: ContatoViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
    ) {
        Row() {
            Text("Nome: ")
            TextField(value = viewModel.nome,
                onValueChange = { viewModel.nome = it })
        }
        Row() {
            Text("Email: ")
            TextField(value = viewModel.email,
                onValueChange = { viewModel.email = it })
        }
        Row() {
            Text("Telefone: ")
            TextField(value = viewModel.telefone,
                onValueChange = { viewModel.telefone = it })
        }
        Row() {
            Button(onClick = {
                viewModel.adicionarContato()
            }) {
                Text("Gravar")
            }
            Button(onClick = {
                viewModel.lerTodos()
            }) {
                Text("Pesquisar")
            }
        }
    }
}

@Composable
fun Lista(viewModel: ContatoViewModel) {
    LazyColumn (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.6f)) {
        items(items=viewModel.lista) {
            Card( ) {
                Text("${it.nome}")
                Text("${it.telefone}")
                Text("${it.email}")
            }
        }
    }
}


