package com.example.cst338_p2_movie_schmovies;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

@Entity(tableName = AppDataBase.THEATER_TABLE)
public class Theater {
    @PrimaryKey(autoGenerate = true)
    private int mTheaterId;
    private String mTheaterName;
    private String mLocation;

    public Theater(String theaterName, String location) {
        mTheaterName = theaterName;
        mLocation = location;
    }

    public int getTheaterId() {
        return mTheaterId;
    }

    public void setTheaterId(int theaterId) {
        mTheaterId = theaterId;
    }

    public String getTheaterName() {
        return mTheaterName;
    }

    public void setTheaterName(String theaterName) {
        mTheaterName = theaterName;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }


}
