package com.example.cst338_p2_movie_schmovies.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.cst338_p2_movie_schmovies.Users;

@Database(entities = {Users.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "Users.db";
    public static final String USERS_TABLE = "users_table";

    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public abstract DAO GymLogDAO();

    public static AppDataBase getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }

}
