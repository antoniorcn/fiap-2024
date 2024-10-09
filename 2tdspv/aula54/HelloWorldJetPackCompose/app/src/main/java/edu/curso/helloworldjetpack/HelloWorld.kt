package edu.curso.helloworldjetpack
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

class HelloWorld : ComponentActivity() {
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContent {
            Calculadora()
        }
    }

    @Preview
    @Composable
    fun Calculadora() {
        val nomesBotoes = listOf("1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            ",", "0", "=", "/")
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier=Modifier
            .background(Color.Yellow)
            .fillMaxSize()) {
            for (lin in 0..3) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier=Modifier
                        .fillMaxWidth()
                ) {
                    for (col in 0..3) {
                        val pos = (lin * 4) + col
                        Button(onClick = {}) {
                            Text("${nomesBotoes[pos]}",
                                fontSize=5.em)
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TelaHelloWorld() {
        Column {
            Text("Hello World Jetpack Compose")
            Button(onClick = { }) {
                Text("Ok")
            }
            Row {
                Text("Texto 1")
                Text("Texto 2")
            }
            Text("Texto 3")
            Text("Texto 4")
        }
    }


}