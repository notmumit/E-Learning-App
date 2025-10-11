package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_Main_Page extends AppCompatActivity {




    Button insertInfos;
    EditText language, lessonNo, lessonPara, quiz1,quiz2,quiz3,quiz4,quiz5,
            quiz_ans1, quiz_ans2, quiz_ans3, quiz_ans4, quiz_ans5,
            lessonProblem1, lessonProblem2, lessonProblem3 ,lessonProblem4 ,lessonProblem5;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://code-elevate-a1329-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);


        language=findViewById(R.id.language);
        lessonNo=findViewById(R.id.lesson_no);
        lessonPara=findViewById(R.id.insert_para);
        quiz1=findViewById(R.id.insert_quiz1);
        quiz2=findViewById(R.id.insert_quiz2);
        quiz3=findViewById(R.id.insert_quiz3);
        quiz4=findViewById(R.id.insert_quiz4);
        quiz5=findViewById(R.id.insert_quiz5);
        quiz_ans1=findViewById(R.id.insert_quiz_ans1);
        quiz_ans2=findViewById(R.id.insert_quiz_ans2);
        quiz_ans3=findViewById(R.id.insert_quiz_ans3);
        quiz_ans4=findViewById(R.id.insert_quiz_ans4);
        quiz_ans5=findViewById(R.id.insert_quiz_ans5);
        lessonProblem1=findViewById(R.id.insert_problems1);
        lessonProblem2=findViewById(R.id.insert_problems2);
        lessonProblem3=findViewById(R.id.insert_problems3);
        lessonProblem4=findViewById(R.id.insert_problems4);
        lessonProblem5=findViewById(R.id.insert_problems5);

        insertInfos=(Button)findViewById(R.id.insert_lesson_btn);

        insertInfos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String languageTxt,lessonNoTxt, lessonParaTxt, quizTxt1,  quizTxt2, quizTxt3, quizTxt4, quizTxt5 ,quizAnsTxt1, quizAnsTxt2, quizAnsTxt3, quizAnsTxt4, quizAnsTxt5,problemTxt1 ,problemTxt2,problemTxt3,problemTxt4,problemTxt5;
                languageTxt=language.getText().toString();;
                lessonNoTxt=lessonNo.getText().toString();
                lessonParaTxt= lessonPara.getText().toString();
                quizTxt1=quiz1.getText().toString();
                quizTxt2=quiz2.getText().toString();
                quizTxt3=quiz3.getText().toString();
                quizTxt4=quiz4.getText().toString();
                quizTxt5=quiz5.getText().toString();
                quizAnsTxt1=quiz_ans1.getText().toString();
                quizAnsTxt2=quiz_ans2.getText().toString();
                quizAnsTxt3=quiz_ans3.getText().toString();
                quizAnsTxt4=quiz_ans4.getText().toString();
                quizAnsTxt5=quiz_ans5.getText().toString();
                problemTxt1=lessonProblem1.getText().toString();
                problemTxt2=lessonProblem2.getText().toString();
                problemTxt3=lessonProblem3.getText().toString();
                problemTxt4=lessonProblem4.getText().toString();
                problemTxt5=lessonProblem5.getText().toString();





                    databaseReference.child(languageTxt).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }

                    });

                    if(lessonNoTxt.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("LessonNo").setValue(lessonNoTxt);
                    if(lessonParaTxt.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("para").setValue(lessonParaTxt);
                    if(quizTxt1.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("q1").setValue(quizTxt1);
                    if(quizTxt2.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("q2").setValue(quizTxt2);
                    if(quizTxt3.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("q3").setValue(quizTxt3);
                    if(quizTxt4.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("q4").setValue(quizTxt4);
                    if(quizTxt5.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("q5").setValue(quizTxt5);

                    if(quizAnsTxt1.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("ans1").setValue(quizAnsTxt1);
                    if(quizAnsTxt2.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("ans2").setValue(quizAnsTxt2);
                    if(quizAnsTxt3.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("ans3").setValue(quizAnsTxt3);
                    if(quizAnsTxt4.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("ans4").setValue(quizAnsTxt4);
                    if(quizAnsTxt5.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("quiz").child("ans5").setValue(quizAnsTxt5);

                    if(problemTxt1.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("problems1").setValue(problemTxt1);
                    if(problemTxt2.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("problems2").setValue(problemTxt2);
                    if(problemTxt3.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("problems3").setValue(problemTxt3);
                    if(problemTxt4.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("problems4").setValue(problemTxt4);
                    if(problemTxt5.isEmpty() == false)
                        databaseReference.child(languageTxt).child(lessonNoTxt).child("problems5").setValue(problemTxt5);



                Toast.makeText(getApplicationContext(),"Insertion Successfull", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"Welcome"+usernameTxt+"!", Toast.LENGTH_SHORT).show();

                    /*Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);*/


            }


        });
    }
}