package com.example.loginsignupapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllWorkoutActivity extends AppCompatActivity {

    private RecyclerView rvAllWorkout;
    AdapterWorkout adapter;
    FirebaseServices fbs;
    ArrayList<HomeWorkout> workouts;
    MyCallback myCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_workout);

        fbs = FirebaseServices.getInstance();
        workouts = new ArrayList<HomeWorkout>();
        readData();
        myCallback = new MyCallback() {
            @Override
            public void onCallback(List<HomeWorkout> restsList) {
                RecyclerView recyclerView = findViewById(R.id.rvWorkoutAllWorkout);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterWorkout(getApplicationContext(), workouts);
                recyclerView.setAdapter(adapter);
            }
        };


        // set up the RecyclerView
        /*
        RecyclerView recyclerView = findViewById(R.id.rvRestsAllRest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterRestaurant(this, rests);
        recyclerView.setAdapter(adapter);*/
    }

    private void readData() {
        try {

            fbs.getFire().collection("workouts")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    workouts.add(document.toObject(HomeWorkout.class));
                                }

                                myCallback.onCallback(workouts);
                            } else {
                                Log.e("AllWorkoutActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error reading!" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

