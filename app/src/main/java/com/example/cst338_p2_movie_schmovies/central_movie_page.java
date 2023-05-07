package com.example.cst338_p2_movie_schmovies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.cst338_p2_movie_schmovies.DB.DAO;

import java.util.List;

public class central_movie_page extends AppCompatActivity {
    private static final String User_ID_KEY = "com.example.cst338_p2_movie_schmovies.userIdKey";
    private static final String PREFERENCE_KEY = "com.example.cst338_p2_movie_schmovies.com.PREFERENCE_KEY";





    private DAO DAO;
    private int UserId  = -1;
    private SharedPreferences Preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_movie_page);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.users_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch( item.getItemId()){
            case R.id.user1:
                logoutUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logoutUser() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage(R.string.logout);

        alertBuilder.setPositiveButton(getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        clearUserFromIntent();
                        clearUserFromPref();
                        UserId = -1;
                        checkForuser();
                    }
                });

        alertBuilder.setNegativeButton(getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Don't need to do anything here
                    }
                });

        alertBuilder.create().show();

    }

    private void checkForuser() {

        UserId = getIntent().getIntExtra(User_ID_KEY, -1);

        if(UserId != -1){
            return;
        }

        if(Preferences == null){
            getPrefs();
        }

        UserId = Preferences.getInt(User_ID_KEY, -1);

        if(UserId != -1){
            return;
        }

//        List<Users> user = DAO.getAllUsers();
//        if(user.size()<= 0){
//            Users defeUser = new Users("") ;
//            Users altUser = new Users("");
//            DAO.insert(defeUser,altUser);
//        }
//
//        Intent intent = ;
//        startActivity(intent);

    }

    private void clearUserFromPref() {
        addUserToPreference(-1);
    }

    private void addUserToPreference(int i) {
        if(Preferences == null){
            getPrefs();
        }
        SharedPreferences.Editor editor = Preferences.edit();
        editor.putInt(User_ID_KEY, i);
    }

    private void getPrefs() {
        Preferences = this.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    private void clearUserFromIntent() {
        getIntent().putExtra(User_ID_KEY, -1);
    }

}