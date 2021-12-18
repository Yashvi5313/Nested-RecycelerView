package com.example.newssectiondemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newssectiondemo.MainActivity;
import com.example.newssectiondemo.Model.Root;
import com.example.newssectiondemo.databinding.RowNewsBinding;

import java.util.ArrayList;
import java.util.List;

public class MainStoryAdapter extends RecyclerView.Adapter<MainStoryAdapter.MyViewHolder> {
    Context context;
    List<Root> rootArrayList;

    public MainStoryAdapter(Context context, ArrayList<Root> rootArrayList) {
        this.context = context;
        this.rootArrayList = rootArrayList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RowNewsBinding binding;

        public MyViewHolder(@NonNull RowNewsBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainStoryAdapter.MyViewHolder(RowNewsBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RowNewsBinding bind = holder.binding;
        Root root = rootArrayList.get(position);

        holder.binding.txtTitle.setText(root.getSectionTitle());
        ChildAdapter childAdapter = new ChildAdapter(context, root.getNews());
        holder.binding.rvHeadline.setAdapter(childAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.binding.rvHeadline.setLayoutManager(layoutManager);
    }

    @Override
    public int getItemCount() {
        return rootArrayList.size();
    }
}
