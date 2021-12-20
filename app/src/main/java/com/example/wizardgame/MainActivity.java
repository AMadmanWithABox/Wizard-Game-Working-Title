package com.example.wizardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //random number generator. will generate number between min and max.
    //comment is for commenting into system out so we can see what number
    //got generated and why.
    public int Random(int min, int max,String comment) {
        Random random = new Random();
        Integer randInt = random.nextInt((max - min) + 1) + min;
        System.out.println(randInt + " " + comment);

        return randInt;
    }


}
