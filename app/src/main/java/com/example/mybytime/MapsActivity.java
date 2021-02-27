package com.example.mybytime;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybytime.services.IPersonService;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private IPersonService personService;

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
