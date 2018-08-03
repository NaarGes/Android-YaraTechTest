package com.example.asus.yarafirstproject.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.asus.yarafirstproject.R;


public class FormActivity extends AppCompatActivity implements FragmentsInterface {

    String firstName;
    String lastName;

    // FIXME landscape mode creates fragments (saveState)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        NameFragment nameFragment = NameFragment.newInstance();
        FamilyFragment familyFragment = FamilyFragment.newInstance();
        SubmitFragment submitFragment = SubmitFragment.newInstance();

        getSupportFragmentManager().beginTransaction().add(R.id.family_f, familyFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.submit_f, submitFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.name_f, nameFragment).commit();
    }

    @Override
    public void onSetText(String type, String value) {
        if(type.equals("name")){
            firstName = value;
        } else if(type.equals("family")) {
            lastName = value;
        }
    }

    @Override
    public void onSubmit() {
        Toast.makeText(this, firstName + " " + lastName, Toast.LENGTH_SHORT).show();
    }
}
