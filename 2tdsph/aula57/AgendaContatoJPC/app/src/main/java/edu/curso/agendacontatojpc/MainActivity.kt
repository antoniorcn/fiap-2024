package edu.curso.agendacontatojpc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.ArrayList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // var contador = mutableIntStateOf( 0 )
        setContent {
        //    Contador( contador )
        //    Contador()
            Formulario()
        }
    }
}

// @Preview(showBackground = true)
@Composable
// fun Contador(contador: MutableIntState) {
fun Contador() {
    // val contador = remember { mutableIntStateOf(0) }
    var contador by remember { mutableIntStateOf(0) }
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = {
            // contador.value -= 1
            contador -= 1
            // Log.d("CONTADOR", "Contador: ${contador.value}")
            Log.d("CONTADOR", "Contador: $contador")
        }) {
            Text("-", fontSize= 48.sp)
        }
        // Text("${contador.value}", fontSize= 48.sp)
        Text("$contador", fontSize= 48.sp)
        Button(onClick = {
            contador += 1
            // contador.value += 1
            // Log.d("CONTADOR", "Contador: ${contador.value}")
            Log.d("CONTADOR", "Contador: $contador")
        }) {
            Text("+", fontSize= 48.sp)
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun Formulario() {
    val nome = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val telefone = rememberSaveable { mutableStateOf("") }
    val lista by rememberSaveable { mutableStateOf( ArrayList<Contato>() ) }
    Column(
        modifier =
            Modifier.fillMaxSize()
                .padding(horizontal=15.dp, vertical=60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Agenda de Contato", fontSize=48.sp,
            textAlign = TextAlign.Center,
            modifier=Modifier.background(Color.Yellow))
        LabelAndTextField("Nome", nome)
        LabelAndTextField("Telefone", telefone)
        LabelAndTextField("Email", email)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button( onClick = {
                Log.d("AGENDA", "Nome: ${nome.value}")
                Log.d("AGENDA", "Email: ${email.value}")
                Log.d("AGENDA", "Telefone: ${telefone.value}")
                val contato = Contato(nome.value, email.value, telefone.value)
                lista.add(contato)
            } ) {
                Text("Gravar")
            }
            Button( onClick = {
                for (contato in lista) {
                    if (contato.nome.contains( nome.value )) {
                        nome.value = contato.nome
                        telefone.value = contato.telefone
                        email.value = contato.email
                        break
                    }
                }
            } ) {
                Text("Pesquisar")
            }
        }
    }
}

@Composable
fun LabelAndTextField(label: String, texto: MutableState<String>) {

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)
        OutlinedTextField(value=texto.value, onValueChange = { texto.value = it })
    }
}
