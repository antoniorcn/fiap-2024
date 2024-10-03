package edu.curso.helloworldjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.curso.helloworldjc.ui.theme.HelloWorldJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculadora()
        }
    }
}
@Composable
fun TelaPrincipal() {
    Tela("Tela Principal")
}
@Composable
fun Tela ( txt : String ) {
    Column(modifier = Modifier
        .background(color = Color.Yellow)
        .fillMaxSize()
    ) {
        Text("Hello World: $txt",
            modifier=Modifier
                .background(color=Color.Cyan),
            fontSize = 48.sp
        )
        Button(onClick = {}) {
            Text("Ok")
        }
        Row {
            Text(
                "Texto 1",
                fontSize = 28.sp
            )
            Text(
                "Texto 2",
                fontSize = 28.sp
            )
        }
    }
}


@Preview
@Composable
fun Calculadora() {
    val nomesBotoes = listOf("1", "2", "3", "+", "4", "5", "6", "-",
        "7", "8", "9", "*", ".", "0", "=", "/")
    Text("Calculadora")
    Column (
        modifier= Modifier
            .fillMaxSize()
            .background(color = Color.White)

            .padding(vertical = 50.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (linha in 0 .. 3) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()

            ) {
                for (coluna in 0..3) {
                    val pos = (linha * 4) + coluna
                    val nomeBotao = nomesBotoes[pos]
                    Card( elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults
                        .cardColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text(nomeBotao, fontSize = 35.sp,
                            modifier = Modifier.padding(
                                vertical = 35.dp,
                                horizontal = 30.dp),
                            color = Color.White)
                    }
                }
            }
        }
    }

}
