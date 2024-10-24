package edu.curso.testelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.curso.testelogin.ui.theme.TesteLoginTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    val contatoViewModel : ContatoViewModel by viewModels<ContatoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesteLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Lista( contatoViewModel )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaPreview() {
    val viewModel = ContatoViewModel()
    Lista( viewModel )
}


@Composable
fun Lista(viewModel : ContatoViewModel) {
    Column() {
        Button(onClick = { viewModel.lerTodos() }
        ) {
            Text("Ler Todos")
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Text("Inicio do Lazy Column")
            }

            items(items = viewModel.lista) {
                Card() {
                    Text(it.nome)
                    Text(it.telefone)
                    Text(it.email)
                }
            }

            item {
                Text("Final do Lazy Column")
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
    ) {
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF90EE90), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                    text = "Login",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
            )

            OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email:") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors( Color(0xFFFFE4B5) )
            )

            OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha:") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors( Color(0xFFFFE4B5) )
            )

            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                        onClick = { /* TODO: Implementar registro */ },
                        modifier = Modifier.weight(1f).padding(end = 8.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF4169E1))
                ) {
                    Text("Registrar", color = Color.White)
                }

                Button(
                        onClick = { /* TODO: Implementar login */ },
                        modifier = Modifier.weight(1f).padding(start = 8.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF4169E1))
                ) {
                    Text("Logar", color = Color.White)
                }
            }
        }
    }
}