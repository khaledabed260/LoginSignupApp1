package com.example.loginsignupapp;


import java.io.Serializable;

public class HomeWorkout implements Serializable {
    private String sets;
    private String name;
    private String difficulty;
    private String photo;
    private HWCat category;

    public HomeWorkout() {
    }

    public HomeWorkout(String sets, String name, String difficulty, String photo, HWCat category) {
        this.sets = sets;
        this.name = name;
        this.difficulty = difficulty;
        this.photo = photo;
        this.category = category;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPhoto() { return photo;}

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public HWCat getCategory() {
        return category;
    }

    public void setCategory(HWCat category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "HomeWorkout{" +
                "sets='" + sets + '\'' +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", photo='" + photo + '\'' +
                ", category=" + category +
                '}';
    }
}