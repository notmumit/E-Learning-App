package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {

    Button login, user_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        login=(Button)findViewById(R.id.login_admin);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Admin.this, Admin_Main_Page.class);
                startActivity(intent);
            }
        });

        user_login=(Button)findViewById(R.id.login_btn_for_user);
        user_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Admin.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}