package com.example.cst338_p2_movie_schmovies;

public class Users {
   private String username;
   private String password;
   private int idNumber;
   private Boolean isAdmin;

   //````````````````````````````````````````Constructor``````````````````````````//
   public Users(String username, String password, int idNumber, Boolean isAdmin) {
      this.username = username;
      this.password = password;
      this.idNumber = idNumber;
      this.isAdmin = isAdmin;
   }

   @Override
   public String toString() {
      return "Users{" +
              "username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", idNumber=" + idNumber +
              ", isAdmin=" + isAdmin +
              '}';
   }

   //````````````````````````````````````````Get() and Set()``````````````````````//
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

   public int getIdNumber() {
      return idNumber;
   }

   public void setIdNumber(int idNumber) {
      this.idNumber = idNumber;
   }

   public Boolean getAdmin() {
      return isAdmin;
   }

   public void setAdmin(Boolean admin) {
      isAdmin = admin;
   }


}
