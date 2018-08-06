package com.example.asus.yarafirstproject.retrofit;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.asus.yarafirstproject.retrofit.model.User;
import com.example.asus.yarafirstproject.retrofit.remote.GetDataService;
import com.example.asus.yarafirstproject.retrofit.remote.RetrofitClientInstance;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class UsersFragment extends Fragment {

    private MyAdapter myAdapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_users, container, false);

        recyclerView = root.findViewById(R.id.users_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        retrofit2.Call<List<User>> call = service.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(retrofit2.Call<List<User>> call, Response<List<User>> response) {

                myAdapter = new MyAdapter(response.body(), new OnRecyclerViewClickListener() {
                    @Override
                    public void onItemClick(int userID) {
                        ((OnUserClickListener) getActivity()).goToUserPosts(userID);
                    }
                });

                recyclerView.setAdapter(myAdapter);
                RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(container.getContext(), DividerItemDecoration.VERTICAL);
                recyclerView.addItemDecoration(itemDecoration);

                Log.d("response", response.body().toString());
            }
            @Override
            public void onFailure(retrofit2.Call<List<User>> call, Throwable t) {

                Toast.makeText(getContext(),"Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    public static UsersFragment newInstance() {
        Bundle args = new Bundle();

        UsersFragment fragment = new UsersFragment();
        fragment.setArguments(args);
        return fragment;
    }

}