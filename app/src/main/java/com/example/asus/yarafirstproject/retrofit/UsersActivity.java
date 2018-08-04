package com.example.asus.yarafirstproject.retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asus.yarafirstproject.R;
import com.example.asus.yarafirstproject.retrofit.model.User;
import com.example.asus.yarafirstproject.retrofit.remote.GetDataService;
import com.example.asus.yarafirstproject.retrofit.remote.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        progressDialog = new ProgressDialog(UsersActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UsersActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        // create a handle for the retrofit instance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<User>> call = service.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
                Toast.makeText(UsersActivity.this, "Something went wrong, please retry", Toast.LENGTH_SHORT).show();
            }
        });


        //UsersFragment usersFragment = UsersFragment.newInstance();
        //getSupportFragmentManager().beginTransaction().replace(R.id.users_content, usersFragment).commit();
    }

    private void generateDataList(List<User> allUsers) {
        myAdapter = new MyAdapter(this, allUsers);
       recyclerView.setAdapter(myAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(UsersActivity.this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


    }
}
