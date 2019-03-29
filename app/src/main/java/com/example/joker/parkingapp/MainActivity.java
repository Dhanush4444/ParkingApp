package com.example.joker.parkingapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    Button but1, but2, but3, but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = findViewById(R.id.button1);
        but2 = findViewById(R.id.button2);
        but3 = findViewById(R.id.button3);
        but4 = findViewById(R.id.button4);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String status1 = dataSnapshot.child("Parking").child("1").child("Status").getValue().toString();
                String status2 = dataSnapshot.child("Parking").child("2").child("Status").getValue().toString();
                String status3 = dataSnapshot.child("Parking").child("3").child("Status").getValue().toString();
                String status4 = dataSnapshot.child("Parking").child("4").child("Status").getValue().toString();

                if (!status1.equals("EMPTY"))
                    but1.setBackgroundColor(getResources().getColor(R.color.red));
                else
                    but1.setBackgroundColor(getResources().getColor(R.color.green));


                if (!status2.equals("EMPTY"))
                    but2.setBackgroundColor(getResources().getColor(R.color.red));
                else
                    but2.setBackgroundColor(getResources().getColor(R.color.green));


                if (!status3.equals("EMPTY"))
                    but3.setBackgroundColor(getResources().getColor(R.color.red));
                else
                    but3.setBackgroundColor(getResources().getColor(R.color.green));

                if (!status4.equals("EMPTY"))
                    but4.setBackgroundColor(getResources().getColor(R.color.red));
                else
                    but4.setBackgroundColor(getResources().getColor(R.color.green));


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
