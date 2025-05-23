package com.example.projectandoid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.projectandoid.Domain.SliderItems;
import com.example.projectandoid.R;

import java.util.ArrayList;

// Adaptateur pour le slider d'images
public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewholder> {
    // Liste des éléments du slider
    private ArrayList<SliderItems> sliderItems;
    // Composant ViewPager2 pour le défilement
    private ViewPager2 viewPager2;
    // Contexte de l'application
    private Context context;
    // Runnable pour le slider infini (non recommandé pour les sliders simples)
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    // Constructeur de l'adaptateur
    public SliderAdapter(ArrayList<SliderItems> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    // Crée un nouveau ViewHolder pour chaque item du slider
    @NonNull
    @Override
    public SliderAdapter.SliderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new SliderViewholder(LayoutInflater.from(context).inflate
                (R.layout.slider_item_container, parent, false));
    }

    // Lie les données à la vue du slider
    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SliderViewholder holder, int position) {
        holder.setImage(sliderItems.get(position));
        if (position==sliderItems.size() - 2){
            viewPager2.post(runnable);
        }
    }

    // Retourne le nombre total d'éléments
    @Override
    public int getItemCount() {
        return sliderItems.size() ;
    }

    // ViewHolder pour chaque image du slider
    public class SliderViewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public SliderViewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlider);
        }

        // Charge l'image dans l'ImageView
        void setImage(SliderItems sliderItems){
            Glide.with(context)
                    .load(sliderItems.getUrl())
                    .into(imageView);
        }
    }
}

/****/
