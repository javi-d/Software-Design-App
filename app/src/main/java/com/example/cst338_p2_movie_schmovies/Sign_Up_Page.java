package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cst338_p2_movie_schmovies.databinding.ActivityLogInPageBinding;

public class Sign_Up_Page extends AppCompatActivity {
    ActivityLogInPageBinding signUpBinding;
    TextView signUpTextView;
    EditText signUpUsername;
    EditText signUpPassword;
    Button signUpSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }
}