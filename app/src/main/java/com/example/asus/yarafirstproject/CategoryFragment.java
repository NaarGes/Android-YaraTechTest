package com.example.asus.yarafirstproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus.yarafirstproject.retrofit.UsersActivity;

public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_category, null);

        Button butt = root.findViewById(R.id.go_to_users_btn);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext() ,UsersActivity.class);
                startActivity(i);
            }
        });
        return root;
    }

    public static CategoryFragment newInstance() {
        Bundle args = new Bundle();

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}