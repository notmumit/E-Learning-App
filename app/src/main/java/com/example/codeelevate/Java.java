package com.example.codeelevate;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Java extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Button button;
    ImageView imageMenu;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    String LessonName[]={"Lesson: 1","Lesson: 2","Lesson: 3","Lesson: 4","Lesson: 5",
            "Lesson: 6","Lesson: 7","Lesson: 8", "Lesson: 9","Lesson: 10","Lesson: 11","Lesson: 12",
            "Lesson: 13","Lesson: 14","Lesson: 15","Lesson: 16"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus_plus);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, LessonName, "java");
        recyclerView.setAdapter(adapter);



        toggle = new ActionBarDrawerToggle(Java.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {



                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent1 = new Intent(Java.this,LanguageSelection.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_account:
                        Intent intent2 = new Intent(Java.this,AccountInfo.class);
                        Intent intent = getIntent();
                        String userName = intent.getStringExtra("user_name");
                        intent.putExtra("user_name", userName);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_leaderBoard:
                        Intent intent3 = new Intent(Java.this,LeaderBoard.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_signout:
                        Intent intent4 = new Intent(Java.this,LoginActivity.class);
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