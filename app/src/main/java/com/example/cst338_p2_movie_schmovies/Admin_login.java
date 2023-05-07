package com.example.cst338_p2_movie_schmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst338_p2_movie_schmovies.DB.DAO;

public class Admin_login extends AppCompatActivity {

    private TextView adminLoginHeader;
    private EditText adminUsernameField;
    private EditText adminPasswordField;
    private Button adminLoginButton;

    private String adminUsername;
    private String adminPassword;

    private DAO DAO;
    private Users adminUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        wiredUpDisplay();
    }

    private void wiredUpDisplay() {
        adminUsernameField = findViewById(R.id.AdminUserNameTextInput);
        adminPasswordField = findViewById(R.id.AdminPasswordTextInput);
        adminLoginHeader = findViewById(R.id.AdminLogInHeader);
        adminLoginButton = findViewById(R.id.AdminLoginSubmitButton);

        adminLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLoginValuesFromDisplay();
                if(checkForUserInDatabase()){
                    if(!approvePassword()){
                        Toast.makeText(Admin_login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                    }else{
                       if(! adminUser.getAdmin()){
                           Toast.makeText(Admin_login.this, "Not an admin, please return to login page to log in as a user", Toast.LENGTH_SHORT).show();
                       } else{
                           Intent intent = new Intent(Admin_login.this, central_movie_page.class);
                           startActivity(intent);

                       }
                    }
                }
            }
        });

    }

    private boolean approvePassword() {
        return adminUser.getPassword().equals(adminPassword);
    }

    private boolean checkForUserInDatabase() {
        adminUser = DAO.getUserByUsername(adminUsername);
        if(adminUser == null){
            Toast.makeText(this, "no user " + adminUsername + " found", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void getLoginValuesFromDisplay() {
        adminUsername = adminUsernameField.getText().toString();
        adminPassword = adminPasswordField.getText().toString();
    }

    public Intent intentFactory(Context context){
        Intent intent = new Intent(context, Admin_login.class);
        return intent;
    }

}