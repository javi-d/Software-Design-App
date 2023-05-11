/*
 * Authors: Cam Clendenon and Javier Dominguez
 * Date: 4 - 23 - 2023
 * This is what we have for out DAO file
 */

package com.example.cst338_p2_movie_schmovies.DB;
import com.example.cst338_p2_movie_schmovies.Movie;
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
    List<Users> getAllUsers();
    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE + " WHERE mUserId = :userId")
    Users getUserById(int userId);
    @Query("SELECT * FROM " + AppDataBase.USERS_TABLE + " WHERE mUsername = :username")
    Users getUserByUsername(String username);

    @Insert
    void insert(Movie... movies);

    @Update
    void update(Movie... movies);

    @Delete
    void delete(Movie movie);

    @Query("SELECT * FROM " + AppDataBase.MOVIE_TABLE )
    List<Movie> getAllMovies();
    @Query("SELECT * FROM " + AppDataBase.MOVIE_TABLE )
    Movie getMovieByName();
    @Query("SELECT * FROM " + AppDataBase.MOVIE_TABLE + " WHERE mMovieLogId = :logId") // Not Sure why it is mad at mMovieLogId but it is.
    Movie getMovieById(int logId);

    @Insert
    void insert(Theater... theaters);

    @Update
    void update(Theater... theaters);

    @Delete
    void delete(Theater theater);

    @Query("SELECT * FROM " + AppDataBase.THEATER_TABLE )
    List<Theater> getAllTheaters();
    @Query("SELECT * FROM " + AppDataBase.THEATER_TABLE )
    Theater getTheaterByName();
    @Query("SELECT * FROM " + AppDataBase.THEATER_TABLE + " WHERE mTheaterId = :theaterId") // Not Sure why it is mad at mMovieLogId but it is.
    Theater getTheaterById(int theaterId);
}
