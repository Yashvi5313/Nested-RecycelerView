package com.example.newssectiondemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newssectiondemo.Model.News;
import com.example.newssectiondemo.databinding.RowHeadlineBinding;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyViewHolder> {
    Context context;
    List<News> newsList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RowHeadlineBinding binding;

        public MyViewHolder(@NonNull RowHeadlineBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

    public ChildAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChildAdapter.MyViewHolder(RowHeadlineBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RowHeadlineBinding bind = holder.binding;
        News news = newsList.get(position);

        Glide.with(context).load(news.getNewsImage()).into(holder.binding.fullImg);
        holder.binding.fullTitle.setText(news.getNewsTitle());
        holder.binding.fullStory.setText(news.getNewsStory());
        holder.binding.fullTime.setText(news.getNewsTime());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
