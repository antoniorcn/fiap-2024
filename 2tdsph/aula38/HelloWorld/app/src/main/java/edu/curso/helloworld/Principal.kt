package edu.curso.helloworld

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class Principal : Activity() {

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle);

        val txt = TextView(this);
        txt.text = "Hello World";
        setContentView( txt );
    }

}