package com.example.asus.yarafirstproject;

// FIXME about and contact in main activity
// FIXME bottom navigation active and inactive

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private CategoryFragment categoryFragment;
    private RegisterFragment registerFragment;
    private AboutFragment aboutFragment;
    private ContactFragment contactFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL); //RTL
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // navigation drawer listener
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //TODO don't use anonymous class
                aboutFragment = AboutFragment.newInstance();
                contactFragment = ContactFragment.newInstance();

                switch (item.getItemId()) {
                    case R.id.profile_nd:
                        Toast.makeText(MainActivity.this, "پروفایل کاربر", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about_nd:
                        dl.closeDrawer(GravityCompat.START);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, aboutFragment).commit();
                        return true;
                    case R.id.contact_nd:
                        dl.closeDrawer(GravityCompat.START);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, contactFragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // bottom navigation listener

        categoryFragment = CategoryFragment.newInstance();
        registerFragment = RegisterFragment.newInstance();


        getSupportFragmentManager().beginTransaction().replace(R.id.content, registerFragment).commit();

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        bnv.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                        switch (item.getItemId()) {
                            case R.id.favorites_bn:
                                fm.beginTransaction().replace(R.id.content, categoryFragment).commit();
                                return true;
                            case R.id.login_bn:
                                fm.beginTransaction().replace(R.id.content, registerFragment).commit();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

    // close the drawer if opened when back button tapped
    @Override
    public void onBackPressed() {
        if (this.dl.isDrawerOpen(GravityCompat.START)) {
            this.dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}