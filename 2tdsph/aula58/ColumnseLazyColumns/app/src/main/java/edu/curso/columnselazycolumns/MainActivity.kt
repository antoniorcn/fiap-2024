package edu.curso.columnselazycolumns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.curso.columnselazycolumns.ui.theme.ColumnsELazyColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val tema = mutableIntStateOf(0)   // 0 -dark, 1 - light, 2 - alternativo
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                Principal( tema )
            }
        }
    }
}

@Composable
fun Principal(tema: MutableIntState) {
    ColumnsELazyColumnsTheme( tema ) {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()
            NavHost(
                navController,
                startDestination = destinoConfiguracoes.rota
            ) {
                composable(destinoFormulario.rota) {
                    Formulario(navController)
                }
                composable(destinoConfiguracoes.rota) {
                    Configuracoes(tema, navController)
                }
            }
        }
    }
}

@Composable
fun Formulario(navController: NavHostController) {
    Column (modifier = Modifier.fillMaxSize()){
        Row() {
            Text("Nome: ")
            OutlinedTextField(value = "", onValueChange = {})
        }
        Row() {
            Text("Email: ")
            OutlinedTextField(value = "", onValueChange = {})
        }
        Row() {
            Text("Telefone: ")
            OutlinedTextField(value = "", onValueChange = {})
        }
        Row () {
            Button(onClick = {}) {
                Text("Gravar")
            }
            Button(onClick = {}) {
                Text("Pesquisar")
            }
            Button( onClick = {
                navController.navigate(destinoConfiguracoes.rota)
            } ) {
                Text("Configuracoes")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrincipalPreview() {
    val tema = remember{ mutableIntStateOf(2) }
    Principal(tema = tema)
}

@Composable
fun Configuracoes(tema: MutableIntState, navController: NavHostController) {
    Column() {
        Text("Nome: ")
        OutlinedTextField(value = "", onValueChange = {})
        Button(onClick = {
            tema.value = 0
        }) {
            Text("Paleta Dark")
        }
        Button(onClick = {
            tema.value = 1
        }) {
            Text("Paleta Light")
        }
        Button(onClick = {
            tema.value = 2
        }) {
            Text("Paleta Alternativa")
        }
        Button( onClick = {
            navController.navigate(destinoFormulario.rota)
        } ) {
            Text("Ir para o Fomulario")
        }
    }
}