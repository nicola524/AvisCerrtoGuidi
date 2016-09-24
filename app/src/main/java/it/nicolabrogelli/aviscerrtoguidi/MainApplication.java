package it.nicolabrogelli.aviscerrtoguidi;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import it.nicolabrogelli.aviscerrtoguidi.util.Track;


public class MainApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        // We initialize the Tracking
        Track.get(this);

    }
}
