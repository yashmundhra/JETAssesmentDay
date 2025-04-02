package com.example.restaurantfinderjet.model;

import java.util.List;

public class Restaurant {
    private String name;
    private List<String> cuisines;
    private double rating;
    private String address;

    // Constructors
    public Restaurant() {}

    public Restaurant(String name, List<String> cuisines, double rating, String address) {
        this.name = name;
        this.cuisines = cuisines;
        this.rating = rating;
        this.address = address;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}