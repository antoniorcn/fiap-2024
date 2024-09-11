package edu.curso.entreactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ActivityB : Activity(){

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.layout_b)

        // Pega o botão Ir para Activity A
        val btnIrA = findViewById<Button>(R.id.btn_ir_activity_a)

        // Pega o intent e o bundle existente nele
        val b1 = intent.extras
        // Caso o bundle seja nulo a sentença toda será
        // nula e substituida por "" ao inves de abortar o programa
        // No final o texto conterá algo ou será igual a ""
        val texto = b1?.getString("TEXTO_A")?:""

        // Pega a lista de contatos
        val lista = b1?.getSerializable("CONTATOS")
        Log.d("NAVEGACAO", "Lista: $lista")

        // Pega o TextView que irá conter o texto
        val txt = findViewById<TextView>(R.id.texto_outra_activity)
        // Atribui o Texto que veio no Bundle para dentro do TextView
        txt.setText(texto)
        btnIrA.setOnClickListener {
            // Gera a Intent para acessar a ActivityA
            val intent1 = Intent(this, ActivityA::class.java)
            startActivity( intent1 )

        }
    }
}