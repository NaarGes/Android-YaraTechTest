package com.example.asus.yarafirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();

        User user = Parcels.unwrap(i.getParcelableExtra("user"));

        TextView name = findViewById(R.id.name_tv);
        TextView family = findViewById(R.id.family_tv);
        TextView email = findViewById(R.id.email_tv);

        String namePlaceHolder = "نام: " + user.getName();
        String familyPlaceHolder = "نام خانوادگی:" + user.getFamily();
        String emailPlaceHolder = "ایمیل:" + user.getEmail();
        name.setText(namePlaceHolder);
        family.setText(familyPlaceHolder);
        email.setText(emailPlaceHolder);
    }
}