package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        signUpWiredUpDisplay();

    }

    private void signUpWiredUpDisplay() {
        signUpUsernameField = signUpBinding.SignUpUserNameTextInput;
        signUpPasswordField = signUpBinding.PasswordTextInput;
        secondSignUpPasswordField = signUpBinding.PasswordTextInputSecond;
        signUpSubmitButton = signUpBinding.SignUpSubmitButton;

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
//                        Intent intent = moviepage....;
//                        startActivity(intent);
                    }

                }

            }
        });
    }

    private boolean uniqueUsername() {
        mUsers = signUpDAO.getUserByUsername(signUpUsername);
        if (mUsers == null) {
            return true;
        }
        return false;
    }

    private void getSignUpValuesByDisplay() {
        signUpUsername = signUpUsernameField.getText().toString();
        signUpPassword = signUpPasswordField.getText().toString();
        signSecondPassword = secondSignUpPasswordField.getText().toString();


    }

    private boolean checkSignUpPassword() {
        return signUpPassword.equals(signSecondPassword);

    }


}