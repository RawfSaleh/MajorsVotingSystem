package com.example.majorsvotingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProcessSuccessed extends AppCompatActivity {
    // creating a variable for
    // our Firebase Database.
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_successed);
        TextView na = (TextView) findViewById(R.id.textView);

        reference = FirebaseDatabase.getInstance().getReference().child("users");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                   String n = snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name").getValue().toString();
                   na.setText("Thank you "+ n);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });}


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


