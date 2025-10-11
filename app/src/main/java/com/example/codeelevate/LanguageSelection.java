package com.example.codeelevate;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class LanguageSelection extends AppCompatActivity {

    AppCompatButton b1, b2;
    Button b3;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);


        b1=(AppCompatButton) findViewById(R.id.cpp);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(LanguageSelection.this, C_Plus_Plus.class);
                intent.putExtra("L_name", "cpp");
                startActivity(intent);


            }
        });


        b2=(AppCompatButton) findViewById(R.id.java);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(LanguageSelection.this, Java.class);
                intent.putExtra("L_name", "java");
                startActivity(intent);
            }
        });
        // Navagation Drawar------------------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);

        toggle = new ActionBarDrawerToggle(LanguageSelection.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_account:
                        Intent intent2 = new Intent(LanguageSelection.this,AccountInfo.class);
                        Intent intent = getIntent();
                        String userName = intent.getStringExtra("user_name");
                        intent.putExtra("user_name", userName);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_leaderBoard:
                        Intent intent3 = new Intent(LanguageSelection.this,LeaderBoard.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_signout:
                        Intent intent4 = new Intent(LanguageSelection.this,LoginActivity.class);
                        startActivity(intent4);
                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }
        });

        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }
}