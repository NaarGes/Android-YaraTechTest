package com.example.asus.yarafirstproject;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // navigation drawer listener
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.profile_nd:
                        Toast.makeText(MainActivity.this, "پروفایل کاربر",Toast.LENGTH_SHORT).show();
                    case R.id.contact_nd:
                        Toast.makeText(MainActivity.this, "درباره ما",Toast.LENGTH_SHORT).show();
                    case R.id.about_nd:
                        Toast.makeText(MainActivity.this, "تماس با ما",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }
            }
        });


        // bottom navigation listener
        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        bnv.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.favorites_bn:
                                Toast.makeText(MainActivity.this, "دسته بندی ها", Toast.LENGTH_SHORT).show();
                            case R.id.login_bn:
                                Toast.makeText(MainActivity.this, "صفحه اصلی", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}