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

    private String mLocation;

    private String mTime1;
    private String mTime2;
    private String mTime3;

    private String mDate1;
    private String mDate2;
    private String mDate3;


    //````````````````````````````````````````````Constructor and toString()`````````````````````````````````````````//

    public Movie(String movieName, String synopsis, String ageRating, int image, String location , String date1, String date2, String date3, String time1, String time2, String time3) {
        mMovieName = movieName;
        mSynopsis = synopsis;
        mAgeRating = ageRating;
        mImage = image;
        mLocation = location;
        mDate1 = date1;
        mDate2 = date2;
        mDate3 = date3;
        mTime1 = time1;
        mTime2 = time2;
        mTime3 = time3;
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


    public String getTime1() {
        return mTime1;
    }

    public void setTime1(String time1) {
        mTime1 = time1;
    }

    public String getTime2() {
        return mTime2;
    }

    public void setTime2(String time2) {
        mTime2 = time2;
    }

    public String getTime3() {
        return mTime3;
    }

    public void setTime3(String time3) {
        mTime3 = time3;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDate1() {
        return mDate1;
    }

    public void setDate1(String date1) {
        mDate1 = date1;
    }

    public String getDate2() {
        return mDate2;
    }

    public void setDate2(String date2) {
        mDate2 = date2;
    }

    public String getDate3() {
        return mDate3;
    }

    public void setDate3(String date3) {
        mDate3 = date3;
    }

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
