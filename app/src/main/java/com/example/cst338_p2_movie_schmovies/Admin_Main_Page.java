package com.example.cst338_p2_movie_schmovies;

import static com.example.cst338_p2_movie_schmovies.MainActivity.User_ID_KEY;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Admin_Main_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);
    }


    public Intent intentFactory(Context context, int adminId) {
        Intent intent = new Intent(this, Admin_Main_Page.class);
        intent.putExtra(User_ID_KEY, adminId);
        return intent;
    }
}