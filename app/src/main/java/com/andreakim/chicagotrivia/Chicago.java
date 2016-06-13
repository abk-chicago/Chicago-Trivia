package com.andreakim.chicagotrivia;

import java.util.Random;

/**
 * Created by andreakim on 6/9/16.
 */
public class Chicago {

    String mTrivia;
    String mCorrectMessage;
    String mIncorrectMessage;
    boolean isTrue;

    public Chicago() {

    }

    public Chicago(String facts, boolean isTrue) {
        this.mTrivia = facts;
        this.isTrue = isTrue || false;
    }

    public String getTrivia() {
        return mTrivia;
    }

    public void setCorrectMessage(String correctMessage) {
        mCorrectMessage = correctMessage;
    }

    public String getCorrectMessage() {
        return mCorrectMessage;
    }

    public void setIncorrectMessage(String incorrectMessage) {
        mIncorrectMessage = incorrectMessage;
    }

    public String getIncorrectMessage() {
        return mIncorrectMessage;
    }




}