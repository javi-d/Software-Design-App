package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
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


        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mTitle = mBinding.WelcomeHeader;
        mLogin = mBinding.LogInButton;
        mSignup = mBinding.SignUpButton;
        mContinueAsGuest = mBinding.GuestButton;


        mTitle.setMovementMethod(new ScrollingMovementMethod());

        mDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .GymLogDAO();

        refreshDisplay();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshDisplay();
            }
        });

    }



    private void refreshDisplay(){
        mUsersList = mDAO.getUserByUsername();
        if(! mUsersList.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Users log : mUsersList){
                sb.append(log.toString());
            }
            mTitle.setText(sb.toString());
        }else{
            mTitle.setText(R.string.log_in);
        }
    }



}