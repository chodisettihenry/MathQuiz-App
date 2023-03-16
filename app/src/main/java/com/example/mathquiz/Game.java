package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView Congrats;
    TextView score;

    Button playagin;
    Button exit;
    int Scoringdata;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent= getIntent();
        Scoringdata= intent.getIntExtra("score",0);
        String userscore=String.valueOf(Scoringdata);
        score.setText("Your score :"+userscore);

        score=findViewById(R.id.textViewcongratsscore);
        Congrats=findViewById(R.id.textViewcongrats);

        playagin=findViewById(R.id.buttonplayagain);
        exit=findViewById(R.id.buttonexit);

        playagin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Game.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 finish();
            }
        });

    }
}