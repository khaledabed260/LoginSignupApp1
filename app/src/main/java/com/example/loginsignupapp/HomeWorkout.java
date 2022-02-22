package com.example.loginsignupapp;


public class HomeWorkout {
    private String sets;
    private String name;
    private String bodyPart;
    private String difficulty;
    private String picture;
    private HWCategory category;

    public HomeWorkout() {
    }

    public HomeWorkout(String sets, String name, String bodyPart, String difficulty, String picture, HWCategory category) {
        this.sets = sets;
        this.name = name;
        this.bodyPart = bodyPart;
        this.difficulty = difficulty;
        this.picture = picture;
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

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public HWCategory getCategory() {
        return category;
    }

    public void setCategory(HWCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "HomeWorkout{" +
                "sets='" + sets + '\'' +
                ", name='" + name + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", picture='" + picture + '\'' +
                ", category=" + category +
                '}';
    }
}