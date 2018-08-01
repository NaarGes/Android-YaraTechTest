package com.example.asus.yarafirstproject.form;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus.yarafirstproject.R;


public class SubmitFragment extends Fragment {
    FragmentsInterface fragmentsInterface;
    Button button;

    public SubmitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentsInterface = (FragmentsInterface) context;
    }

    public static SubmitFragment newInstance() {
        Bundle args = new Bundle();
        SubmitFragment fragment = new SubmitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_submit, null);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentsInterface.onSubmit();
            }
        });
    }
}

