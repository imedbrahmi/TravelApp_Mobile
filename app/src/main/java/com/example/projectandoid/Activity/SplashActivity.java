package com.example.projectandoid.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectandoid.databinding.ActivitySplashBinding;

// Activity d'accueil qui affiche l'écran de démarrage
public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    // Méthode appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Lance l'activité principale au clic sur le bouton
        binding.startBtn.setOnClickListener(v ->
                startActivity(new Intent(SplashActivity.this,MainActivity.class))
        );
    }
}