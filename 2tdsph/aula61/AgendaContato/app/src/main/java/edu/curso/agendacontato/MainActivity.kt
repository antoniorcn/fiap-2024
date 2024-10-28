package edu.curso.agendacontato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import edu.curso.agendacontato.ui.theme.AgendaContatoTheme

class MainActivity : ComponentActivity() {

    private val viewModel = viewModels<ContatoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            AgendaContatoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ViewListaContatos(viewModel,
                        modifier=Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ViewListaContatos(viewModel : Lazy<ContatoViewModel>,
                      modifier : Modifier = Modifier) {
    var contatoAtual by remember {mutableStateOf<Contato?>(null)}
    Column() {
        Text(
            text = "Agenda de Contato Lista",
            modifier = modifier
        )
        Button(onClick = { viewModel.value.carregarContatos() } ) {
            Text("Carregar Contatos")
        }
        LazyColumn() {
            item {
                Text("Inicio dos contatos")
            }
            items(viewModel.value.listaContatos) { contato ->
                Text("Nome: ${contato.nome}",
                    modifier = Modifier.clickable {
                        contatoAtual = contato
                    })

            }
            item {
                Text("Rodapé dos contatos")
            }
        }
        if (contatoAtual != null) {
            Column(
                Modifier.background(Color.LightGray)
                    .padding(10.dp)
            ) {
                Text("Detalhes do Contato")
                Text("Nome: ${contatoAtual?.nome}")
                Text("Email: ${contatoAtual?.email}")
                Button(onClick = {
                    contatoAtual = null
                }) {
                    Text("Fechar Detalhes")
                }
            }
        }

    }
}
