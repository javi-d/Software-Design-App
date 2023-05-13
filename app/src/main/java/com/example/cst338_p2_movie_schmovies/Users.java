/*
 * Authors: Cam Clendenon and Javier Dominguez
 * Date: 4 - 23 - 2023
 * This is what we have for out DAO file
 */


package com.example.cst338_p2_movie_schmovies;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity(tableName = AppDataBase.USERS_TABLE)

public class Users {

   @PrimaryKey(autoGenerate = true)
   private int mUserId;
   private String mUsername;
   private String mPassword;

   public Boolean mIsAdmin;

   private HashMap<String, List<String>> mTheaterShowTimes;


   //````````````````````````````````````````Constructor``````````````````````````//
   public Users( String username, String password) {
      mUsername = username;
      mPassword = password;
      mIsAdmin = Boolean.FALSE;
      mTheaterShowTimes = new HashMap<>();

      mTheaterShowTimes.put("Century Marina and XD", new ArrayList<>());
      mTheaterShowTimes.put("Maya Cinemas Salinas", new ArrayList<>());
      mTheaterShowTimes.put("Cinemark Monterey 13", new ArrayList<>());

   }

   @Override
   public String toString() {
      return "Users{" +
              "mLogId=" + mUserId +
              ", mUsername='" + mUsername + '\'' +
              ", mPassword='" + mPassword + '\'' +
              ", mIsAdmin=" + mIsAdmin +
              '}';
   }


   //````````````````````````````````````````Get() and Set()``````````````````````//


   public int getUserId() {
      return mUserId;
   }

   public void setUserId(int userId) {
      mUserId = userId;
   }

   public String getUsername() {
      return mUsername;
   }

   public void setUsername(String username) {
      mUsername = username;
   }

   public String getPassword() {
      return mPassword;
   }

   public void setPassword(String password) {
      mPassword = password;
   }

   public Boolean getAdmin() {
      return mIsAdmin;
   }

   public void setAdmin(Boolean admin) {
      mIsAdmin = admin;
   }

   public HashMap<String, List<String>> getTheaterShowTimes() {
      return mTheaterShowTimes;
   }

   public void setTheaterShowTimes(HashMap<String, List<String>> theaterShowTimes) {
      mTheaterShowTimes = theaterShowTimes;
   }
}
