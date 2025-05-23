package com.example.projectandoid.Domain;

// Classe représentant un élément du slider
public class SliderItems {
    // URL de l'image du slider
    private String url;

    // Constructeur vide requis par Firebase
    public SliderItems() {
    }

    // Constructeur avec paramètre pour créer un slider manuellement
    public SliderItems(String url) {
        this.url = url;
    }

    // Retourne l'URL de l'image
    public String getUrl() {
        return url;
    }

    // Modifie l'URL de l'image
    public void setUrl(String url) {
        this.url = url;
    }
}
