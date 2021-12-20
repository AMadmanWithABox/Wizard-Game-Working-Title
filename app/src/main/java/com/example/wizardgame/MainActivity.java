package com.example.wizardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    /** random number generator.
     *  generates number between min and max then displays to System.out
     * @param min minimum number
     * @param max maximum number
     * @param comment comment for System out so we can see why number generated
     * @return The random number
     */
    public int random(int min, int max,String comment) {
        Random random = new Random();
        int randInt = random.nextInt((max - min) + 1) + min;
        System.out.println(randInt + " " + comment);

        return randInt;
    }
}
