package it.nicolabrogelli.aviscerrtoguidi.util;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import it.nicolabrogelli.aviscerrtoguidi.R;

/**
 * Created by Nicola on 05/04/2015.
 */
public final  class Track {

    private static Track sIntance;
    private final Tracker mTraker;

    /**
     *
     * @param context
     */
    private Track(final Context context) {
        mTraker = GoogleAnalytics.getInstance(context).newTracker(R.xml.tracker);
    }

    /**
     *
     * @param context
     * @return
     */
    public synchronized static Track get(final Context context) {
        if(sIntance == null) {
            sIntance = new Track(context);
        }
        return sIntance;
    }

    /**
     *
     * @return
     */
    public synchronized static Track get() {
        if(sIntance == null) {
            throw new IllegalStateException("Invoca get(Context) prima di questo metodo.");
        }
        return sIntance;
    }

    public Tracker getTracker() {
        if(mTraker == null) {
            throw new IllegalStateException("Traker non inizializzato, invoca get(context) prima di questo metodo.");
        }

        return mTraker;
    }

}
