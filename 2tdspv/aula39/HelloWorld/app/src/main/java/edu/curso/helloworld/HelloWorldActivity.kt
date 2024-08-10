package edu.curso.helloworld
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
class HelloWorldActivity : Activity() {

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        /*
        val btn = Button( this )
        // TODO: Mover o texto para um resource do tipo String
        btn.text = getString(R.string.button_text)
        setContentView( btn )
        */

        setContentView( R.layout.helloworld_layout )

        Log.v("HELLO", "onCreate() executado")
    }

    override fun onDestroy() {
        Log.v("HELLO", "onDestroy() executado")
        super.onDestroy()
    }
}