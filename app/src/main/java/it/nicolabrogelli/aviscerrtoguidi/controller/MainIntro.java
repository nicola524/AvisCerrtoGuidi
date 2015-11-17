package it.nicolabrogelli.aviscerrtoguidi.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import com.github.paolorotolo.appintro.AppIntro;

import it.nicolabrogelli.aviscerrtoguidi.R;
import it.nicolabrogelli.aviscerrtoguidi.controller.MainActivity;
import it.nicolabrogelli.aviscerrtoguidi.fragment.SampleSlide;


public class MainIntro extends AppIntro {

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();
        //Toast.makeText(getApplicationContext(), getString(R.string.skip), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v){
        loadMainActivity();
    }
}
