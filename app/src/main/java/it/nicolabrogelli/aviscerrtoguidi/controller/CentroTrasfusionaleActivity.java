package it.nicolabrogelli.aviscerrtoguidi.controller;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import it.nicolabrogelli.aviscerrtoguidi.R;

public class CentroTrasfusionaleActivity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    private LatLng latLng = null;
    private MapView googleMap; // Might be null if Google Play services APK is not available.
    private GoogleMap mMap;
    private double latitudine;
    private double longitudine;
    private String struttura;
    private String indirizzo;
    private String telefono;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_trasfusionale);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        Bundle b = getIntent().getExtras();
        if(b != null) {
            latitudine = b.getDouble("lat",0.0);
            longitudine = b.getDouble("lon", 0.0);
            struttura = b.getString("struttura");
            indirizzo = b.getString("indirizzo");
            telefono = b.getString("telefono").substring(4);
            latLng = new LatLng(latitudine,longitudine);
        }
        else {
            latitudine = 0.0;
            longitudine = 0.0;
        }

        fab = (FloatingActionButton) findViewById(R.id.myFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(telefono.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }
        });


        googleMap = (MapView) findViewById(R.id.map);
        googleMap.onCreate(savedInstanceState);
        googleMap.onResume();

        try {
            MapsInitializer.initialize(this);
            googleMap.getMap().setOnMarkerClickListener(this);
            googleMap.getMap().setOnMapClickListener(this);
            mMap = googleMap.getMap();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUpMapIfNeeded();

        TextView titolo = (TextView) findViewById(R.id.titolo);
        titolo.setText(struttura);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_centro_trasfusionale, menu);
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        if (googleMap != null) {
            mMap = googleMap.getMap();
            if (mMap == null) {
                Log.d("", "Map Fragment Not Found or no Map in it!!");
            }
            else {
                mMap.clear();
                try {
                    setUpMap();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        Marker CERRETO = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(struttura)
                .snippet(indirizzo));

        // Move the camera instantly to hamburg with a zoom of 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        fab.hide();

        return false;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        fab.show();
    }
}
