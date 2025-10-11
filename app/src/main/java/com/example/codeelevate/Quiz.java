package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Quiz extends AppCompatActivity {

    String Language, lessonNo;
    Button quiz_to_problems;
    TextView quiz1_question, quiz2_question, quiz3_question, quiz4_question, quiz5_question;
    TextView quiz1_ANS_VERDICT, quiz2_ANS_VERDICT, quiz3_ANS_VERDICT, quiz4_ANS_VERDICT, quiz5_ANS_VERDICT;
    String quiz_database1,quiz_database2,quiz_database3,quiz_database4,quiz_database5,
            quiz_database_ans1,quiz_database_ans2,quiz_database_ans3,quiz_database_ans4,quiz_database_ans5;
    Button quiz_ANS_btn1, quiz_ANS_btn2, quiz_ANS_btn3, quiz_ANS_btn4, quiz_ANS_btn5;
    EditText quiz_edit1, quiz_edit2, quiz_edit3,  quiz_edit4, quiz_edit5;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://code-elevate-a1329-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        quiz1_question = findViewById(R.id.quiz1_txt);
        quiz2_question = findViewById(R.id.quiz2_txt);
        quiz3_question = findViewById(R.id.quiz3_txt);
        quiz4_question = findViewById(R.id.quiz4_txt);
        quiz5_question = findViewById(R.id.quiz5_txt);




        Language = getIntent().getStringExtra("L_name_for_quiz");
        lessonNo = getIntent().getStringExtra("Lesson_name_for_quiz");
        databaseReference.child(Language).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.hasChild(lessonNo)){
                    quiz_database1 = snapshot.child(lessonNo).child("quiz").child("q1").getValue(String.class);
                    quiz_database2 = snapshot.child(lessonNo).child("quiz").child("q2").getValue(String.class);
                    quiz_database3 = snapshot.child(lessonNo).child("quiz").child("q3").getValue(String.class);
                    quiz_database4 = snapshot.child(lessonNo).child("quiz").child("q4").getValue(String.class);
                    quiz_database5 = snapshot.child(lessonNo).child("quiz").child("q5").getValue(String.class);
                    quiz_database_ans1 = snapshot.child(lessonNo).child("quiz").child("ans1").getValue(String.class);
                    quiz_database_ans2 = snapshot.child(lessonNo).child("quiz").child("ans1").getValue(String.class);
                    quiz_database_ans3 = snapshot.child(lessonNo).child("quiz").child("ans1").getValue(String.class);
                    quiz_database_ans4 = snapshot.child(lessonNo).child("quiz").child("ans1").getValue(String.class);
                    quiz_database_ans5 = snapshot.child(lessonNo).child("quiz").child("ans1").getValue(String.class);
                    quiz1_question.setText(quiz_database1);
                    quiz2_question.setText(quiz_database2);
                    quiz3_question.setText(quiz_database3);
                    quiz4_question.setText(quiz_database4);
                    quiz5_question.setText(quiz_database5);

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }

        });


        quiz_ANS_btn1 = findViewById(R.id.quiz1_ans_btn);
        quiz_ANS_btn2 = findViewById(R.id.quiz2_ans_btn);
        quiz_ANS_btn3 = findViewById(R.id.quiz3_ans_btn);
        quiz_ANS_btn4 = findViewById(R.id.quiz4_ans_btn);
        quiz_ANS_btn5 = findViewById(R.id.quiz5_ans_btn);


        quiz_edit1 = findViewById(R.id.quiz1_ans);
        quiz_edit2 = findViewById(R.id.quiz2_ans);
        quiz_edit3 = findViewById(R.id.quiz3_ans);
        quiz_edit4 = findViewById(R.id.quiz4_ans);
        quiz_edit5 = findViewById(R.id.quiz5_ans);



        quiz1_ANS_VERDICT = findViewById(R.id.quiz1_ans_check);
        quiz2_ANS_VERDICT = findViewById(R.id.quiz2_ans_check);
        quiz3_ANS_VERDICT = findViewById(R.id.quiz3_ans_check);
        quiz4_ANS_VERDICT = findViewById(R.id.quiz4_ans_check);
        quiz5_ANS_VERDICT = findViewById(R.id.quiz5_ans_check);



        quiz_ANS_btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               if(quiz_database_ans1 .equals(quiz_edit1.getText().toString() ) )
                   quiz1_ANS_VERDICT.setText("  CORRECT");
               else
                   quiz1_ANS_VERDICT.setText("  WRONG");

            }
        });




        quiz_ANS_btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(quiz_database_ans2 .equals(quiz_edit2.getText().toString() ) )
                    quiz2_ANS_VERDICT.setText("  CORRECT");
                else
                    quiz2_ANS_VERDICT.setText("  WRONG");

            }
        });




        quiz_ANS_btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(quiz_database_ans3 .equals(quiz_edit3.getText().toString() ) )
                    quiz3_ANS_VERDICT.setText("  CORRECT");
                else
                    quiz3_ANS_VERDICT.setText("  WRONG");

            }
        });





        quiz_ANS_btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(quiz_database_ans4 .equals(quiz_edit4.getText().toString() ) )
                    quiz4_ANS_VERDICT.setText("  CORRECT");
                else
                    quiz4_ANS_VERDICT.setText("  WRONG");

            }
        });



        quiz_ANS_btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(quiz_database_ans5 .equals(quiz_edit5.getText().toString() ) )
                    quiz5_ANS_VERDICT.setText("  CORRECT");
                else
                    quiz5_ANS_VERDICT.setText("  WRONG");

            }
        });


















        quiz_to_problems=(Button)findViewById(R.id.quiz_section_to_problems_section);
        quiz_to_problems.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Quiz.this, Problems.class);
                intent.putExtra("L_name_for_quiz", "cpp");
                intent.putExtra("Lesson_name_for_quiz", lessonNo);
                startActivity(intent);
            }
        });
        //lesson_number=findViewById(R.id.lesson_number);


    }
}