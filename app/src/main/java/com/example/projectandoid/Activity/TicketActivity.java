package com.example.projectandoid.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projectandoid.Domain.Item;
import com.example.projectandoid.databinding.ActivityTicketBinding;

// Activity qui affiche le ticket de réservation et permet d'interagir avec le guide
public class TicketActivity extends AppCompatActivity {
    ActivityTicketBinding binding;
    private Item object;

    // Méthode appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Récupère les données de l'intent et initialise l'affichage
        getIntentExtra();
        setVariable();
    }

    // Récupère l'objet passé par l'intent
    private void getIntentExtra() {
        object = (Item) getIntent().getSerializableExtra("object");
    }

    // Initialise l'affichage avec les données de l'item et configure les actions
    private void setVariable() {
        // Chargement de l'image principale
        Glide.with(this)
                .load(object.getPic())
                .into(binding.pic);

        Glide.with(TicketActivity.this)
                .load(object.getTourGuidePic())
                .into(binding.profile);

        binding.backBtn.setOnClickListener(v -> finish());
        binding.titleTxt.setText(object.getTitle());
        binding.durationTxt.setText(object.getDuration());
        binding.timeTxttourGuideTxt.setText(object.getDateTour());
        binding.tourGuideNameTxt.setText(object.getTourGuideName());
        binding.timeTxt.setText(object.getTimeTour());

        // Bouton d'envoi SMS
        binding.messageBtn.setOnClickListener(v -> {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:" + object.getTourGuidePhone()));
            sendIntent.putExtra("sms_body", "type your message");
            startActivity(sendIntent);
        });

        // Bouton d'appel
        binding.callBtn.setOnClickListener(view -> {
            String phone = object.getTourGuidePhone();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);
        });

        // Bouton de téléchargement du ticket
        binding.button2.setOnClickListener(v -> {
            Intent intent = new Intent(TicketActivity.this, PdfActivity.class);
            
            // Obtenir la date actuelle
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            String currentDate = sdf.format(new Date());
            
            // Passer toutes les données nécessaires
            intent.putExtra("title", object.getTitle());
            intent.putExtra("duration", object.getDuration());
            intent.putExtra("guide", object.getTourGuideName());
            intent.putExtra("time", object.getTimeTour());
            intent.putExtra("price", "TND" + object.getPrice());
            intent.putExtra("address", object.getAddress());
            intent.putExtra("date", currentDate);
            intent.putExtra("datetour", object.getDateTour());

            
            startActivity(intent);
        });
    }
}
