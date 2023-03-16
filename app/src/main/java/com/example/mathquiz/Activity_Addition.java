package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Activity_Addition extends AppCompatActivity {

    TextView score;
    TextView scorevalue;

    TextView lifetime;
    TextView lifetimevalue;

    TextView time;
    TextView timevalue;

    TextView question;
    TextView answer;

    Button ok;
    Button nextquestion;
    int number1;
    int number2;
    Random random =new Random();
    int Useranswer;
    int mainAnswer;
    int userscore=0;
    int  userlife=3;

    CountDownTimer timer;
    private  static  final long START_TIMER_IN_MILISECONDS = 60000;
    boolean time_running;
    long time_left_in_mili_seconds = START_TIMER_IN_MILISECONDS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        score= findViewById(R.id.textViewscore);
        scorevalue=findViewById(R.id.textViewvalue);
        lifetime=findViewById(R.id.textViewlifetime);
        lifetimevalue=findViewById(R.id.textViewlifevalue);
        time=findViewById(R.id.textViewtime);
        timevalue=findViewById(R.id.textViewtimeValue);
        question=findViewById(R.id.textViewquestion);
        answer=findViewById(R.id.editTextAnswer);
        ok=findViewById(R.id.buttonok);
        nextquestion=findViewById(R.id.buttonnextquestion);
        continueQuestion();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pausetimer();

                Useranswer =Integer.valueOf(answer.getText().toString());
                if(mainAnswer==Useranswer)
                {
                    userscore+=10;
                    scorevalue.setText(""+userscore);
                    question.setText("congratulation your answer is right");
                }
                else
                {
                    userlife=userlife-1;
                    lifetimevalue.setText(""+userlife);
                    question.setText("Sorry try next time");

                }
            }
        });

        nextquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                answer.setText("");
                resettimer();
                if(userlife<=0)
                {
                    Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Activity_Addition.this, Game.class);
                    intent.putExtra("Score",userscore);
                    startActivity(intent);
                    finish();
                }

                else
                {
                    continueQuestion();
                }



            }
        });

    }
    public void continueQuestion(){
        number1=random.nextInt(100);
        number2=random.nextInt(100);
        mainAnswer = number1+number2;

        question.setText(number1+"+"+number2);

        counttimer();



    }

    public  void counttimer()
    {
        timer = new CountDownTimer(time_left_in_mili_seconds,1000) {
            @Override
            public void onTick(long millsuntilfinished) {

                time_left_in_mili_seconds =millsuntilfinished;
                updatetext();


            }

            @Override
            public void onFinish() {

                time_running= false;
                pausetimer();
                resettimer();
                updatetext();

                userlife-=1;
                lifetime.setText(userlife );
                question.setText("sorry try next time "+"time is up");

            }
        }.start();

        time_running=true;
    }

    public void updatetext()
    {
        int second=(int)(time_left_in_mili_seconds/1000)%60;
        String time_left = String.format(Locale.getDefault(),"%2d",second);
        timevalue.setText(time_left);
    }

    public  void pausetimer()
    {
        timer.cancel();
        time_running=false;
    }

    public  void resettimer()
    {
        time_left_in_mili_seconds=START_TIMER_IN_MILISECONDS;
        updatetext();
    }
}