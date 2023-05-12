package com.example.cst338_p2_movie_schmovies;

import static com.example.cst338_p2_movie_schmovies.MainActivity.PREFERENCE_KEY;
import static com.example.cst338_p2_movie_schmovies.MainActivity.User_ID_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.cst338_p2_movie_schmovies.DB.AppDataBase;
import com.example.cst338_p2_movie_schmovies.DB.DAO;

import java.util.ArrayList;
import java.util.List;

public class central_movie_page extends AppCompatActivity {
//    protected static final String User_ID_KEY = "com.example.cst338_p2_movie_schmovies.userIdKey";
//    private static final String PREFERENCE_KEY = "com.example.cst338_p2_movie_schmovies.com.PREFERENCE_KEY";





    private DAO DAO;
    private int userId  = -1;
    private SharedPreferences Preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_movie_page);

        RecyclerView recyclerView = findViewById(R.id.mainRecyclerView);

        List<Movie> items = new ArrayList<>();
        items.add(new Movie("Gardians of the Galaxy Vol.3", "Heroes who save the galaxy", "Pg-13" , R.drawable.a));
        items.add(new Movie("Super Mario Bros", "Plumbers", "Pg-13", R.drawable.b));
        items.add(new Movie("John Wick Chapter 4", "Assassin who is in the run", "Pg-13", R.drawable.c));
        items.add(new Movie("Dungeons and dragons ", "People who live in a different realm", "Pg-13", R.drawable.d));
        items.add(new Movie("Suzume", "Anime movie", "Pg-13" , R.drawable.e));
        items.add(new Movie("Spiderman Across the Spider Verse ", "Mile Morales travels into the multiverse and is on the run due to his actions that he wants to do", "Pg-13", R.drawable.f));


        getCentralDatabase();



//        Movie movie1 = new Movie("Guardians of the Galaxy Vol.3", "Heroes who save the galaxy", "PG-13");
//        DAO.insert(movie1);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final AdapterClass ItemAdapter = new AdapterClass(getApplicationContext(),items);
        recyclerView.setAdapter(ItemAdapter);

//        ItemAdapter.setOnClickListener( new ItemAdapter.OnClickListener() {
//
//          Intent intent = Movie_View.intentFactory(getApplicationContext(), userId, )
//        });
//
//
//        Intent unusedIntent = getIntent();
//        userId = unusedIntent.getIntExtra(User_ID_KEY, -1);


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
                        userId = -1;
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

        userId = getIntent().getIntExtra(User_ID_KEY, -1);

        if(userId != -1){
            return;
        }

        if(Preferences == null){
            getPrefs();
        }

        userId = Preferences.getInt(User_ID_KEY, -1);

        if(userId != -1){
            return;
        }

//        List<Users> user = DAO.getAllUsers();
//        if(user.size()<= 0){
//            Users defeUser = new Users("") ;
//            Users altUser = new Users("");
//            DAO.insert(defeUser,altUser);
//        }
//
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

    public static Intent intentFactory(Context context, int userId){
        Intent intent = new Intent(context, central_movie_page.class);
        intent.putExtra(User_ID_KEY, userId);
        return intent;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Users mUser = DAO.getUserById(userId);
        if (mUser != null) {
            MenuItem item = menu.findItem(R.id.user1);
            item.setTitle(mUser.getUsername());

        } else {
            MenuItem item = menu.findItem(R.id.user1);
            item.setTitle("..."); // TODO: Placeholder until we decide what to add instead.
        }

        return super.onPrepareOptionsMenu(menu);
    }
    private void getCentralDatabase() {
        DAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .MovieSchmovieDAO();

    }


}