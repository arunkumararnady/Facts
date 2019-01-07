package com.assignment.facts.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.assignment.facts.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            MainFragment aboutCountryFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
            if (aboutCountryFragment == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MainFragment(), "MainFragment").commit();
            }
        }
    }
}
