package it.nicolabrogelli.aviscerrtoguidi.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import com.github.paolorotolo.appintro.AppIntro;

import it.nicolabrogelli.aviscerrtoguidi.BuildConfig;
import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.controller.MainActivity;
import it.nicolabrogelli.aviscerrtoguidi.fragment.SampleSlide;


public class MainIntro extends AppIntro {

    SharedPreferences SP;

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));

        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String strUserName = SP.getString("username", "NA");
        boolean bAppQuickStart = SP.getBoolean("applicationQuickStart", false);

        if(bAppQuickStart) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        else {

        }

    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();
        SharedPreferences.Editor editor = SP.edit();
        editor.putBoolean("applicationQuickStart", true);
        Boolean flag =  editor.commit();
        //if(flag)
        //    Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v){
        loadMainActivity();
    }
}
