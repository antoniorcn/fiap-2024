package edu.curso.calculadoranotas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.round
class MediaActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.media_layout)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        val txtMedia = findViewById<TextView>(R.id.txt_media)
        val bundleData : Bundle? = intent.extras
        val media : Double = bundleData?.getDouble("MEDIA") ?: 0.0

        txtMedia.text = "%5.1f".format(media)

        btnVoltar.setOnClickListener {
            val intent2 = Intent(this, NotasActivity::class.java)
            startActivity(intent2)
        }
    }
}