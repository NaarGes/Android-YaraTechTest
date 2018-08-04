package com.example.asus.yarafirstproject.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.yarafirstproject.R;
import com.example.asus.yarafirstproject.retrofit.model.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<User> dataList;
    private Context context;

    public MyAdapter(Context context,List<User> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.item);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_users, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}