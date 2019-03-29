package com.example.joker.parkingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    Button loginB;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText emailE,passE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loginB = findViewById(R.id.loginBut);
        emailE = findViewById(R.id.userId);
        passE = findViewById(R.id.passId);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


    }
}
