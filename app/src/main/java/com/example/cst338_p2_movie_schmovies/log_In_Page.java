package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.cst338_p2_movie_schmovies.databinding.ActivityLogInPageBinding;

public class log_In_Page extends AppCompatActivity {


    ActivityLogInPageBinding Cbinding;
    TextView childTextView;
    EditText username;
    EditText password;
    Button childButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        Cbinding = ActivityLogInPageBinding.inflate(getLayoutInflater());
        setContentView(Cbinding.getRoot());

        childTextView = Cbinding.LogInHeader;
        username = Cbinding.UserNameTextInput;
        password = Cbinding.PasswordTextInput;
        childButton = Cbinding.LoginSubmitButton;

        childTextView.setMovementMethod(new ScrollingMovementMethod());



    }
}