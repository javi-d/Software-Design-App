package com.example.cst338_p2_movie_schmovies;
import static com.example.cst338_p2_movie_schmovies.MainActivity.User_ID_KEY;
import static com.example.cst338_p2_movie_schmovies.MainActivity.MOVIE_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class gMovie_View extends AppCompatActivity {


    private TextView movieTitleField;
    private TextView movieSynopsisField;
    private ImageView movieBannerField;

    private String movieTitle;
    private String movieSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);

        wireUpDisplay();
    }

    private void wireUpDisplay() {


    }
    public Intent intentFactory(Context context, int userId, int movieId) {
        Intent intent = new Intent(this, Movie_View.class);
        intent.putExtra(User_ID_KEY, userId);
        intent.putExtra(MOVIE_KEY, movieId);
        return intent;
    }
}