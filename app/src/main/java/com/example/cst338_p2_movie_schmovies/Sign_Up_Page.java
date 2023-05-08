package com.example.cst338_p2_movie_schmovies;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;
import com.example.cst338_p2_movie_schmovies.databinding.ActivitySignUpPageBinding;

public class Sign_Up_Page extends AppCompatActivity {
    ActivitySignUpPageBinding signUpBinding;
    private TextView signUpTextView;
    private EditText signUpUsernameField;
    private EditText signUpPasswordField;
    private EditText secondSignUpPasswordField;
    private Button signUpSubmitButton;

    private String signUpUsername;
    private String signUpPassword;
    private String signSecondPassword;

    private Users mUsers;

    private DAO signUpDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        signUpDatabase();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        signUpWiredUpDisplay();

    }


    private void signUpWiredUpDisplay() {
        signUpUsernameField = findViewById(R.id.SignUpUserNameTextInput);
        signUpPasswordField = findViewById(R.id.PasswordTextInput);
        secondSignUpPasswordField = findViewById(R.id.PasswordTextInputSecond);
        signUpSubmitButton = findViewById(R.id.SignUpSubmitButton);

        signUpSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSignUpValuesByDisplay();
                if(!uniqueUsername() ){ //This needs to check if username already exists but not sure how yet. -Cam
                    Toast.makeText(Sign_Up_Page.this, "Username already exists, please enter a different username", Toast.LENGTH_SHORT).show();
                }else{
                    if (!checkSignUpPassword()){
                        Toast.makeText(Sign_Up_Page.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    } else{
                        Users newUser = new Users(signUpUsername, signUpPassword);
                        signUpDAO.insert(newUser);
                        Intent intent = central_movie_page.intentFactory(getApplicationContext());
                        startActivity(intent);

                    }

                }

            }
        });
    }

    private boolean uniqueUsername() {
//        mUsers = null;
        mUsers = signUpDAO.getUserByUsername(signUpUsername);
        return mUsers == null;
    }

    private void getSignUpValuesByDisplay() {
        signUpUsername = signUpUsernameField.getText().toString();
        signUpPassword = signUpPasswordField.getText().toString();
        signSecondPassword = secondSignUpPasswordField.getText().toString();


    }

    private boolean checkSignUpPassword() {
        return signUpPassword.equals(signSecondPassword);

    }
    private void getDatabase(){
        signUpDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .GymLogDAO(); //TODO: Remember to change the name to something else. -Cam
    }
    public static  Intent intentFactory(Context context) {
        Intent intent = new Intent(context, Sign_Up_Page.class);
        return intent;
    }

    private void signUpDatabase() {
        signUpDAO= Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .build()
                .GymLogDAO();

    }

}