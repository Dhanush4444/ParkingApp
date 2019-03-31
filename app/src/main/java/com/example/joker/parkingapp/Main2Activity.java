package com.example.joker.parkingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    Button loginB;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText emailE, passE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loginB = findViewById(R.id.loginBut);
        emailE = findViewById(R.id.userId);
        passE = findViewById(R.id.passId);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if (mUser != null) {
            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
        } else {
            loginB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(emailE.getText().toString().trim()) || TextUtils.isEmpty(passE.getText().toString().trim())){
                        Toast.makeText(Main2Activity.this, "Fields empty", Toast.LENGTH_SHORT).show();
                    } else{

                    }
                }
            });
        }
    }
}
