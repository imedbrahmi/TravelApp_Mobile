package com.example.projectandoid.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.projectandoid.Adapter.CategoryAdapter;
import com.example.projectandoid.Adapter.PopularAdapter;
import com.example.projectandoid.Adapter.RecommendedAdapter;
import com.example.projectandoid.Adapter.SliderAdapter;
import com.example.projectandoid.Domain.Category;
import com.example.projectandoid.Domain.Item;
import com.example.projectandoid.Domain.Location;
import com.example.projectandoid.Domain.SliderItems;
import com.example.projectandoid.R;
import com.example.projectandoid.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// Activity principale qui affiche la page d'accueil de l'application
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseDatabase database;

    // Méthode appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=FirebaseDatabase.getInstance();

        // Initialisation des différentes sections de la page d'accueil
        initLocation();
        initBanners();
        initCategory();
        initPopular();
        initRecommended();
    }

    // Initialise la section des destinations recommandées
    private void initRecommended() {
        DatabaseReference myref=database.getReference("Item");
        ArrayList<Item> list =new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issuee:snapshot.getChildren()){
                        list.add(issuee.getValue(Item.class));
                    }
                    if(!list.isEmpty()){
                        binding.recyclerViewRecommended.setLayoutManager(
                                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false));
                        RecyclerView.Adapter adapter =new RecommendedAdapter(list);
                        binding.recyclerViewRecommended.setAdapter(adapter);
                    }
                    binding.progressBarRecommended.setVisibility(View.GONE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    // Initialise la section des destinations populaires
    private void initPopular() {
        DatabaseReference myref=database.getReference("Popular");
        ArrayList<Item> list =new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issuee:snapshot.getChildren()){
                        list.add(issuee.getValue(Item.class));
                    }
                    if(!list.isEmpty()){
                        binding.recyclerViewPopular.setLayoutManager(
                                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false));
                        RecyclerView.Adapter adapter =new PopularAdapter(list);
                        binding.recyclerViewPopular.setAdapter(adapter);
                    }
                    binding.progressBarPopular.setVisibility(View.GONE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    // Initialise la section des catégories
    private void initCategory() {
        DatabaseReference myref=database.getReference("Category");
        ArrayList<Category> list =new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issuee:snapshot.getChildren()){
                        list.add(issuee.getValue(Category.class));
                    }
                if(!list.isEmpty()){
                  binding.recyclerViewCategory.setLayoutManager(
                          new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false));
                  RecyclerView.Adapter adapter =new CategoryAdapter(list);
                  binding.recyclerViewCategory.setAdapter(adapter);
                }
                binding.progressBarCategory.setVisibility(View.GONE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    // Initialise la liste des localisations
    private void initLocation() {
        DatabaseReference myref=database.getReference("Location");
        ArrayList<Location> list =new ArrayList<>();
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issuee:snapshot.getChildren()){
                        list.add(issuee.getValue(Location.class));
                    }
                    ArrayAdapter<Location> adapter=new ArrayAdapter<>(MainActivity.this,
                            R.layout.sp_item, list );
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.locationSp.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    // Configure le ViewPager2 pour afficher les bannières
    private void banners(ArrayList<SliderItems> items){
        binding.viewPager2.setAdapter(new SliderAdapter(items, binding.viewPager2));
        binding.viewPager2.setClipToPadding(false);
        binding.viewPager2.setClipChildren(false);
        binding.viewPager2.setOffscreenPageLimit(3);
        binding.viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        binding.viewPager2.setPageTransformer(compositePageTransformer);
    }

    // Initialise la section des bannières
    private void initBanners(){
        DatabaseReference myRef = database.getReference("Banner");
        binding.progressBarBanner.setVisibility(View.VISIBLE);
        ArrayList<SliderItems> items = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        items.add(issue.getValue(SliderItems.class));
                    }
                    banners(items);
                    binding.progressBarBanner.setVisibility(View.GONE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}