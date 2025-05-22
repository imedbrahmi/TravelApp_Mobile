package com.example.projectandoid.Domain;

public class SliderItems {
    private String url;

    // 🔧 Constructeur vide requis par Firebase
    public SliderItems() {
    }

    // 🔧 Constructeur utile si tu veux créer des SliderItems manuellement
    public SliderItems(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
