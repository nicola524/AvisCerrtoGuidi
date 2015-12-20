package it.nicolabrogelli.aviscerrtoguidi.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.squareup.picasso.Picasso;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import it.nicolabrogelli.aviscerrtoguidi.R;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.navigationliveo.NavigationLiveo;
import it.nicolabrogelli.aviscerrtoguidi.fragment.CentriTrasfusionaliFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.ConsiglioFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.NewsFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.PrenotazioneFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.WebFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.ChangeLogFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.ChiPuoDonareFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.ComeDonareFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.ManualeDonatoreFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.MainFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.MapsFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.MeteoFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.CookiePolicyFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.IdoneitaAllaDonazioneFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.IlSangueFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.PercheDonareFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.PirmaDiUnaDonazioneFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.PlusOneFragment;
import it.nicolabrogelli.aviscerrtoguidi.fragment.uistatiche.TipologieDiDonazioneFragment;

public class MainActivity extends NavigationLiveo implements OnItemClickListener,
        PercheDonareFragment.OnFragmentInteractionListener,
        ChiPuoDonareFragment.OnFragmentInteractionListener,
        ComeDonareFragment.OnFragmentInteractionListener,
        PirmaDiUnaDonazioneFragment.OnFragmentInteractionListener,
        TipologieDiDonazioneFragment.OnFragmentInteractionListener,
        IlSangueFragment.OnFragmentInteractionListener,
        IdoneitaAllaDonazioneFragment.OnFragmentInteractionListener,
        WebFragment.OnFragmentInteractionListener,
        NewsFragment.OnFragmentInteractionListener,
        PrenotazioneFragment.OnFragmentInteractionListener,
        ConsiglioFragment.OnFragmentInteractionListener,
        CentriTrasfusionaliFragment.OnFragmentInteractionListener,
        PlusOneFragment.OnFragmentInteractionListener,
        CookiePolicyFragment.OnFragmentInteractionListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private HelpLiveo mHelpLiveo;
    private static final String TAG = "GooglePlayServicesActiv";
    private static final String KEY_IN_RESOLUTION = "is_in_resolution";
    protected static final int REQUEST_CODE_RESOLUTION = 1; // Request code for auto Google Play Services error resolution.
    private GoogleApiClient mGoogleApiClient;  // Google API client.
    private boolean mIsInResolution; // Determines if the client is in a resolution state, and waiting for resolution intent to return.
    private Activity activity;


    @Override
    public void onInt(Bundle savedInstanceState) {

        activity = MainActivity.this;
        MainActivity.this.setTitle(R.string.app_name);

        // User Information
        this.userName.setText("");
        this.userEmail.setText("");
        Picasso.with(this)
                .load(R.mipmap.ic_no_user)
                .fit()
                .centerCrop()
                .into(this.userPhoto);

        this.userBackground.setImageResource(R.drawable.ic_user_background);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.associazione), R.mipmap.ic_supervisor_account_black_24dp);
        mHelpLiveo.add(getString(R.string.membership), R.mipmap.ic_person_black_24dp);
        mHelpLiveo.addSeparator(); // Item separator
        //mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader
        mHelpLiveo.add(getString(R.string.manual), R.mipmap.ic_local_library_black_24dp);
        mHelpLiveo.add(getString(R.string.meteo), R.mipmap.ic_wb_cloudy_black_24dp);
        mHelpLiveo.add("Centri Trasfusionali", R.mipmap.ic_business_black_24dp);
        mHelpLiveo.add(getString(R.string.news), R.mipmap.ic_invert_colors_on_black_24dp);
        //mHelpLiveo.add(getString(R.string.drafts), R.mipmap.ic_drafts_black_24dp);
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.booking), R.mipmap.ic_insert_invitation_black_24dp);
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.site), R.mipmap.ic_public_black_24dp);
        mHelpLiveo.add(getString(R.string.credits), R.mipmap.ic_info_outline_black_24dp);

        //{optional} - Header Customization - method customHeader
