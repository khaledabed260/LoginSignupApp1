package com.example.loginsignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNewWorkout extends AppCompatActivity {
    private EditText etExercise, etSets, etBodyPart;
    private ImageView ivPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_workout);
        connectComponent();

    }
    private void connectComponent(){
        etExercise=findViewById(R.id.etExercise);
        etBodyPart=findViewById(R.id.etBodyPart);
        etSets = findViewById(R.id.etSets);
        etIVPhotoAddExercise = findViewById(R.id.etIVPhotoAddExercise);

    }
}