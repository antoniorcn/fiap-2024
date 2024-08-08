package edu.curso.quadromedalhas

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class QuadroMedalhas : Activity() {

    override fun onCreate(bundle: Bundle?) {
         super.onCreate(bundle)

         Log.v("QUADRO", "onCreate() executado")

         val txt = TextView(this)
         txt.text = "Quadro Medalhas"
         setContentView( txt )
     }

    override fun onStart() {
        super.onStart()
        Log.v("QUADRO", "onStart() executado")
    }

    override fun onResume() {
        super.onResume()
        Log.v("QUADRO", "onResume() executado")
    }

    override fun onPause() {
        super.onPause()
        Log.v("QUADRO", "onPause() executado")
    }

    override fun onStop() {
        super.onStop()
        Log.v("QUADRO", "onStop() executado")
    }

    override fun onDestroy() {
        Log.v("QUADRO", "onDestroy() executado")
        super.onDestroy()
    }
}