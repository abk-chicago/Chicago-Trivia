package com.andreakim.chicagotrivia;

import java.util.Random;

/**
 * Created by andreakim on 6/9/16.
 */


//this project is unfinished


public class Chicago {
    String mTrivia;
    boolean isTrue;

    public Chicago() {

    }

    public Chicago(String mTrivia, boolean isTrue) {
        this.mTrivia = mTrivia;
        this.isTrue = isTrue || false;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String getmTrivia() {

        return mTrivia;
    }

    public void setmTrivia(String mTrivia) {
        this.mTrivia = mTrivia;
    }
}