package edu.curso.agendacontatojc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.curso.agendacontatojc.ui.theme.AgendaContatoJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Formulario()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Formulario() {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("")}
    var telefone by remember { mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Agenda de Contato", fontSize = 32.sp)
        OutlinedTextField(
            value = nome,
            onValueChange = {nome=it},
            label = {
                Text("Nome Completo")
            })
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = {
                Text("Endereço de e-mail")
            })
        OutlinedTextField(
            value = telefone,
            onValueChange = {telefone=it},
            label = {
                Text("(DDD) Telefone")
            })
        Button(onClick = {
            val contato = Contato(nome, email, telefone)
            Log.d("AGENDA", "Contato: $contato")

        }) {
            Text("Gravar")
        }
    }
}
