package it.nicolabrogelli.aviscerrtoguidi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;import java.util.ArrayList;
import java.util.List;
import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.model.CentroTrasfusionale;


public class RecycleAdapterCentroTrasfusionale extends RecyclerView.Adapter<CentroTrasfusionaleViewHolder>  {

    private List<CentroTrasfusionale> centroTrasfusionales;

    public RecycleAdapterCentroTrasfusionale(List<CentroTrasfusionale> centroTrasfusionales) {
        this.centroTrasfusionales = new ArrayList<CentroTrasfusionale>();
        this.centroTrasfusionales.addAll(centroTrasfusionales);
    }


    @Override
    public CentroTrasfusionaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_view_centrotrasfusionale, parent, false);

        return new CentroTrasfusionaleViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CentroTrasfusionaleViewHolder holder, int position) {
        CentroTrasfusionale  centroTrasfusionale = centroTrasfusionales.get(position);
        holder.struttura.setText(centroTrasfusionale.getStruttura());
        holder.localita.setText(centroTrasfusionale.getLocalita());
        holder.indirizzo.setText(centroTrasfusionale.getIndirizzo());
        holder.telefono.setText(centroTrasfusionale.getTelefono());
        holder.fax.setText(centroTrasfusionale.getFax());
        holder.latLng = centroTrasfusionale.getLatLng();
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return centroTrasfusionales.size();
    }

}
