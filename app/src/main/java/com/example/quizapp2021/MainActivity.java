package com.example.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<Sting> extends AppCompatActivity {

    //First step: declare the variables

    TextView questionTV;
    Button trueButton;
    Button falseButton;
    Button nextButton;
    String message;
    int score;
    Question q1, q2, q3, q4, q5, currentQ;
    Question[] questions;
    int currentQindex;
    CharSequence text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2nd step: inflate

        questionTV = (TextView) findViewById(R.id.questionTV);

        trueButton = (Button) findViewById(R.id.trueButton);

        falseButton = (Button) findViewById(R.id.falseButton);

        nextButton = (Button) findViewById(R.id.nextButton);

        score = 0;
        currentQindex = 0;

        q1 = new Question("Ronald Reagan was also a US President.", true);
        q2 = new Question("The Terminator franchise is a series of Broadway musicals", false);
        q3 = new Question("Michael Burhnam is the first Black female Star Trek captain", false);
        q4 = new Question("Kate Mulgrew was not the first person to play Captain Janeway", true);
        q5 = new Question("Garfield has been voiced by Lorenzo Music", true);

        questions = new Question[] {q1, q2, q3, q4, q5};
        currentQ = questions[currentQindex];


        //3rd step:

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentQ.getCorrectAnswer() == true) {
                    text = "CORRECT!";
                    score += 1;
                }

                else {
                    text = "Sorry";
                }

                Context context = getApplicationContext();
                //CharSequence text = "CORRECT!";
                int duration = Toast.LENGTH_SHORT;
                //score += 1;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentQ.getCorrectAnswer() == false) {
                    text = "CORRECT!";
                    score += 1;
                }

                else {
                    text = "Sorry";
                }

                Context context = getApplicationContext();
                //CharSequence text = "Try again.";
                int duration = Toast.LENGTH_SHORT;
                //score +=1;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentQindex < questions.length - 1) {

                    currentQindex += 1;
                    currentQ = questions[currentQindex];
                    questionTV.setText(currentQ.getQuestionText());

                }

                else {
                    Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                    intent.putExtra("scoreName",score);
                    startActivity(intent);
                }

                //Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                //intent.putExtra("scoreName",score);
                //startActivity(intent);

            }
        });



    }
}