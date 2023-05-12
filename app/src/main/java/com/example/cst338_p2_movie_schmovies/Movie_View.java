package com.example.cst338_p2_movie_schmovies;
import static com.example.cst338_p2_movie_schmovies.MainActivity.User_ID_KEY;
import static com.example.cst338_p2_movie_schmovies.MainActivity.MOVIE_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;

public class Movie_View extends AppCompatActivity {


    private TextView movieTitleField;
    private TextView movieSynopsisField;
    private ImageView movieBannerField;

    private DAO DAO;

    private String movieTitle;
    private String movieSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);
        getDatabase();
        wireUpDisplay();
    }

    private void wireUpDisplay() {

        movieTitleField = findViewById(R.id.movieTitleHeader);
        movieSynopsisField = findViewById(R.id.movieSynopsis);
        movieBannerField = findViewById(R.id.movieBannerImage);

        Intent mIntent = getIntent();
        int movieId = mIntent.getIntExtra(MOVIE_KEY,-1);
        Movie movie = DAO.getMovieById(movieId);;

        movieTitleField.setText(movie.getMovieName());
        movieSynopsisField.setText(movie.getSynopsis());
        movieBannerField.setImageResource(movie.getImage());

    }

    private void getDatabase() {
        DAO= Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();

    }

    public Intent intentFactory(Context context, int userId, int movieId) {
        Intent intent = new Intent(this, Movie_View.class);
        intent.putExtra(User_ID_KEY, userId);
        intent.putExtra(MOVIE_KEY, movieId);
        return intent;
    }

}