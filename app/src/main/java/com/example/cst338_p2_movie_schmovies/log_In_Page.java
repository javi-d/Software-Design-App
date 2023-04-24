package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
    }



}