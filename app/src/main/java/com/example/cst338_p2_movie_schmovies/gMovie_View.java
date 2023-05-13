package com.example.cst338_p2_movie_schmovies;
import static com.example.cst338_p2_movie_schmovies.MainActivity.MOVIE_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;


public class gMovie_View extends AppCompatActivity {


    private TextView movieTitleField;
    private TextView movieSynopsisField;
    private ImageView movieBannerField;

    private TextView movieLocation;

    private TextView movieDate1;
    private TextView movieDate2;
    private TextView movieDate3;

    private TextView movieTime1;
    private TextView movieTime2;
    private TextView movieTime3;

    private DAO DAO;

    private String movieTitle;
    private String movieSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmovie_view);
        getDatabase();
        wireUpDisplay();
    }

    private void wireUpDisplay() {
        movieTitleField = findViewById(R.id.GuestMovieTitleHeader);
        movieSynopsisField = findViewById(R.id.GuestMovieSynopsis);
        movieBannerField = findViewById(R.id.GuestMovieBannerImage);
        movieLocation = findViewById(R.id.GuestmovieLocation);
        movieDate1 = findViewById(R.id.GuestmovieDate1);
        movieDate2 = findViewById(R.id.GuestmovieDate2);
        movieDate3 = findViewById(R.id.GuestmovieDate3);

        movieTime1 = findViewById(R.id.GuestmovieTime1);
        movieTime2 = findViewById(R.id.GuestmovieTime2);
        movieTime3 = findViewById(R.id.GuestmovieTime3);
//        movieTitleField.setText(R.string.titleHolder);
//        movieSynopsisField.setText(R.string.textHolder);

        Intent mIntent = getIntent();
        int movieId = mIntent.getIntExtra(MOVIE_KEY,-1);
        Movie movie = DAO.getMovieById(movieId);

        movieTitleField.setText(movie.getMovieName());
        movieSynopsisField.setText(movie.getSynopsis());
        movieBannerField.setImageResource(movie.getImage());
        movieLocation.setText(movie.getLocation());
        movieDate1.setText(movie.getDate1());
        movieDate2.setText(movie.getDate2());
        movieDate3.setText(movie.getDate3());
        movieTime1.setText(movie.getTime1());
        movieTime2.setText(movie.getTime2());
        movieTime3.setText(movie.getTime3());





//        movieTitle = findViewById(R.id.);
//        movieSynopsis = findViewById(R.id.)



    }

    private void getDatabase() {
        DAO= Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();

    }

    public Intent intentFactory(Context context, int movieId) {
        Intent intent = new Intent(this, gMovie_View.class);
//        intent.putExtra(User_ID_KEY, userId);
        intent.putExtra(MOVIE_KEY, movieId);
        return intent;
    }
}