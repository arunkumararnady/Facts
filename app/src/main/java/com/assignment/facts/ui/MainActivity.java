package com.assignment.facts.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.assignment.facts.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.activity_title);
        if (savedInstanceState == null && findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MainFragment())
                    .commitNow();
        }
    }
}
