package com.example.cst338_p2_movie_schmovies.DB;
import com.example.cst338_p2_movie_schmovies.Users;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;


@Dao
public interface DAO {
    @Insert
    void insert(Users... user);

    @Update
    void update(Users... user);

    @Delete
    void delete(Users user);

}
