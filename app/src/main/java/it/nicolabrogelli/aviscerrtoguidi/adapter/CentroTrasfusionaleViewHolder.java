package it.nicolabrogelli.aviscerrtoguidi.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.controller.CentroTrasfusionaleActivity;

/**
 * Created by Nicola on 14/09/2015.
 */
public class CentroTrasfusionaleViewHolder extends RecyclerView.ViewHolder  {

    protected TextView struttura;
    protected TextView localita;
    protected TextView indirizzo;
    protected TextView telefono;
    protected TextView fax;
    protected LatLng latLng;
    protected CardView card;

    public CentroTrasfusionaleViewHolder(View itemView)  {
        super(itemView);

        struttura = (TextView) itemView.findViewById(R.id.struttura);
        localita = (TextView) itemView.findViewById(R.id.localita);
        indirizzo = (TextView) itemView.findViewById(R.id.indirizzo);
        telefono = (TextView) itemView.findViewById(R.id.telefono);
        fax = (TextView) itemView.findViewById(R.id.fax);

        card = (CardView) itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), CentroTrasfusionaleActivity.class);
                Bundle b = new Bundle();
                b.clear();
                b.putDouble("lat", latLng.latitude);
                b.putDouble("lon", latLng.longitude);
                b.putString("struttura", struttura.getText().toString());
                b.putString("indirizzo", indirizzo.getText().toString());
                b.putString("telefono", telefono.getText().toString());
                i.putExtras(b);
                v.getContext().startActivity(i);

                Log.d("Log","ciao");

            }
        });
    }



}
