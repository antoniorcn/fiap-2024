package edu.curso.agendacontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.curso.agendacontatos.ui.theme.AgendaContatosTheme

class MainActivity : ComponentActivity() {
    private val viewModel : ContatoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendaContatosTheme {
                Tela(viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaPreview() {
    // ViewModel Fake apenas para mostrar no Preview
    val viewModel : ContatoViewModel = ContatoViewModel()
    Tela(viewModel)
}

@Composable
fun Tela(viewModel: ContatoViewModel) {
    Column (modifier=Modifier.fillMaxSize().padding(10.dp)) {
        Formulario(viewModel)
        Listagem(viewModel)
    }
}

@Composable
fun Formulario(viewModel: ContatoViewModel) {
    Column(modifier=Modifier.fillMaxWidth().fillMaxHeight(0.4f)) {
        Text("Agenda de Contato", modifier = Modifier.fillMaxWidth(),
            fontSize=28.sp, textAlign = TextAlign.Center)
        OutlinedTextField(value = viewModel.nome.value,
            onValueChange = {viewModel.nome.value = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = {Text("Nome Completo")})
        OutlinedTextField(value = viewModel.email.value,
            onValueChange = {viewModel.email.value = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = {Text("Email")})
        OutlinedTextField(value = viewModel.telefone.value,
            onValueChange = {viewModel.telefone.value = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = {Text("DDD e Telefone")})
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button( onClick = {viewModel.gravar()}) {
                Text("Gravar")
            }
            Button( onClick = {}) {
                Text("Pesquisar")
            }
        }
    }
}

@Composable
fun CardContato( contato : Contato ) {
    Card(modifier=Modifier
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        ) {
            Text("Nome: ${contato.nome}")
            Text("Email: ${contato.email}")
            Text("Telefone: ${contato.telefone}")
        }
    }
}

@Composable
fun Listagem(viewModel: ContatoViewModel) {
    val scrollableState = rememberScrollState(0)
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
        item { 
            Text("Contatos")
        }
        items(items = viewModel.lista) { contato ->
            CardContato(contato)
        }
    }
}
