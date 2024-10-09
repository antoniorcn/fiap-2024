package edu.curso.contador
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.curso.contador.ui.theme.ContadorTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Contador()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Contador() {
    var contador = 0
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Contador", fontSize = 36.sp)
        Row {
            Button(onClick = {}) {
                Text("-", fontSize = 36.sp)
            }
            Text("  $contador  ", fontSize = 36.sp)
            Button(onClick = {
                contador += 1
                Log.d("CONTADOR", "Valor do contador: $contador")
            }) {
                Text("+", fontSize = 36.sp)
            }
        }
    }
}
