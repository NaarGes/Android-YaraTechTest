package com.example.asus.yarafirstproject.retrofit;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.asus.yarafirstproject.retrofit.model.Post;
import com.example.asus.yarafirstproject.retrofit.model.User;
import com.example.asus.yarafirstproject.retrofit.remote.GetDataService;
import com.example.asus.yarafirstproject.retrofit.remote.RetrofitClientInstance;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class PostsFragment extends Fragment {

    private int userID;
    private PostAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_posts, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        this.userID = getArguments().getInt("User ID");
        Log.v("PostFragment", "onViewCreated, user id = " + this.userID);

        recyclerView = view.findViewById(R.id.post_recycler);
        Log.v("PostFragment", "onViewCreated, recycler view = "+recyclerView);

        // ---------------- HERE ERROR HAPPENS!
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        retrofit2.Call<List<Post>> call = service.getUserPosts(userID);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Post>> call, Response<List<Post>> response) {

                adapter = new PostAdapter(response.body());
                recyclerView.setAdapter(adapter);
                RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
                recyclerView.addItemDecoration(itemDecoration);

                Log.d("response" ,response.body().toString());
            }
            @Override
            public void onFailure(retrofit2.Call<List<Post>> call, Throwable t) {

                Toast.makeText(getContext(),
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static PostsFragment newInstance(int userId) {

        Log.v("PostFragments", "inside posts newInstance, user id = " + userId);
        Bundle args = new Bundle();
        args.putInt("User ID", userId);
        PostsFragment fragment = new PostsFragment();
        fragment.setArguments(args);
        return fragment;
    }

}