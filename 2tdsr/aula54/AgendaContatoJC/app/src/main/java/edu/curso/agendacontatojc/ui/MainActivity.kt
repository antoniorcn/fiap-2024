package edu.curso.agendacontatojc.ui
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        val textosBotoes = listOf(
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            ".", "0", "=", "/")
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxSize()
            ) {
                for (linha in 0..3) {
                    Card(
                        elevation = CardDefaults.cardElevation(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                        ) {
                            for (coluna in 0..3) {
                                val indice = (linha * 4) + coluna
                                Button(
                                    onClick = {},
                                    elevation = ButtonDefaults.buttonElevation(20.dp)
                                ) {
                                    Text(
                                        modifier = Modifier.padding(20.dp),
                                        fontSize = 32.sp,
                                        text = textosBotoes[indice]
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}