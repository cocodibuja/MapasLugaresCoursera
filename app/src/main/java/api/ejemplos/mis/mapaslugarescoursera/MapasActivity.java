package api.ejemplos.mis.mapaslugarescoursera;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapasActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        Bundle parametros = getIntent().getExtras();
        float latitud = Float.parseFloat(parametros.getString("latitud"));
        float longitud = Float.parseFloat(parametros.getString("longitud"));
        String referencia = parametros.getString("referencia");




        // Add a marker in Sydney and move the camera
       // LatLng lugarSeleccionado = new LatLng(-34, 151);

        LatLng lugarSeleccionado = new LatLng(latitud, longitud);



        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.addMarker(new MarkerOptions().position(lugarSeleccionado).title(referencia));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugarSeleccionado));
       // mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
