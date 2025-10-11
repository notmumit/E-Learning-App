package com.example.codeelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class AccountInfo extends AppCompatActivity {


    TextView name, user_name_btn, email, stopstalk, progress;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://code-elevate-a1329-default-rtdb.firebaseio.com/");

    String _email, _stopstalk, getName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        name = findViewById(R.id.usernamee);
        user_name_btn = findViewById(R.id.usernamee);
        email = findViewById(R.id.nameee);
        stopstalk = findViewById(R.id.nameee);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("user_name");



        /*databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.hasChild(userName)){
                    getName = snapshot.child(userName).child("fullname").getValue(String.class);
                    _email = snapshot.child(userName).child("email").getValue(String.class);
                    //_stopstalk = snapshot.child(userName).child("stopstalk").getValue(String.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }

        });

        name.setText(getName);
        email.setText(_email);*/
        //stopstalk.setText(_stopstalk);


    }
}