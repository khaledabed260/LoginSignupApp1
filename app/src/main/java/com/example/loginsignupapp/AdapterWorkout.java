package com.example.loginsignupapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdapterWorkout extends RecyclerView.Adapter<AdapterWorkout.ViewHolder> {

    private List<HomeWorkout> mData;
    private LayoutInflater mInflater;
    private Context context;


    private final AdapterWorkout.ItemClickListener mClickListener = new ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            // get restaurant data
            HomeWorkout workout = mData.get(position);
            // upload restaurant data
            // goto details activity
            Intent i = new Intent(context, WorkoutDetailsActivity.class);
            i.putExtra("workout", (Serializable)workout);
            context.startActivity(i);
        }
    };

    // data is passed into the constructor
    AdapterWorkout(Context context, List<HomeWorkout> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public AdapterWorkout.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_workout, parent, false);
        return new AdapterWorkout.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(AdapterWorkout.ViewHolder holder, int position) {
        HomeWorkout workout = mData.get(position);
        holder.tvName.setText(workout.getName());
        //holder.ivPhoto.setImageDrawable(rest.getPhoto());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        ImageView ivPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameWorkoutRow);
            ivPhoto = itemView.findViewById(R.id.ivPhotoWorkoutRow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
  HomeWorkout getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    /*
    void setClickListener(AdapterRestaurant.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }*/

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


