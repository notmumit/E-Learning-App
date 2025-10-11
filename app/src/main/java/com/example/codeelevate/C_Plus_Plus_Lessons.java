package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class C_Plus_Plus_Lessons extends AppCompatActivity {

    TextView paragraph,lesson_number;
    String Language, lessonNo;

    Button quiz;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://code-elevate-a1329-default-rtdb.firebaseio.com/");
    String paragraph_from_database, quiz_database, problems_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus_plus_lessons);


        paragraph = findViewById(R.id.para);


        Language = getIntent().getStringExtra("L_name");
        lessonNo = getIntent().getStringExtra("Lesson_name");
        databaseReference.child(Language).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.hasChild(lessonNo)){
                    paragraph_from_database = snapshot.child(lessonNo).child("para").getValue(String.class);
                    paragraph.setText(paragraph_from_database);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }

        });
        lesson_number=findViewById(R.id.lesson_number);
        lesson_number.setText("Lesson : 0"+lessonNo);

       /* lesson_btn=(Button)findViewById(R.id.lesson_btn);

        lesson_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                paragraph.setText(paragraph_from_database);
            }

        });*/
        quiz=(Button)findViewById(R.id.quiz_btn);

        quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(C_Plus_Plus_Lessons.this, Quiz.class);
                intent.putExtra("L_name_for_quiz", "cpp");
                intent.putExtra("Lesson_name_for_quiz", lessonNo);
                startActivity(intent);
            }

        });

        /*problems=(Button)findViewById(R.id.problems_btn);

        problems.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                paragraph.setText("PROBLEM 1:\n"+problems_database1+"\n\n\n"+
                        "PROBLEM 2:\n"+problems_database2+"\n\n\n"+
                        "PROBLEM 3:\n" +problems_database3+"\n\n\n"+
                        "PROBLEM 4:\n"+ problems_database4+"\n\n\n"+
                        "PROBLEM 5:\n"+problems_database5);
            }*//*

        });*/

    }

}