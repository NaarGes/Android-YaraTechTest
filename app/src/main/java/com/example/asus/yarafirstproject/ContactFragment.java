package com.example.asus.yarafirstproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ContactFragment extends Fragment {
    private String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_contact, null);

        ImageButton github = root.findViewById(R.id.developer_github_ib);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = getString(R.string.developer_github);
                goToUrl(url);
            }
        });

        ImageButton email = root.findViewById(R.id.developer_email_ib);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = getString(R.string.developer_email);
                goToUrl(url);
            }
        });

        ImageButton linkedIn = root.findViewById(R.id.developer_linkedin_ib);
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = getString(R.string.developer_linkedin);
                goToUrl(url);
            }
        });

        ImageButton telegram = root.findViewById(R.id.developer_telegram_ib);
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = getString(R.string.developer_telegram);
                goToUrl(url);
            }
        });

        return root;
    }

    public static ContactFragment newInstance() {
        Bundle args = new Bundle();

        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);

    }
}