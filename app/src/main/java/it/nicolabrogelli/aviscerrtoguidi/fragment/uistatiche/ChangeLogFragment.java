package it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import it.gmariotti.changelibs.library.view.ChangeLogRecyclerView;
import it.nicolabrogelli.aviscerrtoguidi.R;


public class ChangeLogFragment extends DialogFragment {

    public ChangeLogFragment() {
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        ChangeLogRecyclerView chgList= (ChangeLogRecyclerView) layoutInflater.inflate(R.layout.fragment_changelog_dialogmaterial, null);


        return new AlertDialog.Builder(getActivity(),R.style.AppTheme)
                .setTitle(R.string.changelog_title_standarddialog)
                .setView(chgList)
                .setPositiveButton(R.string.about_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                )
                .create();


    }
}
