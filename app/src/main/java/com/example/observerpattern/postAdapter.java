package com.example.observerpattern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class postAdapter extends RecyclerView.Adapter<postAdapter.ViewHolder> {

    public ArrayList<post_viewModel> mExampleList ;

    public postAdapter(ArrayList<post_viewModel> mExampleList) {


        this.mExampleList = mExampleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view , parent , false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        post_viewModel current = mExampleList.get(position);
        holder.postImage.setImageResource(current.getImageView());
        holder.title.setText(current.getTitle());
        holder.url.setText(current.getUrl());
    }

    @Override
    public int getItemCount() {

        return mExampleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView url;
        ImageView postImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postImage = itemView.findViewById(R.id.postPic);
            title = itemView.findViewById(R.id.title_txtv);
            url = itemView.findViewById(R.id.url_txtv);
        }
    }
}
