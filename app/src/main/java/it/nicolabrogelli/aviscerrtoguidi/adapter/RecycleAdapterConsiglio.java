package it.nicolabrogelli.aviscerrtoguidi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.model.Consiglio;


/**
 * Created by Nicola on 13/09/2015.
 */
public class RecycleAdapterConsiglio extends RecyclerView.Adapter<ConsiglioViewHolder> {

    private List<Consiglio> consiglios;

    public RecycleAdapterConsiglio(List<Consiglio> consiglios) {
        this.consiglios = new ArrayList<Consiglio>();
        this.consiglios.addAll(consiglios);
    }

    @Override
    public ConsiglioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view_consiglio, viewGroup, false);

        return new ConsiglioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ConsiglioViewHolder consiglioViewHolder, int position) {
        Consiglio consiglio = consiglios.get(position);
        consiglioViewHolder.titleText.setText(consiglio.getCognomeNome());
        consiglioViewHolder.contentText.setText(consiglio.getRuolo());
        consiglioViewHolder.struttura.setText(consiglio.getStruttura());
    }



    @Override
    public int getItemCount() {
        return consiglios.size();
    }
}
