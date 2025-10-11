package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    public String usernameTxt,passwordTxt;

    TextInputLayout password, username;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://code-elevate-a1329-default-rtdb.firebaseio.com/");
    Button login, b2, b3, signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.pass);

        login=(Button)findViewById(R.id.loginn);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                usernameTxt=username.getEditText().getText().toString();
                passwordTxt=password.getEditText().getText().toString();
                if(usernameTxt.isEmpty() && passwordTxt.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill all filds!", Toast.LENGTH_SHORT).show();
                    return;
                }


                databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        if(usernameTxt.isEmpty() && passwordTxt.isEmpty()){
                            Toast.makeText(getApplicationContext(),"Please fill all filds!", Toast.LENGTH_SHORT).show();
                        }
                        if(snapshot.hasChild(usernameTxt)){
                            String getPassword = snapshot.child(usernameTxt).child("password").getValue(String.class);
                            if(getPassword.equals(passwordTxt))
                            {
                                Toast.makeText(getApplicationContext(),"Welcome "+usernameTxt+"!", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(LoginActivity.this, LanguageSelection.class);
                                intent.putExtra("user_name", usernameTxt);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Wrong Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"User Name doesnot exists!", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }

                });


            }

        });



        b2=(Button)findViewById(R.id.login_page_login_btn);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);


                startActivity(intent);
            }
        });


        b3=(Button)findViewById(R.id.admin_login_btn);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, Admin.class);
                startActivity(intent);
            }
        });

        /*Button lagbena = (Button) findViewById(R.id.invisible_btn);
        lagbena.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, LanguageSelection.class);
                startActivity(intent);
            }
        });*/













    }
}