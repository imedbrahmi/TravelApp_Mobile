package com.example.projectandoid.Domain;

// Classe représentant une localisation
public class Location {
    // Identifiant de la localisation
    private int Id;
    // Nom ou description de la localisation
    private String Loc;

    // Permet d'afficher le nom de la localisation dans les listes
    @Override
    public String toString() {
        return  Loc;
    }

    // Retourne l'identifiant de la localisation
    public int getId() {
        return Id;
    }

    // Modifie l'identifiant de la localisation
    public void setId(int id) {
        Id = id;
    }

    // Retourne le nom de la localisation
    public String getLoc() {
        return Loc;
    }

    // Modifie le nom de la localisation
    public void setLoc(String loc) {
        Loc = loc;
    }

    // Constructeur par défaut
    public Location(){
    }
}
