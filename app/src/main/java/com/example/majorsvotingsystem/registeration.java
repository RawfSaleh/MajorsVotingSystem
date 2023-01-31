package com.example.majorsvotingsystem;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registeration extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private Button register;
    private EditText name,age,email,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        mAuth=FirebaseAuth.getInstance();
        register=(Button)findViewById(R.id.button2);
        register.setOnClickListener(this);
        name=(EditText)findViewById(R.id.editTextTextPersonName);
        age=(EditText)findViewById(R.id.editTextTextPersonName2);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress2);
        pw=(EditText)findViewById(R.id.editTextTextPassword2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                register();
                break;
        }}

        private void register() {
            String em=email.getText().toString().trim();
            String password=pw.getText().toString().trim();
            String na=name.getText().toString().trim();
            String ag=age.getText().toString().trim();

            if(na.isEmpty()){
                name.setError("Name is requierd!");
                name.requestFocus();
                return;
            }
            if(ag.isEmpty()){
                age.setError("Age is requierd!");
                age.requestFocus();
                return;
            }
            if(em.isEmpty()){
                email.setError("Email is requierd!");
                email.requestFocus();
                return;}

            if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
                email.setError("Please provide valid email!");
                email.requestFocus();
                return;
            }


            if(password.isEmpty()){
                pw.setError("Password is requierd!");
                pw.requestFocus();
                return;
            }
            if(password.length()<6){
                pw.setError("Password is less than 6 chars!");
                pw.requestFocus();
                return;

            }
            mAuth.createUserWithEmailAndPassword(em,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                user User=new user(na,ag,em);                  //name of collection
                                FirebaseDatabase.getInstance().getReference("users")
                                        // set user register id to a collection
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        //to ensure that data has been inserted
                                        .setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(registeration.this,"User has been registerd successfully!",Toast.LENGTH_LONG).show();
                                                    //redirect user to voting activity
                                                }else{
                                                    Toast.makeText(registeration.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        }
                    });
        }


    }



