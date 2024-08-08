package edu.curso.helloworld

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class HelloWorld : Activity() {
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        Log.i("HelloWorldApp", "onCreate Ativado")
        val txt = TextView( this )
        // txt.setText("Hello World")
        txt.text = getString(R.string.texto)
        setContentView( txt )
    }

    override fun onStart() {
        super.onStart()
        Log.i("HelloWorldApp", "onStart Executado")
    }


    override fun onResume() {
        super.onResume()
        Log.i("HelloWorldApp", "onResume Executado")
    }
}