//        View mCustomHeader = getLayoutInflater().inflate(R.layout.custom_header_user, this.getListView(), false);
//        ImageView imageView = (ImageView) mCustomHeader.findViewById(R.id.imageView);

        with(this).startingPosition(2) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())

                        //{optional} - List Customization "If you remove these methods and the list will take his white standard color"
                        //.selectorCheck(R.drawable.selector_check) //Inform the background of the selected item color
                        //.colorItemDefault(R.color.nliveo_blue_colorPrimary) //Inform the standard color name, icon and counter
                        //.colorItemSelected(R.color.nliveo_purple_colorPrimary) //State the name of the color, icon and meter when it is selected
                        //.backgroundList(R.color.nliveo_black_light) //Inform the list of background color
                        //.colorLineSeparator(R.color.nliveo_transparent) //Inform the color of the subheader line

                        //{optional} - SubHeader Customization
                .colorItemSelected(R.color.nliveo_blue_colorPrimary)
                .colorNameSubHeader(R.color.nliveo_blue_colorPrimary)
                        //.colorLineSeparator(R.color.nliveo_blue_colorPrimary)

                //.footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)
                .footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)


                    //{optional} - Header Customization
                    //.customHeader(mCustomHeader)

                    //{optional} - Footer Customization
                    //.footerNameColor(R.color.nliveo_blue_colorPrimary)
                    //.footerIconColor(R.color.nliveo_blue_colorPrimary)
                    //.footerBackground(R.color.nliveo_white)

                    .setOnClickUser(onClickPhoto)
                    .setOnPrepareOptionsMenu(onPrepare)
                    .setOnClickFooter(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
        this.setElevationToolBar(position != 2 ? 15 : 0);
    }

    /**
     * Called when the Activity is made visible.
     * A connection to Play Services need to be initiated as
     * soon as the activity is visible. Registers {@code ConnectionCallbacks}
     * and {@code OnConnectionFailedListener} on the
     * activities itself.
     */
    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(Plus.API)
                    .addScope(Plus.SCOPE_PLUS_LOGIN)
                    .addScope(Plus.SCOPE_PLUS_PROFILE)
                            // Optionally, add additional APIs and scopes if required.
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }
        mGoogleApiClient.connect();
    }

    /**
     * Called when activity gets invisible. Connection to Play Services needs to
     * be disconnected as soon as an activity is invisible.
     */
    @Override
    protected void onStop() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
    }

    /**
     * Saves the resolution state.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IN_RESOLUTION, mIsInResolution);
    }

    /**
     * Handles Google Play Services resolution callbacks.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_RESOLUTION:
                retryConnecting();
                break;
        }
    }

    private void retryConnecting() {
        mIsInResolution = false;
        if (!mGoogleApiClient.isConnecting()) {
            mGoogleApiClient.connect();
        }
    }

    /**
     * Called when {@code mGoogleApiClient} is connected.
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        Log.i(TAG, "GoogleApiClient connected");
        // TODO: Start making API requests.

        if(mGoogleApiClient != null) {
            try {
                final Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
                if(currentPerson.hasImage() && currentPerson.getImage().hasUrl()) {
                    final String imageUrl = currentPerson.getImage().getUrl();
                    Picasso.with(this)
                        .load(imageUrl)
                        .fit()
                        .centerCrop()
                        .into(this.userPhoto);


                    this.userName.setText(currentPerson.getDisplayName());

                }
            } catch (NullPointerException ex) {
                Log.i(TAG, ex.toString());
            }
        } else {
            Toast t = Toast.makeText(this, "Si è verifiacto un errore nel recuperare le informazioni da G+", Toast.LENGTH_LONG);
            t.show();
        }
        this.userEmail.setText(Plus.AccountApi.getAccountName(mGoogleApiClient));

    }

    /**
     * Called when {@code mGoogleApiClient} connection is suspended.
     */
    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(TAG, "GoogleApiClient connection suspended");
        retryConnecting();
    }

    /**
     * Called when {@code mGoogleApiClient} is trying to connect but failed.
     * Handle {@code result.getResolution()} if there is a resolution
     * available.
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "GoogleApiClient connection failed: " + result.toString());
        if (!result.hasResolution()) {
            // Show a localized error dialog.
            GooglePlayServicesUtil.getErrorDialog(
                    result.getErrorCode(), this, 0, new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            retryConnecting();
                        }
                    }).show();
            return;
        }
        // If there is an existing resolution error being displayed or a resolution
        // activity has started before, do nothing and wait for resolution
        // progress to be completed.
        if (mIsInResolution) {
            return;
        }
        mIsInResolution = true;
        try {
            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
        } catch (IntentSender.SendIntentException e) {
            Log.e(TAG, "Exception while starting resolution activity", e);
            retryConnecting();
        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){
            case 0:
                mFragment = new MapsFragment();
                MainActivity.super.setTitle(R.string.associazione);
                break;

            case 1:
                mFragment = new ConsiglioFragment();
                //mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                MainActivity.super.setTitle(getString(R.string.membership));
                break;

            case 3:
                mFragment = new ManualeDonatoreFragment();
                MainActivity.this.setTitle(R.string.manual);
                break;

            case 4:
                mFragment = new MeteoFragment();
                MainActivity.this.setTitle(R.string.meteo);
                break;

            case 5:
                mFragment = new CentriTrasfusionaliFragment();
                MainActivity.this.setTitle(R.string.centri_trasfusionali);
                break;

            case 6:
                mFragment = new NewsFragment();
                MainActivity.this.setTitle(R.string.news);
                break;

            case 8:
                mFragment = new PrenotazioneFragment();
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                //MainActivity.this.setTitle(getString(R.string.booking));

                break;

            case 10:
                mFragment = new WebFragment();
                MainActivity.this.setTitle("Avis Cerreto Guidi");
                break;

            case 11:
                mFragment = new PlusOneFragment();
                MainActivity.this.setTitle(getString(R.string.credits));
                break;


            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                MainActivity.this.setTitle(R.string.app_name);
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
            closeDrawer();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Fragment mFragment;
            //FragmentManager mFragmentManager = getSupportFragmentManager();
            //mFragment = null;
            openDialogFragment(new ChangeLogFragment());

            //Toast.makeText(getApplicationContext(), "onClickPhoto :D", Toast.LENGTH_SHORT).show();
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));

            closeDrawer();
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void reconnectionGooglePlus() {
        if(mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
            mGoogleApiClient = null;
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(Plus.API)
                    .addScope(Plus.SCOPE_PLUS_LOGIN)
                    .addScope(Plus.SCOPE_PLUS_PROFILE)
                            // Optionally, add additional APIs and scopes if required.
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();

            mGoogleApiClient.connect();
        }
    }

    /**
     * Opens the dialog
     *
     * @param dialogStandardFragment
     */
    private void openDialogFragment(DialogFragment dialogStandardFragment) {
        if (dialogStandardFragment != null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment prev = fm.findFragmentByTag("changelogdemo_dialog");
            if (prev != null) {
                ft.remove(prev);
            }
            dialogStandardFragment.show(ft, "changelogdemo_dialog");
        }
    }
}
