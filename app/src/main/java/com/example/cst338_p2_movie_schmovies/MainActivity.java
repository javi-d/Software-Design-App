package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.cst338_p2_movie_schmovies.DB.DAO;
import com.example.cst338_p2_movie_schmovies.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mBinding;

    TextView mTitle;

    Button mLogin;
    Button mSignup;
    Button mContinueAsGuest;

    DAO mDAO;

    List<Users> mUsersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}