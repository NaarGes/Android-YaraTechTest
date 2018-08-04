package com.example.asus.yarafirstproject.retrofit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.yarafirstproject.R;


public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        UsersFragment usersFragment = UsersFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.user_post_fragments_content, usersFragment).commit();
    }
}
