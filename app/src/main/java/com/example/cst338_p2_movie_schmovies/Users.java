package com.example.cst338_p2_movie_schmovies;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

@Entity(tableName = AppDataBase.GYMLOG_TABLE)

public class Users {

   @PrimaryKey(autoGenerate = true)
   private int mLogId;
   private String mUsername;
   private String mPassword;

   private Boolean mIsAdmin;



   //````````````````````````````````````````Constructor``````````````````````````//
   public Users(String username, String password, Boolean isAdmin) {
      mUsername = username;
      mPassword = password;
      mIsAdmin = isAdmin;
   }

   @Override
   public String toString() {
      return "Users{" +
              "mLogId=" + mLogId +
              ", mUsername='" + mUsername + '\'' +
              ", mPassword='" + mPassword + '\'' +
              ", mIsAdmin=" + mIsAdmin +
              '}';
   }

   //````````````````````````````````````````Get() and Set()``````````````````````//


   public int getLogId() {
      return mLogId;
   }

   public void setLogId(int logId) {
      mLogId = logId;
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
}
