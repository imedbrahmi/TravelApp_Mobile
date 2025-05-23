package com.example.projectandoid.Domain;

import java.io.Serializable;

// Classe représentant une destination ou un item touristique
public class Item implements Serializable {
    // Titre de la destination
    private String title;
    // Adresse de la destination
    private String address;
    // Description de la destination
    private String description;
    // URL de l'image principale
    private String pic;
    // Durée du séjour
    private String duration;
    // Heure du tour
    private String timeTour;
    // Date du tour
    private String dateTour;
    // Nom du guide
    private String tourGuideName;
    // Téléphone du guide
    private String tourGuidePhone;
    // Photo du guide
    private String tourGuidePic;
    // Distance
    private String distance;
    // Prix
    private int price;
    // Nombre de lits
    private int bed;
    // Note/score
    private double score;

    // Retourne le titre de la destination
    public String getTitle() {
        return title;
    }

    // Modifie le titre de la destination
    public void setTitle(String title) {
        this.title = title;
    }

    // Retourne l'adresse
    public String getAddress() {
        return address;
    }

    // Modifie l'adresse
    public void setAddress(String address) {
        this.address = address;
    }

    // Retourne la description
    public String getDescription() {
        return description;
    }

    // Modifie la description
    public void setDescription(String description) {
        this.description = description;
    }

    // Retourne l'URL de l'image
    public String getPic() {
        return pic;
    }

    // Modifie l'URL de l'image
    public void setPic(String pic) {
        this.pic = pic;
    }

    // Retourne la durée
    public String getDuration() {
        return duration;
    }

    // Modifie la durée
    public void setDuration(String duration) {
        this.duration = duration;
    }

    // Retourne l'heure du tour
    public String getTimeTour() {
        return timeTour;
    }

    // Modifie l'heure du tour
    public void setTimeTour(String timeTour) {
        this.timeTour = timeTour;
    }

    // Retourne la date du tour
    public String getDateTour() {
        return dateTour;
    }

    // Modifie la date du tour
    public void setDateTour(String dateTour) {
        this.dateTour = dateTour;
    }

    // Retourne le nom du guide
    public String getTourGuideName() {
        return tourGuideName;
    }

    // Modifie le nom du guide
    public void setTourGuideName(String tourGuideName) {
        this.tourGuideName = tourGuideName;
    }

    // Retourne le téléphone du guide
    public String getTourGuidePhone() {
        return tourGuidePhone;
    }

    // Modifie le téléphone du guide
    public void setTourGuidePhone(String tourGuidePhone) {
        this.tourGuidePhone = tourGuidePhone;
    }

    // Retourne la photo du guide
    public String getTourGuidePic() {
        return tourGuidePic;
    }

    // Modifie la photo du guide
    public void setTourGuidePic(String tourGuidePic) {
        this.tourGuidePic = tourGuidePic;
    }

    // Retourne la distance
    public String getDistance() {
        return distance;
    }

    // Modifie la distance
    public void setDistance(String distance) {
        this.distance = distance;
    }

    // Retourne le prix
    public int getPrice() {
        return price;
    }

    // Modifie le prix
    public void setPrice(int price) {
        this.price = price;
    }

    // Retourne le nombre de lits
    public int getBed() {
        return bed;
    }

    // Modifie le nombre de lits
    public void setBed(int bed) {
        this.bed = bed;
    }

    // Retourne le score
    public double getScore() {
        return score;
    }

    // Modifie le score
    public void setScore(double score) {
        this.score = score;
    }
}
