package edu.curso.agendacontatos.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import edu.curso.agendacontatos.R

class MapActivity() : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.maps_layout)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(mapa: GoogleMap) {
        mMap = mapa
        val paulista = LatLng(-23.56395643410109, -46.652397233689534)
        mMap.addMarker(
            MarkerOptions()
            .position(paulista)
            .title("FIAP Paulista")
        )
        mMap.moveCamera(
            CameraUpdateFactory.newLatLng( paulista )
        )

    }
}