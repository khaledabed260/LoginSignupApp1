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
        private String address;
    private RestCat category;
    private String photo;
    private String phone;
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        ImageView leftIcon = findViewById(R.id.left_icon);
        ImageView rightIcon = findViewById(R.id.right_icon);

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WorkoutDetailsActivity.this,"You Clicked On Left Icon" ,Toast.LENGTH_SHORT).show();
            }
        });
        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WorkoutDetailsActivity.this,"You Clicked On Right Icon" ,Toast.LENGTH_SHORT).show();
            }
        });

        connectComponents();
        Intent i = this.getIntent();
        HomeWorkout workout = (HomeWorkout) i.getSerializableExtra("workout");

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