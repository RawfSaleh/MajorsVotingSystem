package com.example.majorsvotingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity implements View.OnClickListener{

    private TextView register,forgotPassword;
    private EditText editTextEmail,editTextPassword;
    private Button singnIn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        register=(TextView)findViewById(R.id.textView3);
        register.setOnClickListener(this);
        singnIn=(Button)findViewById(R.id.button);
        singnIn.setOnClickListener(this);
        editTextEmail=(EditText)findViewById(R.id.editTextTextEmailAddress);
        editTextPassword=(EditText)findViewById(R.id.editTextTextPassword);
        mAuth= (FirebaseAuth) FirebaseAuth.getInstance();
        forgotPassword=(TextView)findViewById(R.id.textView2);
        forgotPassword.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView3:
                startActivity(new Intent(this,registeration.class));
                break;
            case R.id.button:
                userLogIn();
                break;
            case R.id.textView2:
                startActivity(new Intent(this,ForgotPassword.class));

        }

    }

    private void userLogIn() {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        if(email.isEmpty()){
            editTextEmail.setError("Email is requierd");
            editTextEmail.requestFocus();
            return;}

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;}
        if(password.isEmpty()){
            editTextPassword.setError("Password is requierd!");
            editTextPassword.requestFocus();
            return;}
        if(password.length()<6){
            editTextPassword.setError("Password is less than 6 chars!");
            editTextPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(LogIn.this,MainActivity.class));
                }else {
                    Toast.makeText(LogIn.this, "Faild to login! please check your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}