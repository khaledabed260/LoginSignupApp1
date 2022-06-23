package com.example.loginsignupapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class WorkoutDetailsActivity extends AppCompatActivity {

    private TextView tvName, tvSets, tvDifficulty, tvCategory;
    private ImageView ivPhoto;

    /*
        private String sets;
    private WorkoutCat category;
    private String photo;
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        connectComponents();
        Intent i = this.getIntent();
        HomeWorkout workout = (HomeWorkout) i.getSerializableExtra("rest");

        tvName.setText(workout.getName());
        tvSets.setText(workout.getSets());
        tvDifficulty.setText(workout.getDifficulty());
        tvCategory.setText(workout.getCategory().toString());
        Picasso.get().load(workout.getPhoto()).into(ivPhoto);
    }

    private void connectComponents() {
        tvName = findViewById(R.id.tvNameWorkoutDetails);
        tvSets = findViewById(R.id.tvSetsWorkoutDetails);
        tvDifficulty = findViewById(R.id.tvDifficultyWorkoutDetails);
        tvCategory = findViewById(R.id.tvCategoryWorkoutDetails);
        ivPhoto = findViewById(R.id.ivPhotoWorkoutDetails);
    }
}