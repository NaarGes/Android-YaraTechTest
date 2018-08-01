package com.example.asus.yarafirstproject;

// FIXME about and contact in main activity

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private CategoryFragment cf;
    private RegisterFragment rf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // navigation drawer listener
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        // FIXME RTL actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //TODO don't use anonymous class
                Intent i = new Intent(MainActivity.this, DeveloperInformationActivity.class);

                switch (item.getItemId()) {
                    case R.id.profile_nd:
                        Toast.makeText(MainActivity.this, "پروفایل کاربر", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about_nd:
                        //FIXME close drawer
                        i.putExtra("fragment", "about");
                        startActivity(i);
                        return true;
                    case R.id.contact_nd:
                        //FIXME close drawer
                        i.putExtra("fragment", "contact");
                        startActivity(i);
                        return true;
                    default:
                        return false;
                }
            }
        });

        // bottom navigation listener

        cf = CategoryFragment.newInstance();
        rf = RegisterFragment.newInstance();

        // TODO show category fragment in start, handle landscape mode
        //getSupportFragmentManager().beginTransaction().replace(R.id.content, cf).commit();

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        bnv.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                        switch (item.getItemId()) {
                            case R.id.favorites_bn:
                                fm.beginTransaction().replace(R.id.content, cf).commit();
                                return true;
                            case R.id.login_bn:
                                fm.beginTransaction().replace(R.id.content, rf).commit();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (this.dl.isDrawerOpen(GravityCompat.START)) {
            this.dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}