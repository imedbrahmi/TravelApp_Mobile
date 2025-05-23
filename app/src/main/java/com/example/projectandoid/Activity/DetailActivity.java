package com.example.projectandoid.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.projectandoid.Domain.Item;
import com.example.projectandoid.R;
import com.example.projectandoid.databinding.ActivityDetailBinding;

// Activity qui affiche les détails d'une destination touristique
public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    private Item object;

    // Méthode appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupère les données de l'intent et initialise l'affichage
        getIntentExtra();
        setVariable();
    }

    // Initialise l'affichage avec les données de l'item
    private void setVariable() {
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("TND"+object.getPrice());
        binding.backBtn.setOnClickListener(v->finish());
        binding.bedTxt.setText(""+object.getBed());
        binding.durationTxt.setText(object.getDuration());
        binding.distanceTxt.setText(object.getDistance());
        binding.descriptionTxt.setText(object.getDescription());
        binding.addressTxt.setText(object.getAddress());
        binding.ratingBar.setRating((float) object.getScore());
        binding.ratingTxt.setText(object.getScore()+" Rating");

        Glide.with(DetailActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        // Action du bouton pour réserver/acheter
        binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DetailActivity.this, TicketActivity.class);
                intent.putExtra("object", object);
                startActivity(intent);
            }
        });
    }

    // Récupère l'objet passé par l'intent
    private void getIntentExtra() {
        object=(Item) getIntent().getSerializableExtra("object");
    }
}