package com.example.asus.yarafirstproject.retrofit;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.yarafirstproject.R;

public class UsersFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_users, null);
        return root;
    }

    public static UsersFragment newInstance() {
        Bundle args = new Bundle();

        UsersFragment fragment = new UsersFragment();
        fragment.setArguments(args);
        return fragment;
    }

}