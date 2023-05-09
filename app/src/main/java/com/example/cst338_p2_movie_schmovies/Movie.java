package com.example.cst338_p2_movie_schmovies;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

import java.util.HashMap;
import java.util.List;

@Entity(tableName = AppDataBase.MOVIE_TABLE)
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int mMovieLogId;
    private String mMovieName;
    private String mSynopsis;

    private String mAgeRating;

//    private HashMap<String, List<String>> theaterShowTimes; // String for Theater location/name and String List for movie Times at that Theater.

    //````````````````````````````````````````````Constructor and toString()`````````````````````````````````````````//

    public Movie(String movieName, String synopsis, String ageRating) {
        mMovieName = movieName;
        mSynopsis = synopsis;
        mAgeRating = ageRating;
//        theaterShowTimes = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mLogId=" + mMovieLogId +
                ", mMovieName='" + mMovieName + '\'' +
                ", mSynopsis='" + mSynopsis + '\'' +
                ", mAgeRating='" + mAgeRating + '\'' +
//                ", theaterShowTimes=" + theaterShowTimes +
                '}';
    }
//````````````````````````````````````````````Getter and Setters````````````````````````````````````//


    public int getLogId() {
        return mMovieLogId;
    }

    public void setLogId(int logId) {
        mMovieLogId = logId;
    }

    public String getMovieName() {
        return mMovieName;
    }

    public void setMovieName(String movieName) {
        mMovieName = movieName;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public void setSynopsis(String synopsis) {
        mSynopsis = synopsis;
    }

    public String getAgeRating() {
        return mAgeRating;
    }

    public void setAgeRating(String ageRating) {
        mAgeRating = ageRating;
    }

////    public HashMap<String, List<String>> getTheaterShowTimes() {
//        return theaterShowTimes;
//    }

//    public void setTheaterShowTimes(HashMap<String, List<String>> theaterShowTimes) {
//        this.theaterShowTimes = theaterShowTimes;
//    }

    public int getMovieLogId() {
        return mMovieLogId;
    }

    public void setMovieLogId(int movieLogId) {
        mMovieLogId = movieLogId;
    }
}
