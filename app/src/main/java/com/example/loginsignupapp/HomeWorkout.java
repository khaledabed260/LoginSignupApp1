package com.example.loginsignupapp;

enum HWCategory
{
    Abdominal, Chest, Arm, Leg, Butt, Back
}

public class HomeWorkout {
    private int sets;
    private int duration;
    private int difficulty;
    private String picture;

    public HomeWorkout(int sets, int duration, int difficulty, String picture) {
        this.sets = sets;
        this.duration = duration;
        this.difficulty = difficulty;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "HomeWorkout{" +
                "sets=" + sets +
                ", duration=" + duration +
                ", difficulty=" + difficulty +
                ", picture='" + picture + '\'' +
                '}';
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
