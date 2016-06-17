package com.andreakim.chicagotrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

//this project is unfinished

    String trivia1 = "The first Ferris wheel made its debut in Chicago at the 1893 World's Columbian Exposition";
    String trivia2 = "The Willis Tower is the tallest building in the world.";
    String trivia3 = "Chicago has the largest collection of Impressionist paintings outside of Paris.";
    String trivia4 = "The term \"Jazz\" was coined in Chicago in 1914.";
    String trivia5 = "Spray paint was invented in Chicago in 1949.";
    String trivia6 = "Chicago was incorporated as a city in 1817.";
    String trivia7 = "The atom was first split (leading to the A bomb and nuclear power) at the University of Chicago.";
    String trivia8 = "Chicago's nicknames include: The Windy City, the City of Big Shoulders, the Second City, and The City That Works.";
    String trivia9 = "Chicago River is the only river in the world that flows backward.";
    String trivia10 = "The Hull House opened in 1923 to aid Chicago immigrants.";
    String mCorrectMessage = "Congratulations, you are CORRECT!";
    String mIncorrectMessage = "Sorry, you are INCORRECT.";
    private Chicago[] mChicago = new Chicago[10];
    private Button mBtnFalse;
    private Button mBtnTrue;
    private Button mBtnPlay;
    private TextView mTextView2;
    private TextView mTxtAttempts;
    private TextView mTxtScore;
    private Toast mToast;
    private int currentQuestion = 0;
    private int score=0;
    private int attempts=0;
    private int randomInt;


// I haven't figured out how to display this (below) with the Toast yet...

//  String trivia2fact = "This statement is false; It is actually the tallest in western hemisphere.";
//  (trivia2 is false; tallest in western hemisphere)
//  String trivia6fact = "This statement is false; The date should be 1837.";
//  (trivia6 is false. should be 1837)
//  String trivia10fact = "This statement is false; The date should be 1889.";
//  (trivia10 is false. date should 1889)

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mChicago[0] = new Chicago(trivia1, true);
        mChicago[1] = new Chicago(trivia2, false);
        mChicago[2] = new Chicago(trivia3, true);
        mChicago[3] = new Chicago(trivia4, true);
        mChicago[4] = new Chicago(trivia5, true);
        mChicago[5] = new Chicago(trivia6, false);
        mChicago[6] = new Chicago(trivia7, true);
        mChicago[7] = new Chicago(trivia8, true);
        mChicago[8] = new Chicago(trivia9, true);
        mChicago[9] = new Chicago(trivia10, false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTrue = (Button) findViewById(R.id.true_button);
        mBtnFalse = (Button) findViewById(R.id.false_button);
        mTextView2 = (TextView) findViewById(R.id.text_view_2);
        mBtnPlay = (Button) findViewById(R.id.get_question);

        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int randomNum = rand.nextInt(10);
                randomInt = randomNum;
                playGame(randomInt);

            }
        });

        mBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mChicago[randomInt].isTrue()) {
                    Toast.makeText(getApplicationContext(), mCorrectMessage, Toast.LENGTH_LONG).show();
               //     attempts++;
               //     score++;

                  //  mTxtAttempts.setText(attempts);
                  //  mTxtScore.setText(score);
                } else {
                    Toast.makeText(getApplicationContext(), mIncorrectMessage, Toast.LENGTH_LONG).show();
                 //   attempts++;
                //    mTxtAttempts.setText(attempts);
                //    mTxtScore.setText(score);
                }
            }
        });

        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChicago[randomInt].isTrue()) {
                    Toast.makeText(getApplicationContext(), mIncorrectMessage, Toast.LENGTH_LONG).show();
                  //  attempts++;
                 //   mTxtAttempts.setText(attempts);
                 //   mTxtScore.setText(score);
                } else {
                    Toast.makeText(getApplicationContext(), mCorrectMessage, Toast.LENGTH_LONG).show();
                //    attempts++;
                //    score++;
                //    mTxtAttempts.setText(attempts);
                //    mTxtScore.setText(score);
                }
            }
        });
    }

    public void playGame(int randomNum) {

        mTextView2.setText(mChicago[randomNum].getmTrivia());

    }
}
