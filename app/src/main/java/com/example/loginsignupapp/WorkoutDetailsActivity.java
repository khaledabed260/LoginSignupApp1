package com.example.loginsignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutDetailsActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvAddress, tvCategory, tvPhone;
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
        HomeWorkout workout = (HomeWorkout) i.getSerializableExtra("workout");

        tvName.setText(workout.getName());
        tvDescription.setText(workout.getDescription());
        tvAddress.setText(workout.getAddress());
        tvCategory.setText(workout.getCategory().toString());
        tvPhone.setText(workout.getPhone());
        Picasso.get().load(workout.getPhoto()).into(ivPhoto);
    }
    private void connectComponents() {
        tvName = findViewById(R.id.tvNameWorkoutDetails);
        tvDescription = findViewById(R.id.tvDescriptionWorkoutDetails);
        tvAddress = findViewById(R.id.tvAddressWorkoutDetails);
        tvCategory = findViewById(R.id.tvCategoryWorkoutDetails);
        tvPhone = findViewById(R.id.tvPhoneWorkoutDetails);
        ivPhoto = findViewById(R.id.ivPhotoWorkoutDetails);
    }
}