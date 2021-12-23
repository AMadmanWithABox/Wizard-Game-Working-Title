package com.example.wizardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListOfSpells listOfSpells = new ListOfSpells();
    TextView etInformation;
    Button bOption1, bOption2, bOption3, bOption4, bStats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        initUI();
    }

    public void initUI(){
        etInformation = findViewById(R.id.etInformation);
        bOption1 = findViewById(R.id.bOption1);
        bOption2 = findViewById(R.id.bOption2);
        bOption3 = findViewById(R.id.bOption3);
        bOption4 = findViewById(R.id.bOption4);
        bStats = findViewById(R.id.bStats);
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
