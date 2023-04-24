package com.example.cst338_p2_movie_schmovies.DB;
import com.example.cst338_p2_movie_schmovies.Users;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface DAO {
    @Insert
    void insert(Users... user);

    @Update
    void update(Users... user);

    @Delete
    void delete(Users user);

    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE )
    List<Users> getUserByUsername();
    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE + " WHERE mLogId = :logId")
    List<Users> geUserById(int logId);

}
