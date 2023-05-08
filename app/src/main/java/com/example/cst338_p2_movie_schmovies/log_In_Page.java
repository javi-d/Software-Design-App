package com.example.cst338_p2_movie_schmovies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;
import com.example.cst338_p2_movie_schmovies.databinding.ActivityLogInPageBinding;

import java.util.List;


public class log_In_Page extends AppCompatActivity {

    private ActivityLogInPageBinding Cbinding;
    private TextView childMainDisplay;
    private EditText usernameField;
    private EditText passwordField;
    private Button childButton;

    private String lUsername;
    private String lPassword;

    private DAO DAO;

    private Users loginUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Cbinding = ActivityLogInPageBinding.inflate(getLayoutInflater());
        setContentView(Cbinding.getRoot());

        wireupDisplay();

        getLoginDatabase();

        childMainDisplay.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(log_In_Page.this, Admin_login.class);
                startActivity(intent);
                return true;
            }
        });
    }

    private void getLoginDatabase() {
        DAO= Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .GymLogDAO();

    }

    private void wireupDisplay() {

        childMainDisplay = Cbinding.LogInHeader;
        usernameField = Cbinding.UserNameTextInput;
        passwordField = Cbinding.PasswordTextInput ;
        childButton = Cbinding.LoginSubmitButton ;

        childMainDisplay.setMovementMethod(new ScrollingMovementMethod());

        childButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLoginValuesFromDisplay();
                if(checkForUserInDatabase()){
                    if(!approvePasword()){
                        Toast.makeText(log_In_Page.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = central_movie_page.intentFactory(getApplicationContext());
                        startActivity(intent);
                    }
                }

            }
        });

    }

    private void getLoginValuesFromDisplay() {
        lUsername = usernameField.getText().toString();
        lPassword = passwordField.getText().toString();
    }


    private boolean checkForUserInDatabase() {
        loginUser = DAO.getUserByUsername(lUsername);
        if(loginUser == null){
            Toast.makeText(this, "no user " + lUsername + " found", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean approvePasword() {
        return loginUser.getPassword().equals(lPassword);
    }


    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, log_In_Page.class);
        return intent;

    }



}