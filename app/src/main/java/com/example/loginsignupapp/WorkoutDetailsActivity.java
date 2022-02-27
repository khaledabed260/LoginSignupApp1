package com.example.loginsignupapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class WorkoutDetailsActivity extends AppCompatActivity {

    private TextView tvName, tvSets, tvDifficulty, tvCategory;
    private ImageView ivPhoto;

    /*
        private String address;
    private RestCat category;
    private String photo;
    private String phone;
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        connectComponents();
        Intent i = this.getIntent();
        HomeWorkout workout = (HomeWorkout) i.getSerializableExtra("rest");

        tvName.setText(workout.getName());
        tvDifficulty.setText(workout.getDifficulty());
        tvSets.setText(workout.getSets());
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