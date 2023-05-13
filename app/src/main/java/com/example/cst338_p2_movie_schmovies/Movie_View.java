package com.example.cst338_p2_movie_schmovies;
import static com.example.cst338_p2_movie_schmovies.MainActivity.User_ID_KEY;
import static com.example.cst338_p2_movie_schmovies.MainActivity.MOVIE_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;

import java.util.ArrayList;
import java.util.List;

public class Movie_View extends AppCompatActivity {

//    RecyclerView recycler_view;
//    DayAdapter adapter;


    private TextView movieTitleField;
    private TextView movieSynopsisField;


    private TextView movieLocation;

    private TextView movieDate1;
    private TextView movieDate2;
    private TextView movieDate3;

    private TextView movieTime1;
    private TextView movieTime2;
    private TextView movieTime3;

    private ImageView movieBannerField;

    private DAO DAO;

    private String movieTitle;
    private String movieSynopsis;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_view);
//        recycler_view = findViewById(R.id.recycler_view);
//        setRecyclerView();
        getDatabase();
        wireUpDisplay();
    }

//    private void setRecyclerView() {
//        recycler_view.setHasFixedSize(true);
//        recycler_view.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new DayAdapter(this,getList());
//        recycler_view.setAdapter(adapter);
//    }
//
//    private List<DateModel> getList() {
//        List<DateModel> dateModelList = new ArrayList<>();
//        dateModelList.add(new DateModel("10:00PM", "7:00PM", "7:00PM", "7:00PM","7:00PM","7:00PM" ));
//
//        dateModelList.add(new DateModel("10:00PM", "7:00PM", "11:00PM", "4:00PM","3:00PM","2:00PM" ));
//        dateModelList.add(new DateModel("5:00PM", "8:00PM", "12:00PM", "7:00PM","10:00PM","12:00PM" ));
//        dateModelList.add(new DateModel("1:00PM", "9:00PM", "9:00PM", "2:00PM","8:00PM","4:00PM" ));
//        dateModelList.add(new DateModel("2:00PM", "10:00PM", "1:00PM", "5:00PM","3:00PM","7:00PM" ));
//
//        return dateModelList;
//    }
    private void wireUpDisplay() {

        movieTitleField = findViewById(R.id.movieTitleHeader);
        movieSynopsisField = findViewById(R.id.movieSynopsis);
        movieBannerField = findViewById(R.id.movieBannerImage);
        movieLocation = findViewById(R.id.movieLocation);
        movieDate1 = findViewById(R.id.movieDate1);
        movieDate2 = findViewById(R.id.movieDate2);
        movieDate3 = findViewById(R.id.movieDate3);

         movieTime1 = findViewById(R.id.movieTime1);
         movieTime2 = findViewById(R.id.movieTime2);
         movieTime3 = findViewById(R.id.movieTime3);


        Intent mIntent = getIntent();
        int movieId = mIntent.getIntExtra(MOVIE_KEY,-1);
        Movie movie = DAO.getMovieById(movieId);;

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