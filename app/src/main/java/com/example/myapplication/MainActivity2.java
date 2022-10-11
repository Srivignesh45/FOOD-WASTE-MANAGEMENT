package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, create;
    private EditText editTextTextFullName,editTextTextEmailAddress,editTextTextPassword;


    private FirebaseAuth mAuth;
    private TextView button5;
    private MediaRouteButton progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mAuth=FirebaseAuth.getInstance();

        banner = (TextView)findViewById(R.id.button5);
        banner.setOnClickListener(this);

        create = (Button)findViewById(R.id.button5);
        create.setOnClickListener(this);


        editTextTextFullName = (EditText)findViewById(R.id.editTextTextFullName);
        editTextTextEmailAddress = (EditText)findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText)findViewById(R.id.editTextTextPassword);





        button5 = (TextView) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                Toast.makeText(getApplicationContext(), "YOUR ACCOUNT WAS SUCCESSFULLY CREATED",
                        Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button5:
                startActivity(new Intent(this, MainActivity2.class));
                break;


        }
    }

    private void button5(){
        String name=editTextTextFullName.getText().toString().trim();
        String email=editTextTextEmailAddress.getText().toString().trim();
        String password=editTextTextPassword.getText().toString().trim();


        if(name.isEmpty()){
            editTextTextFullName.setError("Full name is required");
            editTextTextFullName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextTextEmailAddress.setError("Email is required");
            editTextTextEmailAddress.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextTextPassword.setError("Min password length should be 6 characters");
            editTextTextPassword.requestFocus();
            return;
        }

        Object view;
        progressBar.setVisibility(view.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                })





    }
}