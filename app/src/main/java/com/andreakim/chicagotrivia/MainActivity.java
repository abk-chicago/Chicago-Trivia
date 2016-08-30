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

    String mCorrectMessage = "Congratulations, you are CORRECT!";
    String mIncorrectMessage = "Sorry, you are INCORRECT.";
    private Chicago[] mChicago = new Chicago[10];
    private Button mBtnFalse;
    private Button mBtnTrue;
    private Button mBtnPlay;
    private TextView mTextView2;
    private TextView mTxtAttempts;
    private TextView mTxtScore;

    int randomInt;
    public int score;
    public int attempts;
    public String attemptNum = String.valueOf(attempts);
    public String totScore = String.valueOf(score);

// I haven't figured out how to display this (below) with the Toast yet...

//  String trivia2fact = "This statement is false; It is actually the tallest in western hemisphere.";
//  (trivia2 is false; tallest in western hemisphere)
//  String trivia6fact = "This statement is false; The date should be 1837.";
//  (trivia6 is false. should be 1837)
//  String trivia10fact = "This statement is false; The date should be 1889.";
//  (trivia10 is false. date should 1889)

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        String trivia1 = getString(R.string.trivia1);
        String trivia2 = getString(R.string.trivia2);
        String trivia3 = getString(R.string.trivia3);
        String trivia4 = getString(R.string.trivia4);
        String trivia5 = getString(R.string.trivia5);
        String trivia6 = getString(R.string.trivia6);
        String trivia7 = getString(R.string.trivia7);
        String trivia8 = getString(R.string.trivia8);
        String trivia9 = getString(R.string.trivia9);
        String trivia10 = getString(R.string.trivia10);


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
        mTxtScore = (TextView) findViewById(R.id.num_correct);
        mTxtAttempts = (TextView) findViewById(R.id.num_attempts);

        mTxtAttempts.setText(attemptNum);
        mTxtScore.setText(totScore);

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
                    increaseCorrect();
                    increaseTotal();
                } else {
                    Toast.makeText(getApplicationContext(), mIncorrectMessage, Toast.LENGTH_LONG).show();
                    increaseTotal();
                }

            }
        });

        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChicago[randomInt].isTrue()) {
                    Toast.makeText(getApplicationContext(), mIncorrectMessage, Toast.LENGTH_LONG).show();
                    increaseTotal();
                } else {
                    Toast.makeText(getApplicationContext(), mCorrectMessage, Toast.LENGTH_LONG).show();
                    increaseCorrect();
                    increaseTotal();
                }

            }
        });
    }

    public void playGame(int randomNum) {

        mTextView2.setText(mChicago[randomNum].getmTrivia());

    }


    public void increaseTotal(){
        attempts++;
        mTxtAttempts.setText(attemptNum);
        mTxtScore.setText(totScore);
    }

    public void increaseCorrect(){
        score++;
        mTxtAttempts.setText(attemptNum);
        mTxtScore.setText(totScore);
    }

}
