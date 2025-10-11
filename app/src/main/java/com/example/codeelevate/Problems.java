package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Problems extends AppCompatActivity {

    String Language, lessonNo;
    String problems_database1,problems_database2,problems_database3,problems_database4,problems_database5;;;;;
    Button problems_1,problems_2,problems_3,problems_4,problems_5;;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://code-elevate-a1329-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);

        problems_1 = findViewById(R.id.problem_1_btn);
        problems_2 = findViewById(R.id.problem_2_btn);
        problems_3 = findViewById(R.id.problem_3_btn);
        problems_4 = findViewById(R.id.problem_4_btn);
        problems_5 = findViewById(R.id.problem_5_btn);


        Language = getIntent().getStringExtra("L_name_for_quiz");
        lessonNo = getIntent().getStringExtra("Lesson_name_for_quiz");
        databaseReference.child(Language).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.hasChild(lessonNo)){

                    problems_database1 = snapshot.child(lessonNo).child("problems1").getValue(String.class);
                    problems_database2 = snapshot.child(lessonNo).child("problems2").getValue(String.class);
                    problems_database3 = snapshot.child(lessonNo).child("problems3").getValue(String.class);
                    problems_database4 = snapshot.child(lessonNo).child("problems4").getValue(String.class);
                    problems_database5 = snapshot.child(lessonNo).child("problems5").getValue(String.class);



                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }

        });



        problems_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(problems_database1 != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(problems_database1));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Problems Available Here",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        problems_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(problems_database2 != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(problems_database2));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Problems Available Here",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



        problems_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(problems_database3 != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(problems_database3));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Problems Available Here",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });





        problems_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(problems_database4 != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(problems_database4));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Problems Available Here",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });





        problems_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(problems_database5 != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(problems_database5));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Problems Available Here",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}