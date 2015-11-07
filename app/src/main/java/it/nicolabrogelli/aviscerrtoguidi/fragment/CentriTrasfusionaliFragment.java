package it.nicolabrogelli.aviscerrtoguidi.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.adapter.RecycleAdapterCentroTrasfusionale;
import it.nicolabrogelli.aviscerrtoguidi.model.CentroTrasfusionale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CentriTrasfusionaliFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CentriTrasfusionaliFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CentriTrasfusionaliFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CentriTrasfusionaliFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CentriTrasfusionaliFragment newInstance(String param1, String param2) {
        CentriTrasfusionaliFragment fragment = new CentriTrasfusionaliFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CentriTrasfusionaliFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_centri_trasfusionali, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(new RecycleAdapterCentroTrasfusionale(generateCentroTrasfusionale()));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private ArrayList<CentroTrasfusionale> generateCentroTrasfusionale() {
        ArrayList<CentroTrasfusionale> centroTrasfusionales = new ArrayList<>();
        centroTrasfusionales.add(new CentroTrasfusionale("Simt Ospedale Careggi", "Firenze", "Largo G.a Brambilla, 3", "tel: 055 411030", "fax: 055 7949248", new LatLng(43.8050585,11.2447536)));
        centroTrasfusionales.add(new CentroTrasfusionale("St Ospedale Pediatrico Meyer", "Firenze", "Viale Pieraccini, 29", "tel: 055 5662990", "fax: 055 5662255", new LatLng(43.8103413,11.2523389)));
        centroTrasfusionales.add(new CentroTrasfusionale("Simt Ospedale San Giovanni Di Dio", "Firenze", "Via Di Torregalli, 3", "tel: 055 6932691", "fax: 055 7192513", new LatLng(43.7579199,11.2038821)));
        centroTrasfusionales.add(new CentroTrasfusionale("Simt Ospedale S. M. Annunziata", "Bagno a Ripoli", "Via Dell' Antella, 58", "tel: 055 6936480", "fax: 055 643545", new LatLng(43.732073,11.3057363)));
        centroTrasfusionales.add(new CentroTrasfusionale("St Ospedale Borgo San Lorenzo", "Borgo S. Lorenzo", "Viale Della Resistenza", "tel 055 8451277", "fax: 055 8451276", new LatLng(43.9774672,11.3860704)));
        centroTrasfusionales.add(new CentroTrasfusionale("St Ospedale Santa Verdiana", "Castelfiorentino", "Viale Dei Mille, 1", "tel: 0571 705804", "fax: 0571 705878", new LatLng(43.6102728,10.969559)));
        centroTrasfusionales.add(new CentroTrasfusionale("Simt Ospedale San Giuseppe Empoli", "Empoli", "Viale Boccaccio", "tel: 0571 706628", "fax: 0571 706635", new LatLng(43.7217274,10.9349308)));
        centroTrasfusionales.add(new CentroTrasfusionale("St Ospedale Serristori Di Figline V.no", "Figline Valdarno", "Via Xxv Aprile, 10", "tel: 055 9508296", "fax: 055 952784", new LatLng(43.612472,11.4759772)));
        centroTrasfusionales.add(new CentroTrasfusionale("St Ospedale San Pietro Igneo Fucecchio", "Fucecchio", "P.za Lavagnini, 1", "tel: 0571 705030", "fax: 0571 705394", new LatLng(43.7307221,10.8075731)));
        centroTrasfusionales.add(new CentroTrasfusionale("Raccolta Montespertoli St Castelfiorentino", "Montespertoli", "Viale Matteotti, 6", "tel: 0571 705030", "", new LatLng(43.605106,10.970086)));
        centroTrasfusionales.add(new CentroTrasfusionale("Raccolta Montaione St Castelfiorentino", "Montaione", "C/o Distretto Socio Sanitario - Via Da Filicaia", "tel: 0571 705030", "", new LatLng(0,0)));

        return centroTrasfusionales;
    }

}
