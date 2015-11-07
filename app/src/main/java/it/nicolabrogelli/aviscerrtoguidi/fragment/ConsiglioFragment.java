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


import java.util.ArrayList;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.adapter.RecycleAdapterConsiglio;
import it.nicolabrogelli.aviscerrtoguidi.model.Consiglio;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsiglioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsiglioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsiglioFragment extends Fragment {
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
     * @return A new instance of fragment ConsiglioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsiglioFragment newInstance(String param1, String param2) {
        ConsiglioFragment fragment = new ConsiglioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ConsiglioFragment() {
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
        View view = inflater.inflate(R.layout.fragment_consiglio, container, false);



        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(new RecycleAdapterConsiglio(generateConsiglio()));

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


    private ArrayList<Consiglio> generateConsiglio() {
        ArrayList<Consiglio> consiglios = new ArrayList<>();
        consiglios.add(new Consiglio("Brongo Morena", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Crudeli Guido", "Presidente", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Stefanelli Ruggero", "Vice Presidente ", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Lamanna Giuseppe", "Tesoriere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Brogioli Eugenio", "Sindaco Revisore", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Antonini Sergio", "Sindaco Revisore", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Biondi Leopoldo", "Sindaco Revisore", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Donatello Riccardo", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Mancini Patrizia", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Meacci Enzo", "Consigliere ", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Meacci Felice", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Mariotti Mauro", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Zingoni Mirko", "Segretario", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Maraviglia Luca", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Schembri Giovanni", "Consigliere ", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Masini Mirella", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Mariotti Francesca", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Soriani Andrea", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Ponziani Andrea", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Panicacci Cristina", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Buti Serena", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Crudeli Matteo", "Consigliere ", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Capuano Gianni", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        consiglios.add(new Consiglio("Pasquetti Luca", "Consigliere", "Avis Comunale Cerreto Guidi", "", ""));
        return consiglios;
    }

}
