package it.nicolabrogelli.aviscerrtoguidi.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.controller.CentroTrasfusionaleActivity;
import it.nicolabrogelli.aviscerrtoguidi.controller.DetailActivity;

/**
 * Created by Nicola on 27/09/2015.
 */
public class NewsViewHolder  extends RecyclerView.ViewHolder  {

    protected TextView Titolo;
    protected ImageView Immagine;
    protected TextView Riassunto;
    protected CardView card;
    protected String Contenuto;

    public NewsViewHolder(View itemView) {
        super(itemView);

        Immagine = (ImageView) itemView.findViewById(R.id.image);
        Titolo = (TextView) itemView.findViewById(R.id.title);
        Riassunto = (TextView) itemView.findViewById(R.id.riassunto);

        card = (CardView) itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), DetailActivity.class);
                Bundle b = new Bundle();
                b.clear();
                b.putString("titolo", Titolo.getText().toString());
                b.putString("riassunto", Riassunto.getText().toString());
                b.putString("contenuto", Contenuto.toString());
                i.putExtras(b);
                v.getContext().startActivity(i);

            }
        });
    }
}
