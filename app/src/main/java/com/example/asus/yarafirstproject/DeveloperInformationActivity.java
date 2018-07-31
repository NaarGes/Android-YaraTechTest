package com.example.asus.yarafirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeveloperInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_information);

        Intent i = getIntent();
        String fragment = i.getStringExtra("fragment");

        switch (fragment) {
            case "about":
                getSupportFragmentManager().beginTransaction().replace(R.id.developer, AboutFragment.newInstance()).commit();
                break;
            case "contact":
                // todo
                break;
        }

    }
}
