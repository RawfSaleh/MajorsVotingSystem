package com.example.majorsvotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.btnlgn);
        TextView T1 = (TextView) findViewById(R.id.sgnup);


    }

   /* public void frstpg(View V){
        Internt i = new Intent(this,);

    }*/

}