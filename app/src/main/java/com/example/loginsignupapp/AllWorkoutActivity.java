package com.example.loginsignupapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllWorkoutActivity extends AppCompatActivity {

    private RecyclerView rvAllWorkouts;
    AdapterWorkout adapter;
    FirebaseServices fbs;
    ArrayList<HomeWorkout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_workout);

        fbs = FirebaseServices.getInstance();
        workouts = new ArrayList<HomeWorkout>();
        readData();

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvWorkoutAllWorkout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterWorkout(this, workouts);
        recyclerView.setAdapter(adapter);
    }

    private void readData() {
        fbs.getFire().collection("workouts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                workouts.add(document.toObject(HomeWorkout.class));
                            }
                        } else {
                            Log.e("AllWorkoutActivity: readData()", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
