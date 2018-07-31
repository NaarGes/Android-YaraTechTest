package com.example.asus.yarafirstproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

public class RegisterFragment extends Fragment {

    Button login;
    EditText name;
    EditText family;
    EditText email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_register, null);

        // glide
        ImageView imageView = root.findViewById(R.id.yara_logo);
        Glide.with(this).load("http://yaramobile.com/templates/sj_hexagon/images/styling/blue/logo.png").into(imageView);

        login = root.findViewById(R.id.login_user);
        name = root.findViewById(R.id.name);
        family = root.findViewById(R.id.family);
        email = root.findViewById(R.id.email);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), InfoActivity.class);
                User user = new User(name.getText().toString(), family.getText().toString(), email.getText().toString());
                i.putExtra("user", Parcels.wrap(user));
                startActivity(i);
            }
        });

        return root;
    }

    public static RegisterFragment newInstance() {

        Bundle args = new Bundle();

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }
}