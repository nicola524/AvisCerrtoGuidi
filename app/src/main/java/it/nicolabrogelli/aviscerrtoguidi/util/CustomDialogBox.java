package it.nicolabrogelli.aviscerrtoguidi.util;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.nicolabrogelli.aviscerrtoguidi.R;


/**
 * Created by Nicola on 27/08/2015.
 */
public class CustomDialogBox extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dialog, container, false);
        getDialog().setTitle("Avis Cerreto Guidi");
        getDialog().setCanceledOnTouchOutside(false);

        return rootView;
    }

}
