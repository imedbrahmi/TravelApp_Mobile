package com.example.projectandoid.Adapter;

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
import com.example.projectandoid.databinding.ViewholderRecommendedBinding;

import java.util.ArrayList;

// Adaptateur pour afficher la liste des destinations recommandées dans un RecyclerView
public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.Viewholder> {
    private final ArrayList<Item> items;
    private Context context;

    // Constructeur de l'adaptateur
    public RecommendedAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    // Crée un nouveau ViewHolder pour chaque destination recommandée
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderRecommendedBinding binding = ViewholderRecommendedBinding.inflate(
                LayoutInflater.from(context), parent, false);
        return new Viewholder(binding);
    }

    // Lie les données de la destination à la vue
    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.Viewholder holder, int position) {
        Item item = items.get(position);
        holder.binding.titleTxt.setText(item.getTitle());
        holder.binding.priceTxt.setText("$" + item.getPrice());
        holder.binding.addressTxt.setText(item.getAddress());
        holder.binding.scoreTxt.setText(String.valueOf(item.getScore()));
        Glide.with(context)
                .load(item.getPic())
                .into(holder.binding.pic);
        holder.itemView.setOnClickListener(view -> {
            Intent intent= new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    // Retourne le nombre total de destinations recommandées
    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder pour chaque destination recommandée
    public static class Viewholder extends RecyclerView.ViewHolder {
        ViewholderRecommendedBinding binding;
        public Viewholder(ViewholderRecommendedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
