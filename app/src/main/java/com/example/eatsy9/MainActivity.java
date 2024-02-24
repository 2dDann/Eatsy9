package com.example.eatsy9;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*MenuActivity menuActivity = new MenuActivity();

        // Get the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin a FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the fragment_container with the fragment
        fragmentTransaction.replace(R.id.fragment_container, menuActivity);

        // Commit the FragmentTransaction
        fragmentTransaction.commit();*/
    }
}