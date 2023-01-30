package com.example.majorsvotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProcessSuccessed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_successed);
    }
    public void topage1(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}