package com.example.projectandoid.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectandoid.Activity.DetailActivity;
import com.example.projectandoid.Domain.Item;
import com.example.projectandoid.databinding.ViewholderCategoryBinding;
import com.example.projectandoid.databinding.ViewholderPopularBinding;

import java.util.ArrayList;

// Adaptateur pour afficher la liste des destinations populaires dans un RecyclerView
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<Item> items;
    Context context;
    ViewholderPopularBinding binding;

    // Constructeur de l'adaptateur
    public PopularAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    // Crée un nouveau ViewHolder pour chaque destination populaire
    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      binding = ViewholderPopularBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        context = parent.getContext();
        return new Viewholder(binding);
    }

    // Lie les données de la destination à la vue
    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$"+ items.get(position).getPrice());
        binding.addressTxt.setText(items.get(position).getAddress());
        binding.scoreTxt.setText(""+items.get(position).getScore());

        Glide.with(context)
                .load(items.get(position).getPic())
                .into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, DetailActivity.class);
                intent.putExtra("object", items.get(position));
                context.startActivity(intent);
            }
        });
    }

    // Retourne le nombre total de destinations
    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder pour chaque destination populaire
    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderPopularBinding binding) {
            super(binding.getRoot());
        }
    }
}
