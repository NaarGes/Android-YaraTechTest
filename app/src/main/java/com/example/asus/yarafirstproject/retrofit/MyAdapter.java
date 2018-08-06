package com.example.asus.yarafirstproject.retrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.yarafirstproject.R;
import com.example.asus.yarafirstproject.retrofit.model.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<User> allUsersList;
    private OnRecyclerViewClickListener listener;

    public MyAdapter(List<User> dataList, OnRecyclerViewClickListener listener){
        this.allUsersList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText(allUsersList.get(position).getName());
        holder.userEmail.setText(allUsersList.get(position).getEmail());
        final int userID = allUsersList.get(position).getId();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(userID);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allUsersList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private TextView userEmail;

        MyViewHolder(View itemView) {

            super(itemView);
            userName = itemView.findViewById(R.id.user_name_item);
            userEmail = itemView.findViewById(R.id.user_email_item);

        }
    }


}
