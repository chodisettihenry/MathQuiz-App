package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Button;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Addition;
    Button subctraction;
    Button Multiplication;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Addition=findViewById(R.id.buttonAdd);
        subctraction  = findViewById(R.id.buttonSub);
        Multiplication = findViewById(R.id.buttonMul);

        Addition.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Activity_Addition.class);
                startActivity(intent);
                finish();
            }
        });

    }
}