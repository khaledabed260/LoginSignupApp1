package com.example.loginsignupapp;


import java.io.Serializable;

public class HomeWorkout implements Serializable {
    private String sets;
    private String name;
    private String difficulty;
    private HWCat category;
    private String photo;

    public HomeWorkout() {
    }

    public HomeWorkout(String sets, String name, String difficulty, HWCat category,String photo) {
        this.sets = sets;
        this.name = name;
        this.difficulty = difficulty;
        this.category = category;
        this.photo = photo;

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

    public HWCat getCategory() {
        return category;
    }

    public void setCategory(HWCat category) {this.category = category;}

    public String getPhoto() { return photo;}

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    @Override
    public String toString() {
        return "HomeWorkout{" +
                "sets='" + sets + '\'' +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", category=" + category +
                ", photo='" + photo + '\'' +
                '}';
    }
}