package com.example.asus.yarafirstproject.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.yarafirstproject.R;
import com.example.asus.yarafirstproject.retrofit.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> allUserPosts;

    public PostAdapter(List<Post> dataList){
        this.allUserPosts = dataList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("PostAdapter", "inside onCreateViewHolder");
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Log.v("PostAdapter", "inside onBindViewHolder");
        holder.title.setText(allUserPosts.get(position).getTitle());
        holder.body.setText(allUserPosts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return allUserPosts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView body;

        PostViewHolder(View itemView) {

            super(itemView);
            Log.v("PostAdapter", "inside PostViewHolder");
            title = itemView.findViewById(R.id.post_title_item);
            body = itemView.findViewById(R.id.post_body_item);
        }
    }
}
