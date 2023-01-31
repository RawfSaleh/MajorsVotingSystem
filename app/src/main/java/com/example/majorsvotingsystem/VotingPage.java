package com.example.majorsvotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class VotingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);
    }
    public void addcivil(View v){
        FirebaseDatabase.getInstance().getReference("users")
                // set user register id to a collection
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("vote").setValue("Civil Engineering");
        topage6(v);
    }
    public void addpsy(View v){
        FirebaseDatabase.getInstance().getReference("users")
                // set user register id to a collection
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("vote").setValue("Psychology");
        topage6(v);
    }
    public void addis(View v){
        FirebaseDatabase.getInstance().getReference("users")
                // set user register id to a collection
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("vote").setValue("Information System");
        topage6(v);
    }
    public void addmusic(View v){
        FirebaseDatabase.getInstance().getReference("users")
                // set user register id to a collection
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("vote").setValue("Music");
        topage6(v);
    }
    public void addcyber(View v){
        FirebaseDatabase.getInstance().getReference("users")
                // set user register id to a collection
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("vote").setValue("Cyber Security");
        topage6(v);
    }
    public void topage6(View v){
        Intent i = new Intent(this,ProcessSuccessed.class);
        startActivity(i);
    }
}