package com.example.cst338_p2_movie_schmovies;

import static com.example.cst338_p2_movie_schmovies.MainActivity.MOVIE_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AddMovieTheatersAndTimes extends AppCompatActivity {
    private DAO DAO;
    private int movieId;
    private Movie mMovie;
    private HashMap<String, List<String>> movieTimes;

    private EditText theaterAndTimes;
    private Button submitTimes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie_theaters_and_times);

        getDatabase();

        wiredUpDisplay();

        Intent wontBeUsed = getIntent();
        movieId = wontBeUsed.getIntExtra(MOVIE_KEY, -1);
        mMovie = DAO.getMovieById(movieId);

        submitTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String timeInputted = theaterAndTimes.getText().toString();
                String[] theaterThenTime = timeInputted.split(",");

                for (String theaterTime : theaterThenTime){
                    String[] seperated = theaterTime.split(";");
                    if (seperated.length != 2){
                        Toast.makeText(AddMovieTheatersAndTimes.this, "Inputted theater and times incorrectly!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Theater testTheater = DAO.getTheaterByName(seperated[0]);
                    if (testTheater != null) {
                        movieTimes = mMovie.getTheaterShowTimes();
                        String preTimes = seperated[1];
                        String[] times = preTimes.split(" ");
                        List<String> values = movieTimes.get(seperated[0]);
                        values.addAll(Arrays.asList(times));

                        movieTimes.put(seperated[0], values);
                    }else {
                        Toast.makeText(AddMovieTheatersAndTimes.this, "Movie Theater Not Recognised", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(AddMovieTheatersAndTimes.this, "Successfully added times.", Toast.LENGTH_SHORT).show();
                Intent intent = Admin_Main_Page.intentFactory(getApplicationContext(), -1); //TODO:Save admin login through adding activities to be able to pass back when returning.
                startActivity(intent);

            }
        });
    }

    private void wiredUpDisplay() {
        theaterAndTimes = findViewById(R.id.timesInput);
        submitTimes = findViewById(R.id.submitTimesButton);

    }

    private void getDatabase() {
        DAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();

    }

    public static Intent intentFactory(Context context, int movieId) {
        Intent intent = new Intent(context, AddMovieTheatersAndTimes.class);
        intent.putExtra(MOVIE_KEY, movieId);
        return intent;
    }
}