package it.nicolabrogelli.aviscerrtoguidi.util;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import com.parse.PushService;

import android.app.Application;

import it.nicolabrogelli.aviscerrtoguidi.controller.MainActivity;

public class ParseApplication extends Application {


    @Override
	public void onCreate() {
		super.onCreate();


		// Add your initialization code here
		Parse.initialize(this, "D10FdE4RXUF5PuEqjpXvNWxwgILcc63UtKrKwIiL", "204DpRJbGXPoJQAs1xUrTiMgbcJW6x0bjWskM3zP");
        PushService.setDefaultPushCallback(this, MainActivity.class);

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}
