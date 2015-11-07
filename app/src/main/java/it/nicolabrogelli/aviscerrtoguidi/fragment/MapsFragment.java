package it.nicolabrogelli.aviscerrtoguidi.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.fragment.MeteoFragment;

public class MapsFragment extends Fragment implements GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    private MapView googleMap; // Might be null if Google Play services APK is not available.
    private GoogleMap mMap;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
    private final LatLng AVIS = new LatLng(43.782279, 10.860198);
    private final LatLng AVIS_CASTELFIORENTINO = new LatLng(43.606142,10.967155);
    private FloatingActionButton fab;
    private FloatingActionButton fabMail;

    public static MeteoFragment newInstance(String text){
        MeteoFragment mFragment = new MeteoFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        final TextView telefono = (TextView) rootView.findViewById(R.id.textView_telefono);
        final TextView cellualre = (TextView) rootView.findViewById(R.id.textView_cellulare);
        final TextView email = (TextView) rootView.findViewById(R.id.textView_mail);

        fab = (FloatingActionButton) rootView.findViewById(R.id.myFAB);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + telefono.getText()));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }
        });

        fabMail = (FloatingActionButton) rootView.findViewById(R.id.myFABMail);

        fabMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_VIEW);
                email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"cerretoguidi.comunale@avis.it"});
                startActivity(email);
            }
        });

        googleMap = (MapView) rootView.findViewById(R.id.map);
        googleMap.onCreate(savedInstanceState);
        googleMap.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
            googleMap.getMap().setOnMarkerClickListener(this);
            googleMap.getMap().setOnMapClickListener(this);
            mMap = googleMap.getMap();

        } catch (Exception e) {
            e.printStackTrace();
        }

        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono.getText()));
                startActivity(i);
            }
        });

        cellualre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + cellualre.getText()));
                startActivity(i);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_VIEW);
                email.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { "cerretoguidi.comunale@avis.it" });
                startActivity(email);
            }
        });


        setUpMapIfNeeded();

        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
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
                .position(AVIS)
                .title("Avis Comunale Cerreto Guidi")
                .snippet("Via 2 Settembre, 167 Cerreto Guidi Firenze"));

        // Move the camera instantly to hamburg with a zoom of 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.7159089,10.9360046), 15));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


        Marker CASTELFIORENTINO = mMap.addMarker(new MarkerOptions()
                .position(AVIS_CASTELFIORENTINO)
                .title("Avis Castelfiorentino")
                .snippet("Piazza Antonio Gramsci, 20\n" +
                        "50051 Castelfiorentino FI\n" +
                        "Italia")
        );
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        fab.hide();
        fabMail.hide();

        return false;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        fab.show();
        fabMail.show();
    }
}
