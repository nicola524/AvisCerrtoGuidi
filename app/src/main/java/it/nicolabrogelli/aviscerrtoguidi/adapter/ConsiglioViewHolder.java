package it.nicolabrogelli.aviscerrtoguidi.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import it.nicolabrogelli.aviscerrtoguidi.R;


/**
 * Created by Nicola on 13/09/2015.
 */
public class ConsiglioViewHolder extends RecyclerView.ViewHolder {


    protected TextView titleText;
    protected TextView contentText;
    protected TextView struttura;
    protected CardView card;


    public ConsiglioViewHolder(View itemView) {
        super(itemView);
        titleText = (TextView) itemView.findViewById(R.id.name);
        contentText = (TextView) itemView.findViewById(R.id.ruolo);
        struttura = (TextView) itemView.findViewById(R.id.struttura);

        card = (CardView) itemView;
    }

}
