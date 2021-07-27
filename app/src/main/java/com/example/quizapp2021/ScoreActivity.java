package com.example.quizapp2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV;
    int score;
    Intent incomingIntent;
    Button emailScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);

        emailScore = (Button) findViewById(R.id.emailButton);
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("scoreName", 0);
        scoreTV.setText("Your score is: " + score);

        emailScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[]{"keith.marshall@pgcps.org"};
                String subject = "Here is your score:";
                composeEmail(addresses, subject);
            }
        });
    }
    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
    }  //Source: https://developer.android.com/guide/components/intents-common#Email

}