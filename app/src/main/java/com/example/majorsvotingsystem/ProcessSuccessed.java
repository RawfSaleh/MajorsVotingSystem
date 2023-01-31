package com.example.majorsvotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ProcessSuccessed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_successed);
    }
    public void deletevote(View v){
        FirebaseDatabase.getInstance().getReference("users")
                // set user register id to a collection
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("vote").removeValue();
        Toast.makeText(getApplicationContext(),"your vote has been deleted!",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,VotingPage.class);
        startActivity(i);
    }
    public void topage1(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}