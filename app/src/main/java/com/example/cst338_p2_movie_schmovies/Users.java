package com.example.cst338_p2_movie_schmovies;

import androidx.room.Entity;
<<<<<<< Updated upstream
import androidx.room.PrimaryKey;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;

@Entity(tableName = AppDataBase.GYMLOG_TABLE)
=======

>>>>>>> Stashed changes

public class Users {

   @PrimaryKey(autoGenerate = true)
   private int mLogId;
   private String username;
   private String password;

   private Boolean isAdmin;

   //````````````````````````````````````````Constructor``````````````````````````//
   public Users(String username, String password, int idNumber, Boolean isAdmin) {
      this.username = username;
      this.password = password;
      this.isAdmin = isAdmin;
   }

   @Override
   public String toString() {
      return "Users{" +
              "username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", isAdmin=" + isAdmin +
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
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Boolean getAdmin() {
      return isAdmin;
   }

   public void setAdmin(Boolean admin) {
      isAdmin = admin;
   }


}
