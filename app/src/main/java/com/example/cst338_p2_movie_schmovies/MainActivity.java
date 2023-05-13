package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Intent;
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

    protected static final String User_ID_KEY = "com.example.cst338_p2_movie_schmovies.userIdKey";
    protected static final String PREFERENCE_KEY = "com.example.cst338_p2_movie_schmovies.PREFERENCE_KEY";
    protected static final String MOVIE_KEY = "com.example.cst338_p2_movie_schmovies.MOVIE_KEY";

    ActivityMainBinding mBinding;

    private TextView mTitle;

    private Button mLogin;
    private Button mSignup;
    private Button mContinueAsGuest;

    private DAO mDAO;

    private List<Users> mUsersList;

    private int UserId = -1;

    private SharedPreferences Preferences = null;

    private Users User;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getDatabase();
//        checkForUser();
//        addy(UserId);
//        loginUser(UserId);


        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mTitle = mBinding.WelcomeHeader;
        mLogin = mBinding.LogInButton;
        mSignup = mBinding.SignUpButton;
        mContinueAsGuest = mBinding.GuestButton;


        mTitle.setMovementMethod(new ScrollingMovementMethod());

        mDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();

//        refreshDisplay();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDatabase();
                checkForUser();
                addy(UserId);
                loginUser(UserId);
            }
        });

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sign_Up_Page.class);
                startActivity(intent);
            }
        });

        mContinueAsGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Guest_Central_Page.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

    }

    private void addy(int userId) {
        if(Preferences == null){
            getPrefs();
        }
        SharedPreferences.Editor editor = Preferences.edit();
        editor.putInt(User_ID_KEY, userId);
    }

    private void loginUser(int userId) {
        User = mDAO.getUserById(userId);
        invalidateOptionsMenu();
    }

    private void getDatabase() {
        mDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();
    }

    private void checkForUser() {
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

        List<Users> users = mDAO.getAllUsers();
        if(users.size() <= 0){
            Users defaultUser = new Users("kiddo", "kid123");
            Users altUser = new Users("tester", "kid123");
            Users imposter = new Users("sussy", "baka"); // Shhhhhhhhhhh, you saw nothing.

            Users admin1 = new Users("Cam", "657admin");
            Users admin2 = new Users("Javi", "idklmao");
            admin1.setAdmin(true);
            admin2.setAdmin(true);

            mDAO.insert(defaultUser,altUser, admin1, admin2, imposter);
        }

        Intent intent = log_In_Page.intentFactory(this);
        startActivity(intent);
    }

    private void getPrefs() {
        Preferences = this.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }


    public static Intent intentFactory(Context applicationContext) {
        Intent intent = new Intent(applicationContext, MainActivity.class);
//        intent.putExtra(User_ID_KEY);
        return intent;
    }

//    private void refreshDisplay(){
//        mUsersList = mDAO.getAllUsers();
//        if(! mUsersList.isEmpty()){
//            StringBuilder sb = new StringBuilder();
//            for(Users log : mUsersList){
//                sb.append(log.toString());
//            }
//            mTitle.setText(sb.toString());
//        }else{
//            mTitle.setText(R.string.title);
//        }
    }

