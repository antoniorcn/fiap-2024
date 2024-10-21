package edu.curso.testelogin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.curso.testelogin.ui.theme.TesteLoginTheme



class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<TesteViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TESTE", "API KEY: ${BuildConfig.API_KEY}")
        setContent {
            TesteLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LoginPage(viewModel)
                }
            }
        }
    }
}

@Composable
fun LoginPage(viewModel: TesteViewModel) {
    Column(modifier=Modifier.fillMaxSize()) {
        Text("Login", fontSize=28.sp)
        OutlinedTextField(value = viewModel.email.value,
            onValueChange = {viewModel.email.value = it},
            placeholder = {Text("Email ")})
        OutlinedTextField(value = viewModel.senha.value,
            onValueChange = {viewModel.senha.value = it},
            placeholder = {Text("Senha ")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        Row() {
            Button(onClick={}) {
                Text("Sign in")
            }
            Button(onClick={viewModel.registrar()}) {
                Text("Sign up")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TesteLoginPage() {
    val viewModel = TesteViewModel()
    TesteLoginTheme {
        LoginPage(viewModel)
    }
}