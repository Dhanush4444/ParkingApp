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
    Button but1, but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = findViewById(R.id.button1);
        but2 = findViewById(R.id.button2);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String status = dataSnapshot.child("Parking").child("1").child("Status").getValue().toString();

                if (!status.equals("EMPTY"))
                    but1.setBackgroundColor(getResources().getColor(R.color.red));
            else
                but1.setBackgroundColor(getResources().getColor(R.color.green));
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
