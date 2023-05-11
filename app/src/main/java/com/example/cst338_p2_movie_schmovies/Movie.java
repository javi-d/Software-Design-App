package com.example.cst338_p2_movie_schmovies;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

@Entity(tableName = AppDataBase.MOVIE_TABLE)
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int mMovieLogId;
    private String mMovieName;
    private String mSynopsis;

    private String mAgeRating;

    private String mImageLink;


    private int mImage;


    //````````````````````````````````````````````Constructor and toString()`````````````````````````````````````````//

    public Movie(String movieName, String synopsis, String ageRating, int image) {
        mMovieName = movieName;
        mSynopsis = synopsis;
        mAgeRating = ageRating;
        mImage = image;
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


    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        this.mImage = image;
    }

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


    public int getMovieLogId() {
        return mMovieLogId;
    }

    public void setMovieLogId(int movieLogId) {
        mMovieLogId = movieLogId;
    }

    public String getImageLink() {
        return mImageLink;
    }

    public void setImageLink(String imageLink) {
        mImageLink = imageLink;
    }
}
