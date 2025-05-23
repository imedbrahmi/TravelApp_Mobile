package com.example.projectandoid.Domain;

// Classe représentant une catégorie
public class Category {
    // Identifiant de la catégorie
    private int Id;
    // Chemin de l'image de la catégorie
    private String ImagePath;
    // Nom de la catégorie
    private String Name;

    // Constructeur par défaut
    public Category() {
    }

    // Retourne l'identifiant de la catégorie
    public int getId() {
        return Id;
    }

    // Modifie l'identifiant de la catégorie
    public void setId(int id) {
        Id = id;
    }

    // Retourne le chemin de l'image
    public String getImagePath() {
        return ImagePath;
    }

    // Modifie le chemin de l'image
    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    // Retourne le nom de la catégorie
    public String getName() {
        return Name;
    }

    // Modifie le nom de la catégorie
    public void setName(String name) {
        Name = name;
    }
}
