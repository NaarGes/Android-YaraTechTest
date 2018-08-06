package com.example.asus.yarafirstproject.retrofit.remote;

import com.example.asus.yarafirstproject.retrofit.model.Post;
import com.example.asus.yarafirstproject.retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("/users")
    Call<List<User>> getAllUsers();

    @GET("/posts")
    Call<List<Post>> getUserPosts(@Query("userId") int userId);
}
