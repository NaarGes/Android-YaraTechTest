package com.example.asus.yarafirstproject;

// FIXME bottom navigation active and inactive

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

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
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
        drawerLayout = findViewById(R.id.activity_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nv);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                aboutFragment = AboutFragment.newInstance();
                contactFragment = ContactFragment.newInstance();

                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.profile_nd:
                        Toast.makeText(MainActivity.this, "پروفایل کاربر", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about_nd:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, aboutFragment).commit();
                        return true;
                    case R.id.contact_nd:
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

    // hamburger menu work
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (actionBarDrawerToggle.onOptionsItemSelected(item)) || super.onOptionsItemSelected(item);
    }

    // close the drawer if opened when back button tapped
    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}