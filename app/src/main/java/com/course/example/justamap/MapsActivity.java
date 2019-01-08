package com.course.example.justamap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class  MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng BENTLEY = new LatLng(42.3889167, -71.2208033);
    private static final float zoom = 14.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker at Bentley and move the camera
        mMap.addMarker(new MarkerOptions().position(BENTLEY).title("Bentley")
              .snippet("Population 5000"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BENTLEY, zoom));

        mMap.setOnMarkerClickListener(
                new GoogleMap.OnMarkerClickListener() {

                    public boolean onMarkerClick(Marker m) {
                        String title = m.getTitle();
                        String snip = m.getSnippet();
                        Toast.makeText(getApplicationContext(), title + "\n" + snip, Toast.LENGTH_LONG).show();
                        return true;
                    }
                }
        );

        mMap.setOnMapLongClickListener(
                new GoogleMap.OnMapLongClickListener() {
                    public void onMapLongClick(LatLng point) {
                        Toast.makeText(getApplicationContext(), "Long Tap", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }




}
