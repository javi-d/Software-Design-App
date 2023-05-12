package com.example.cst338_p2_movie_schmovies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView movieBanner;
    TextView movieTitle;
    TextView synopsis;


    public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);
        movieBanner = itemView.findViewById(R.id.movieBanner);
        movieTitle = itemView.findViewById(R.id.movieTitle);
        synopsis = itemView.findViewById(R.id.synopsis);


    }
}
