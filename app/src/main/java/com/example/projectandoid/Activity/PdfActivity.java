package com.example.projectandoid.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectandoid.R;

// Activity qui affiche le ticket PDF avec les informations de réservation
public class PdfActivity extends AppCompatActivity {
    // Méthode appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_pdf);

        // Récupérer les données envoyées par l'intent
        String title = getIntent().getStringExtra("title");
        String duration = getIntent().getStringExtra("duration");
        String guide = getIntent().getStringExtra("guide");
        String datetour = getIntent().getStringExtra("datetour");
        String time = getIntent().getStringExtra("time");
        String price = getIntent().getStringExtra("price");
        String address = getIntent().getStringExtra("address");
        String date = getIntent().getStringExtra("date");

        // Remplir le layout avec les informations reçues
        ((TextView)findViewById(R.id.pdfTripTitle)).setText("Titre du voyage : " + title);
        ((TextView)findViewById(R.id.pdfDuration)).setText("Durée : " + duration);
        ((TextView)findViewById(R.id.pdfGuide)).setText("Guide touristique : " + guide);
        ((TextView)findViewById(R.id.pdfDateDepart)).setText("Guide Date de départ:" + datetour);
        ((TextView)findViewById(R.id.pdfTime)).setText("Heure de départ : " + time);
        ((TextView)findViewById(R.id.pdfPrice)).setText("Prix : " + price);
        ((TextView)findViewById(R.id.pdfAddress)).setText("Adresse : " + address);
        ((TextView)findViewById(R.id.pdfDate)).setText("Généré le : " + date);
    }
} 