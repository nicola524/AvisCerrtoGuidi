package it.nicolabrogelli.aviscerrtoguidi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.ChiPuoDonareFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.ComeDonareFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.IdoneitaAllaDonazioneFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.IlSangueFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.PercheDonareFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.PirmaDiUnaDonazioneFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.TipologieDiDonazioneFragment;


public class ManualeDonatoreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Controi UI

    private Button btnPercheDonare;
    private Button btnChiPuoDonare;
    private Button btnIdonietaAllaDonazione;
    private Button btnComeDonare;
    private Button btnPrimaDiUnaDonazione;
    private Button btnTipologieDiDonazione;
    private Button btnIlSangue;

   // private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Doanzione.
     */
    // TODO: Rename and change types and number of parameters
    public static ManualeDonatoreFragment newInstance(String param1, String param2) {
        ManualeDonatoreFragment fragment = new ManualeDonatoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ManualeDonatoreFragment() {
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

        View view = inflater.inflate(R.layout.fragment_doanzione, container, false);
        btnPercheDonare = (Button) view.findViewById(R.id.Button_donare);
        btnChiPuoDonare = (Button) view.findViewById(R.id.Button_chipuodonare);
        btnIdonietaAllaDonazione = (Button) view.findViewById(R.id.Button_idonieta);
        btnComeDonare = (Button) view.findViewById(R.id.Button_comedonare);
        btnPrimaDiUnaDonazione = (Button) view.findViewById(R.id.Button_primadiunadonazone);
        btnTipologieDiDonazione = (Button) view.findViewById(R.id.Button_tipididonazione);
        btnIlSangue = (Button) view.findViewById(R.id.Button_ilsangue);

        btnPercheDonare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PercheDonareFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnChiPuoDonare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ChiPuoDonareFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnIdonietaAllaDonazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new IdoneitaAllaDonazioneFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnComeDonare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ComeDonareFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnPrimaDiUnaDonazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PirmaDiUnaDonazioneFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnTipologieDiDonazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new TipologieDiDonazioneFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnIlSangue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new IlSangueFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
