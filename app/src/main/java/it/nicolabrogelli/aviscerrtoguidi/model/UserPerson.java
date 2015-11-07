package it.nicolabrogelli.aviscerrtoguidi.model;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

/**
 * Created by Nicola on 06/09/2015.
 */
public class UserPerson {

    GoogleApiClient mGoogleApiClient;

    public UserPerson(GoogleApiClient gap){
        this.mGoogleApiClient = gap;
    }

    public Person getPerson() {
        if(mGoogleApiClient != null) {
            final com.google.android.gms.plus.model.people.Person currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
            return currentPerson;
        } else {
            return null;
        }
    }
}
