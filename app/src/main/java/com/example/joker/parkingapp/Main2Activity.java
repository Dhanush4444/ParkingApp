package com.example.joker.parkingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else {
            loginB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(emailE.getText().toString().trim()) || TextUtils.isEmpty(passE.getText().toString().trim())){
                        Toast.makeText(Main2Activity.this, "Fields empty", Toast.LENGTH_SHORT).show();
                    } else{
                            mAuth.signInWithEmailAndPassword(emailE.getText().toString().trim(),passE.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Main2Activity.this, "Loggin you in", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    } else{
                                        Toast.makeText(Main2Activity.this, "No such email or password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    }
                }
            });
        }
    }
}
