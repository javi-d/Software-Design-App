package com.example.cst338_p2_movie_schmovies;

import static com.example.cst338_p2_movie_schmovies.MainActivity.PREFERENCE_KEY;
import static com.example.cst338_p2_movie_schmovies.MainActivity.User_ID_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;

public class AdminAddMovie extends AppCompatActivity {

    private EditText imageURLField;
    private EditText titleInput;
    private EditText ageRatingInput;
    private EditText synopsisInput;
    private Button toTimeInputButton;

    private String imageURL;
    private String mTitle;
    private String mAgeRating;
    private String mSynopsis;


    private SharedPreferences Preferences;
    private int adminId;
    private DAO DAO;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_movie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDatabase();

        Intent notGoingToBeUsed = getIntent();
        adminId = notGoingToBeUsed.getIntExtra(User_ID_KEY, -1);
        wiredUpDisplay();
    }

    private void wiredUpDisplay() {
        imageURLField = findViewById(R.id.imageURLInput);
        titleInput = findViewById(R.id.TitleInput);
        ageRatingInput = findViewById(R.id.AgeRatingInput);
        synopsisInput = findViewById(R.id.SynopsisInput);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.users_menu, menu);
//        onPrepareOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch( item.getItemId()){
            case R.id.user1:
                logoutUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logoutUser() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage(R.string.logout);

        alertBuilder.setPositiveButton(getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        clearUserFromIntent();
                        clearUserFromPref();
                        adminId = -1;
                        checkForuser();

                    }
                });

        alertBuilder.setNegativeButton(getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Don't need to do anything here
                    }
                });

        alertBuilder.create().show();

    }

    private void checkForuser() {

        Intent unusedIntent = getIntent();
        adminId   =  unusedIntent.getIntExtra(User_ID_KEY, -1);

        if(adminId != -1){
            return;
        }


        if(Preferences == null){
            getPrefs();
        }

        adminId = Preferences.getInt(User_ID_KEY, -1);

        if(adminId != -1){
            return;
        }

        Intent intent = MainActivity.intentFactory(getApplicationContext());
        startActivity(intent);

    }

    private void clearUserFromPref() {
        addUserToPreference(-1);
    }

    private void addUserToPreference(int i) {
        if(Preferences == null){
            getPrefs();
        }
        SharedPreferences.Editor editor = Preferences.edit();
        editor.putInt(User_ID_KEY, i);
    }

    private void getPrefs() {
        Preferences = this.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    private void clearUserFromIntent() {
        getIntent().putExtra(User_ID_KEY, -1);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        Users mUser = DAO.getUserById(adminId);
        if (mUser != null) {
            MenuItem item = menu.findItem(R.id.user1);
            item.setTitle(mUser.getUsername());

        } else {
            MenuItem item = menu.findItem(R.id.user1);
            item.setTitle("...");
        }

        return super.onPrepareOptionsMenu(menu);
    }
    private void getDatabase() {
        DAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();

    }

    public static Intent intentFactory(Context context, int adminId){
        Intent intent = new Intent(context, AdminAddMovie.class);
        intent.putExtra(User_ID_KEY, adminId);
        return intent;
    }
}