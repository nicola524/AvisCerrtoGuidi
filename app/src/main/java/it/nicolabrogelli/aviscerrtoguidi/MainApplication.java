package it.nicolabrogelli.aviscerrtoguidi;

import android.app.Application;
import it.nicolabrogelli.aviscerrtoguidi.util.Track;


public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // We initialize the Tracking
        //Track.get(this);
    }
}
