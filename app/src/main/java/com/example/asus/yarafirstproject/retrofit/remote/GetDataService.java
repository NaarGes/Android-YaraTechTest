package com.example.asus.yarafirstproject.retrofit.remote;

import com.example.asus.yarafirstproject.retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/users")
    Call<List<User>> getAllUsers();
}
