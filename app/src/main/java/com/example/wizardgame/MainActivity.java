package com.example.wizardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inview();
        Gameend();
        needanswer = false;
        saved1 = 0;
        saved2 = 0;
        saved3 = 0;
        player.maintype = elementaltype.Null;
        player.subtype = elementaltype.Null;
        instats = false;
    }

    //todo
    public void inview(){
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        bstats = (Button)findViewById(R.id.statsbtn);

        text = findViewById(R.id.texttxt);
    }
    public void battletime(){
        Intent i = new Intent(this, activity_battle.class);

        bundle.putInt("hp", player.HP);
        bundle.putInt("def", player.DEF);
        bundle.putInt("mp", player.MP);
        i.putExtras(bundle);

        startActivity(i);
    }
    Button b1,b2,b3,b4,bstats;
    TextView text;

    int currentquestion;
    int option1;
    int option2;
    int option3;
    int option4;
    int looper;
    int ran;
    int questionsasked;
    int saved1;
    int saved2;
    int saved3;
    String out;
    Wizard player = new Wizard();
    boolean instats;
    String stat1;
    String stat2;
    String stat3;
    String stat4;
    String statmain;
    boolean gamestart;
    boolean needanswer;
    boolean canopenstats;
    boolean statsbuttonisrandom;
    int button;
    Bundle bundle = new Bundle();

    //randomspellz
    int firelearned;
    int icelearned;
    int ozelearned;
    int waterlearned;
    int earthlearned;
    int airlearned;
    int lifelearned;
    int metallearned;
    int steamlearned;
    int poisonlearned;
    int lightninglearned;
    int soundlearned;
    int soullearned;
    int lightlearned;
    int darklearned;
    int gravitylearned;

    int[] wildorder = new int[]{0,0,0,0,0,0,0,0};
    int wildlearned;



    public void btn1(View v){
        button = 1;
        buttonpressed();
    }
    public void btn2(View v){
        button = 2;
        buttonpressed();
    }
    public void btn3(View v){
        button = 3;
        buttonpressed();
    }
    public void btn4(View v){
        button = 4;
        buttonpressed();
    }
    public void buttonpressed(){
        if(instats == false) {
            Main();
        }else{
            instats = false;
            b1.setText(stat1);
            b2.setText(stat2);
            b3.setText(stat3);
            b4.setText(stat4);
            text.setText(statmain);
        }
    }
    public void btnstats(View v){
        if(statsbuttonisrandom = true){
            button = Random(1,4);
            System.out.println(button + " stats was random");
            statsbuttonisrandom = false;
        }
        if(canopenstats == false){
            Main();
        }else {
            if (instats == false) {
                stat1 = b1.getText().toString();
                stat2 = b2.getText().toString();
                stat3 = b3.getText().toString();
                stat4 = b4.getText().toString();
                statmain = text.getText().toString();

                if (player.subtype == elementaltype.Null) {
                    out = "your stats\nMain Element: " + player.maintype + "\nSup Element: Not Chosen Yet\nHP: " + player.HP + "\nDEF: " + player.DEF + "\nMANA: " + player.MP;
                }else {
                    out = "your stats\nMain Element: " + player.maintype + "\nSup Element: " + player.subtype + "\nHP: " + player.HP + "\nDEF: " + player.DEF + "\nMANA: " + player.MP;
                }
                text.setText(out);
                out = "";
                b1.setText(out);
                b2.setText(out);
                b3.setText(out);
                b4.setText(out);
                instats = true;
            }else {
                instats = false;
                b1.setText(stat1);
                b2.setText(stat2);
                b3.setText(stat3);
                b4.setText(stat4);
                text.setText(statmain);
            }
        }
    }

    public void Main(){
        if(gamestart == false){
            //stats button
            bstats.setText("random");
            statsbuttonisrandom = true;
            //start game
            needanswer = true;
            currentquestion = 1;
            gamestart = true;
            questionsasked = 0;
            ran = Random(1, 6);
            System.out.println(ran + " start type");
            switch(ran){
                case 1:
                    out = "All Good Wizards must start somewhere. You just happen to start on the humble grounds of your grandfather's garden. He was a kind man despite his early departure to wander the world. Before he left he gave you two things, however. The first was an invitation to a high institution of magical learning, the second was your first element. What was that again?";
                    break;
                case 2:
                    out = "All Good Wizards must start somewhere. You started when you came across a magical tree in a forest. This tree was infused with great magical energy granting you a magical element. It also teleported you halfway across the globe on the doorstep of a great institution of magical learning. Of course, I remember what your element was but will you remind me what it was again?";
                    break;
                case 3:
                    out = "All Good Wizards must start somewhere. You stated as a hopeful mage on the steps of a grand institution of magical learning. It took you five times to finally get in but when you did you were challenged with the most important choice of your life. What magical element will you choose?";
                    break;
                case 4:
                    out = "All Good Wizards must start somewhere. You started as a poor serf in the streets of a big city. As you scavenged for food one day though your life changed forever as you found a mystic cupcake that gave you magical powers. You quickly got into a magical institution of learning and choose your first element. What was that again?";
                    break;
                case 5:
                    out = "All Good Wizards must start somewhere. You started as a bounty hunter of grand monsters. You didn’t use magic much but one day on a great hunt you saw another mage cast a spell and it changed your goals forever. You too wanted to learn to control the elements. It didn’t take much to get into an institution of magical learning and you already knew what you wanted for your first element. Wait which did you want again?";
                    break;
                case 6:
                    out = "All Good Wizards must start somewhere. You started with a vision of greatness. Deep in your sleep one night you had a dream where you were a grand Wizard graduating from a grand institution of magical learning. The next morning you found a letter of acceptance in your mail and found yourself on the path of magic shortly after. Unfortunately, your dream didn’t tell you what element you should have chosen so you have to choose now. Which one do you want?";
                    break;
            }
            text.setText(out);
            //set 4 random elements
            option1 = Random(1,16);
            option2 = Random(1,16);
            option3 = Random(1,16);
            option4 = Random(1,16);
            looper = 0;
            while(looper == 0){
                if(option1 == option2 || option1 == option3 || option1 == option4){
                    option2 = Random(1,16);
                    option3 = Random(1,16);
                    option4 = Random(1,16);
                }else if(option2 == option3 || option2 == option4){
                    option3 = Random(1,16);
                    option4 = Random(1,16);
                }else if(option3 == option4){
                    option4 = Random(1,16);
                }else{
                    looper = 1;
                    System.out.println(option1 + " " + option2 + " " + option3 + " " + option4);
                }
            }
            SetButtonElement(option1, 1);
            SetButtonElement(option2, 2);
            SetButtonElement(option3, 3);
            SetButtonElement(option4, 4);

        }else{
            if(needanswer == true){
                //check anwsers and give stats
                needanswer = false;
                out = "Next Question";
                b1.setText(out);
                b2.setText(out);
                b3.setText(out);
                b4.setText(out);
                switch(currentquestion){
                    case 1:
                        switch(button){
                            case 1:
                                stat4 = SetElement(option1,0);
                                learnspellsfromselected(option1,true);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")\nYou Learned a Spell! (" + stat3 + ")";
                                text.setText(out);
                                break;
                            case 2:
                                stat4 = SetElement(option2,0);
                                learnspellsfromselected(option2,true);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")\nYou Learned a Spell! (" + stat3 + ")";
                                text.setText(out);
                                break;
                            case 3:
                                stat4 = SetElement(option3,0);
                                learnspellsfromselected(option3,true);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")\nYou Learned a Spell! (" + stat3 + ")";
                                text.setText(out);
                                break;
                            case 4:
                                stat4 = SetElement(option4,0);
                                learnspellsfromselected(option4,true);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")\nYou Learned a Spell! (" + stat3 + ")";
                                text.setText(out);
                                break;
                        }
                        canopenstats = true;
                        out = "stats";
                        bstats.setText(out);
                        statsbuttonisrandom = false;
                        break;
                    case 2:
                        switch(button){
                            case 1:
                                out = "Brooms. Wow, arn’t you original? Sitting on a small wooden stick all day. Well, at least you got to keep the broom. Who knows it might save your life one day.\nYou Learned a New Spell? (Broom)\nMana + 5";
                                text.setText(out);
                                learn.spell = spellz.broom;
                                player.MP = player.MP + 5;
                                break;
                            case 2:
                                out = "Ah yes, Portal Ball, one of the best sports in the world of wizards. You quickly made your way to the top of the team and will learn much over the course of the year.\nYou Learned a new spell! (Portal)\nMANA + 20";
                                text.setText(out);
                                player.MP = player.MP + 20;
                                learn.spell = spellz.portal;
                                break;
                            case 3:
                                out = "Of course. The old methods of the past are always the best. After all, ones Magical power is tied to one’s fortitude. You made the right call\nHP + 8\nDEF + 1\nMANA + 10";
                                text.setText(out);
                                player.HP = player.HP + 8;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;
                                break;
                            case 4:
                                statmain = learnrandomspell(player.maintype);
                                out = "Skipping class uh. Well, I guess it can’t be helped. What you thought you weren’t going to get caught. The gym teachers take roll ya donk. I mean you did end up learning a spell but at what cost.\nYou Learned a New Spell! (" + statmain + ")\nDEF - 1";
                                text.setText(out);
                                player.DEF = player.DEF - 1;
                                break;
                        }
                        break;
                    case 3:
                        switch(button){
                            case 1:
                                out = "Well, it was as good tasting as you wanted it to be but you do feel slightly more magical. Or maybe a little sicker…\nHP - 4\nMANA + 30";
                                text.setText(out);
                                player.MP = player.MP + 30;
                                player.HP = player.HP - 4;
                                break;
                            case 2:
                                statmain = learnrandomspell(elementaltype.Null);
                                out = "It took some time but you were able to enchant the gem with a random spell. If you are to put some magical energy into the gem the spell should be cast. You think. Maybe you should test it some more before you graduate.\nYou Learned a Spell! (" + statmain + ")";
                                text.setText(out);
                                break;
                            case 3:
                                out = "It took a while to choose what form you wanted this magic item to take but you eventually ended up on a wonderful robe. With that decided the enhancement process few by and you found yourself far more protected than before.\nHP + 10\nDEF + 1";
                                text.setText(out);
                                player.HP = player.HP + 10;
                                player.DEF = player.DEF + 1;
                                break;
                            case 4:
                                out = "In hindsight turning a gem into a potion might have been a bad idea. While you did make a potion that expanded your magical powers it was slightly diluted in the process.\nMANA + 20";
                                text.setText(out);
                                player.MP = player.MP + 20;
                                break;
                        }
                        break;
                    case 4:
                        switch(button){
                            case 1:
                                out = "What are you scared of breaking the rules? Whatever the circus probably wasn’t cool anyway. You did learn some important stuff so what could a circus give you anyway. right?\nHP + 6\nMANA + 10";
                                text.setText(out);
                                player.MP = player.MP + 10;
                                player.HP = player.HP + 6;
                                break;
                            case 2:
                                statmain = learnrandomspell(elementaltype.Wild);
                                out = "So you’re a risk-taker then. The circus is everything you expected and more. Not only did you learn that eating cotton candy is the best but you also learned some magic from one of the clowns. It might not be trustworthy but hey. Spells are spells right\nYou Learned a Spell! (" + statmain + ") ";
                                text.setText(out);
                                break;
                            case 3:
                                out = "Well, you can at least say you tried. Turns out cheating takes a lot more time and effort than you expected. Not only did you miss the circus but you didn’t end up learning anything. The only thing you can say you gained is a spell to make an illusionary self so that you could pretend to be in class.\n You Learned a Spell! (Self illusion)\nMANA + 10";
                                text.setText(out);
                                learn.spell = spellz.selfillusion;
                                player.MP = player.MP + 10;
                                break;
                            case 4:
                                out = "The good news is you passed the class. You also got to enjoy the wonders of the circus. But because of your sleep deprivation, you didn’t get anything worthwhile from the circus outside of some defense lesions and ended up loosing some health from not getting any sleep. I’m sure it will be fine though. right?\nHP - 4\nDEF + 1\nMANA + 10";
                                text.setText(out);
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;
                                player.HP = player.HP - 4;
                                break;
                        }
                        break;
                    case 5:
                        switch(button){
                            case 1:
                                out = "Of Course. Everyone loves snowballs and the spell to create them is supper simple too. While you didn’t get first place third is nothing to scoff at." +
                                        "\nYou Learned a New Spell! (snowball)" +
                                        "\nHP + 6" +
                                        "\nDEF + 1" +
                                        "\nMANA + 10";
                                text.setText(out);
                                learn.spell = spellz.snowball;
                                player.HP = player.HP + 6;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;
                                break;
                            case 2:
                                statmain = learnrandomspell(player.maintype);
                                out = "Spending your time up next to a warm fire drinking hot coco and reading that five hundred page tomb you have been putting off. How else would you want to spend your break?\n" +
                                        "You Learned a New Spell ("+statmain+")\n" +
                                        "MANA + 20 \n";
                                player.MP = player.MP + 20;
                                text.setText(out);
                                break;
                            case 3:
                                statmain = learnrandomspell(elementaltype.Wild);
                                out = "New skills are always good to get even if it's to the detriment of your butt after all the tumbling. One day however as you were skating away the ice caves underneath you and you fell into the pond. It was cold. In Fact it was horbaly cold. It was a damaging cold. But while you were under there you did find some old scroll with ancient magic. Could be useful despite the frostbite.\n" +
                                        "You Learned a New Spell ("+statmain+")" +
                                        "\nHP - 4" +
                                        "\nDEF - 1";
                                player.HP = player.HP - 4;
                                player.DEF = player.DEF - 1;
                                text.setText(out);
                                break;
                            case 4:
                                out = "There is nothing like visiting your old home after so many years and the welcoming part was warm and joyful. You had a good winter break this year.\n" +
                                        "HP + 20\n" +
                                        "DEF + 1\n";
                                text.setText(out);
                                player.HP = player.HP + 20;
                                player.DEF = player.DEF + 1;

                                break;
                        }
                        break;
                    case 6:
                        switch(button){
                            case 1:
                                statmain = learnrandomspell(elementaltype.Null);
                                out = "You used this wild magic and tried to absorb information from it. While most of it was nonsense when the books energy died down you magicly new a new spell and felt magical energy surge thew you.\n" +
                                        "You Learned a New Spell ("+statmain+")\n" +
                                        "MANA + 20\n";
                                text.setText(out);
                                player.MP = player.MP + 20;
                                break;
                            case 2:
                                out = "You used this wild magic and channeled into your muscles and felt yourself become stronger and more huddy. When the books energy died down you found yourself with six pack you didn’t have before.\n" +
                                        "HP + 20\n" +
                                        "DEF + 2\n";
                                text.setText(out);
                                player.HP = player.HP + 20;
                                player.DEF = player.DEF + 2;
                                break;
                            case 3:
                                out = "You allowed the book to choose your fate and it choose that your fate was tied to it. When the books energy died down you could feel something deep down that you could call on when in need\n" +
                                        "You Learned a New Spell (Books Power)\n";
                                text.setText(out);
                                learn.spell = spellz.bookspower;
                                break;
                            case 4:
                                out = "You tried to resist the books effects and the book didn’t like your choice. Your not sure what happened but you woke up in the schools hospital seven days later from the incident\n" +
                                        "HP - 4\n";
                                text.setText(out);
                                player.HP = player.HP - 4;
                                break;
                        }
                        break;
                    case 7:
                        switch(button){
                            case 1:
                                out = "There is no time to lose. You quickly break into a sprint after the man and using your magic cause him to trip and hit his head. You quickly went for the coin pouch but couldn’t find it. Lucky the town guard was on your side as a known wizard in the town but you feel it could have gone better especially because you kinda scraped your knee in the chase.\n" +
                                        "HP - 4\n" +
                                        "DEF + 1\n" +
                                        "MANA + 10\n";
                                text.setText(out);
                                player.HP = player.HP - 4;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;
                                break;
                            case 2:
                                out = "You waste no time in calling for the guard and helping the girl. The town guard goes running after the man but they never return with the pouch. Maybe you should have tried going after him yourself.\n" +
                                        "HP + 8\n" +
                                        "DEF + 1\n";
                                text.setText(out);
                                player.HP = player.HP + 8;
                                player.DEF = player.DEF + 1;
                                break;
                            case 3:
                                out = "You quickly lost the man as he ran into a crowd and watched as guards stood still not quite figuring out what just happened. Knowing that he got away you feel bad for the girl and give her some of your coin as compensation. But she tells you that the coin pouch was a fake and gave you a copy of the spell on a scroll. Before you could thank her she was gone. How strange.\n" +
                                        "You Learned a New Spell (minor illusion)\n";
                                text.setText(out);
                                learn.spell = spellz.minorillusion;
                                break;
                            case 4:
                                out = "Not your problem you think and continue on your day.\n" +
                                        "HP + 6\n" +
                                        "DEF + 1\n" +
                                        "MANA + 10\n";
                                text.setText(out);
                                player.HP = player.HP + 6;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;;
                                break;
                        }
                        break;
                    case 8:
                        switch(button){
                            case 1:
                                out = "Potions are always a good time. While most of the class was just basics by the end you made a potion of giant’s strength and in the evening gotta use it on yourself. After that you just felt stronger\n" +
                                        "HP + 15\n" +
                                        "DEF + 1\n" +
                                        "MANA + 10\n";
                                text.setText(out);
                                player.HP = player.HP + 15;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;

                                break;
                            case 2:
                                statmain = learnrandomspell(elementaltype.Wild);
                                out = "Before this class you didn’t understand why wild magic existed. You still don’t but know you at least know it’s very dangerous. You learned a spell from the course but are you sure you want to use it?\n" +
                                        "You Learned a New Spell ("+statmain+")\n" +
                                        "MANA + 10\n";
                                player.MP = player.MP + 10;
                                text.setText(out);
                                break;
                            case 3:
                                out = "Griffins, Pixies, Wyverns. All wonderful creatures in kids story books that you got to meet in person and even feed a couple. This class was probably some of the most fun you have ever had. You also got a lot of scrapes and build up some armor. \n" +
                                        "HP - 4\n" +
                                        "DEF + 2\n";
                                text.setText(out);
                                player.DEF = player.DEF + 2;
                                player.HP = player.HP - 4;
                                break;
                            case 4:
                                statmain = learnrandomspell(elementaltype.Null);
                                out = "Going into your class selection with this attitude is how you get a class about the 1500 year history of wizards and get ultimately nothing. But you got lucky and got a class about the seasons and how the seasons can grant one magic. You enjoyed it quite a lot\n" +
                                        "You Learned a New Spell ("+statmain+")\n" +
                                        "HP + 6\n" +
                                        "MANA + 15\n";
                                text.setText(out);
                                player.MP = player.MP + 15;
                                player.HP = player.HP + 6;
                                break;
                        }
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        switch(button){
                            case 1:
                                out = "hp + 20";
                                text.setText(out);
                                player.HP = player.HP + 20;
                                break;
                            case 2:
                                out = "defense + 1";
                                text.setText(out);
                                player.DEF = player.DEF + 1;
                                break;
                            case 3:
                                statmain = learnrandomspell(elementaltype.Null);
                                out = "you leanred " + statmain;
                                text.setText(out);
                                break;
                            case 4:
                                out = "mana + 20";
                                text.setText(out);
                                player.MP = player.MP + 20;
                                break;
                        }
                        /*switch(button){
                            case 1:
                                statmain = learnrandomspell(elementaltype.Null);
                                out = "";
                                text.setText(out);
                                player.HP = player.HP + 10;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;
                                break;
                            case 2:
                                statmain = learnrandomspell(elementaltype.Wild);
                                out = "";
                                text.setText(out);
                                player.HP = player.HP + 10;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;
                                break;
                            case 3:
                                statmain = learnrandomspell(player.maintype);
                                out = "";
                                text.setText(out);
                                player.HP = player.HP + 10;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;;
                                break;
                            case 4:
                                out = "";
                                text.setText(out);
                                learn.spell = spellz.selfillusion;
                                player.HP = player.HP + 10;
                                player.DEF = player.DEF + 1;
                                player.MP = player.MP + 10;

                                break;
                        }*/
                        break;
                    case 17:
                        switch(button){
                            case 1:
                                stat4 = SetElement(option1,1);
                                learnspellsfromselected(option1,false);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")";
                                text.setText(out);
                                break;
                            case 2:
                                stat4 = SetElement(option2,1);
                                learnspellsfromselected(option2,false);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")";
                                text.setText(out);
                                break;
                            case 3:
                                stat4 = SetElement(option3,1);
                                learnspellsfromselected(option3,false);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")";
                                text.setText(out);
                                break;
                            case 4:
                                stat4 = SetElement(option4,1);
                                learnspellsfromselected(option4,false);
                                out = stat4 + "\nYou Learned a Spell! (" + stat1 + ")\nYou Learned a Spell! (" + stat2 + ")";
                                text.setText(out);
                                break;
                        }
                        canopenstats = true;
                        out = "stats";
                        bstats.setText(out);
                        statsbuttonisrandom = false;
                        break;
                }
                if(learn.spell != spellz.Null){
                    sendbundle();
                    System.out.println("error ldldldldldld");
                }
            }else{
                //random question
                questionsasked++;
                needanswer = true;
                switch(questionsasked){
                    case 1:
                        ran = Random(2,8);
                        saved1 = ran;
                        System.out.println(saved1 + " q1 q1");
                        break;
                    case 2:
                        ran = Random(2,8);
                        saved2 = ran;
                        if(saved1 == saved2){
                            while(saved1 == saved2){
                                ran = Random(2,8);
                                saved2 = ran;
                            }

                        }
                        System.out.println(saved2 + " q1 q2");
                        break;
                    case 3:
                        ran = Random(2,8);
                        saved3 = ran;
                        looper = 1;
                        while(looper == 1){
                            if(saved1 == saved3){
                                ran = Random(2,8);
                                saved3 = ran;
                            }else if(saved2 == saved3){
                                ran = Random(2,8);
                                saved3 = ran;
                            }else{
                                looper = 0;

                            }
                        }
                        System.out.println(saved3 + " q1 q3");
                        break;
                    case 4:
                        ran = 17;
                        System.out.println(ran);
                        System.out.println(ran + " halfway");
                        saved1 = 0;
                        saved2 = 0;
                        saved3 = 0;
                        break;
                    case 5:
                        ran = Random(2,8);
                        saved1 = ran;
                        System.out.println(saved1 + " q2 q1");
                        break;
                    case 6:
                        ran = Random(2,8);
                        saved2 = ran;
                        if(saved1 == saved2){
                            while(saved1 == saved2){
                                ran = Random(9,16);
                                saved2 = ran;
                            }
                        }
                        System.out.println(saved2 + " q2 q2");
                        break;
                    case 7:
                        ran = Random(2,8);
                        saved3 = ran;
                        looper = 1;
                        while(looper == 1){
                            if(saved1 == saved3){
                                ran = Random(9,16);
                                saved3 = ran;
                            }else if(saved2 == saved3){
                                ran = Random(9,16);
                                saved3 = ran;
                            }else{
                                looper = 0;
                            }
                        }
                        System.out.println(saved3 + " q2 q3");
                        break;
                    case 8:
                        //start new thing
                        ran = 0;
                        break;
                }
                switch(ran) {
                    case 2:
                        out = "Gym. a Wizard’s worst nightmare. Despite this gym, is very important for any good wizard and today is your first class. On top of the basics, you will have to choose one of the three paths you will focus on. Will you spend time riding magic broomsticks, playing portal ball, or perhaps the more nonmagical pushups and weights? You also heard that some of the other kids are skipping gym class to study some unknown spells. Who can say no to that right?";
                        text.setText(out);
                        out = "Broomsticks";
                        b1.setText(out);
                        out = "Portal Ball";
                        b2.setText(out);
                        out = "Hit the Rack";
                        b3.setText(out);
                        out = "Skip Class";
                        b4.setText(out);
                        currentquestion = 2;
                        break;
                    case 3:
                        out = "During some free time, you were wondering about the nearby city when you found a gemstone that you saw great magical potential in. you had to buy it. But now that you have it the question is what to do with it. Will you consume its magic to make your own stronger or perhaps you will use it to learn that spell you struggling with? I guess you could also craft a defensive magic item or potion with it as well. So many options, What will you choose?";
                        text.setText(out);
                        out = "Consume";
                        b1.setText(out);
                        out = "Learn a Spell";
                        b2.setText(out);
                        out = "Magic item";
                        b3.setText(out);
                        out = "Potion";
                        b4.setText(out);
                        currentquestion = 3;
                        break;
                    case 4:
                        out = "You find out about an upcoming circus that’s coming to town but some upcoming classes are slightly more difficult than normal. You quickie deduced that you can’t choose both. You did think about cheating to try to get past this difficult choice or maybe you could study instead of sleep. Who needs sleep right?";
                        text.setText(out);
                        out = "Skip the circus";
                        b1.setText(out);
                        out = "Enjoy the circus";
                        b2.setText(out);
                        out = "Try Cheating";
                        b3.setText(out);
                        out = "Study overnight";
                        b4.setText(out);
                        currentquestion = 4;
                        break;
                    case 5:
                        out = "Winter is a Wonderful time of year but one must always ask the question. What do I want to spend my winter break doing? Evening wizards in training have this question, so you came up with some ideas. The first is to spend this time learning to become the snowball king of the school in the annual snowball championship or you could take the time to catch up on your studies. You could also spend most of your time learning a new skill like ice skating or finally you could go visit your family for the holidays.";
                        text.setText(out);
                        out = "Snowball";
                        b1.setText(out);
                        out = "Studdy";
                        b2.setText(out);
                        out = "Ice skating";
                        b3.setText(out);
                        out = "Family";
                        b4.setText(out);
                        currentquestion = 5;
                        break;
                    case 6:
                        out = "One day while in the school's library you found a tomb of magic witch upon opening exploded into magic energy which forced its way into you. In that moment you had to choose how to channel that magic or be ripped apart from it.";
                        text.setText(out);
                        out = "Learn from it";
                        b1.setText(out);
                        out = "Gain Strength from it";
                        b2.setText(out);
                        out = "Become one with it";
                        b3.setText(out);
                        out = "Try to resist it";
                        b4.setText(out);
                        currentquestion = 6;
                        break;
                    case 7:
                        out = "While wandering around town one day you accidentally become a witness to an armed robbery as an older man stole a younger woman's coin pouch. In that moment you had to decide how you wanted to do. Will you become a vigilant savor or simply a witness.";
                        text.setText(out);
                        out = "Chase the evil doer";
                        b1.setText(out);
                        out = "Call for the town guard";
                        b2.setText(out);
                        out = "Give money to the girl";
                        b3.setText(out);
                        out = "Do nothing";
                        b4.setText(out);
                        currentquestion = 7;
                        break;
                    case 8:
                        out = "A class you wanted to take was removed from the potential options right before you got a chance to take it and now you're stuck deciding on a new class to fill it in. your options are as follows. You can take a standard potion class, a class about wild magic and how to deal with it, magic creature care, or you can take a random elemental course and see what you learn.";
                        text.setText(out);
                        out = "Potions 101";
                        b1.setText(out);
                        out = "Wild Magic";
                        b2.setText(out);
                        out = "Magic Creatures";
                        b3.setText(out);
                        out = "Random";
                        b4.setText(out);
                        currentquestion = 8;
                        break;
                    case 9:
                        out = "this is a test question9";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 9;
                        break;
                    case 10:
                        out = "this is a test question10";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 10;
                        break;
                    case 11:
                        out = "this is a test question11";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 11;
                        break;
                    case 12:
                        out = "this is a test question12";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 12;
                        break;
                    case 13:
                        out = "this is a test question13";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 13;
                        break;
                    case 14:
                        out = "this is a test question14";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 14;
                        break;
                    case 15:
                        out = "this is a test question15";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 15;
                        break;
                    case 16:
                        out = "this is a test question16";
                        text.setText(out);
                        out = "this increses HP";
                        b1.setText(out);
                        out = "this increses DEF";
                        b2.setText(out);
                        out = "this gives a spell";
                        b3.setText(out);
                        out = "this increses MP";
                        b4.setText(out);
                        currentquestion = 16;
                        break;
                    case 17:
                        out = "choose your sub element";
                        text.setText(out);

                        canopenstats = false;
                        out = "random";
                        bstats.setText(out);
                        statsbuttonisrandom = true;

                        currentquestion = 17;
                        option1 = Random(1,16);
                        option2 = Random(1,16);
                        option3 = Random(1,16);
                        option4 = Random(1,16);

                        switch(player.maintype){
                            case Fire:
                                saved1 = 1;
                                break;
                            case Ice:
                                saved1 = 2;
                                break;
                            case Oze:
                                saved1 = 3;
                                break;
                            case Water:
                                saved1 = 4;
                                break;
                            case Earth:
                                saved1 = 5;
                                break;
                            case Air:
                                saved1 = 6;
                                break;
                            case Life:
                                saved1 = 7;
                                break;
                            case Metal:
                                saved1 = 8;
                                break;
                            case Steam:
                                saved1 = 9;
                                break;
                            case Poison:
                                saved1 = 10;
                                break;
                            case Lightning:
                                saved1 = 11;
                                break;
                            case Sound:
                                saved1 = 12;
                                break;
                            case Soul:
                                saved1 = 13;
                                break;
                            case Light:
                                saved1 = 14;
                                break;
                            case Dark:
                                saved1 = 15;
                                break;
                            case Gravity:
                                saved1 = 16;
                                break;
                        }

                        looper = 0;
                        while(looper == 0){
                            if(saved1 == option1 || saved1 == option2 || saved1 == option3 || saved1 == option4){
                                option1 = Random(1,16);
                                option2 = Random(1,16);
                                option3 = Random(1,16);
                                option4 = Random(1,16);
                            }else if(option1 == option2 || option1 == option3 || option1 == option4){
                                option2 = Random(1,16);
                                option3 = Random(1,16);
                                option4 = Random(1,16);
                            }else if(option2 == option3 || option2 == option4){
                                option3 = Random(1,16);
                                option4 = Random(1,16);
                            }else if(option3 == option4){
                                option4 = Random(1,16);
                            }else{
                                looper = 1;
                                System.out.println(option1 + " " + option2 + " " + option3 + " " + option4);
                            }
                        }

                        SetButtonElement(option1, 1);
                        SetButtonElement(option2, 2);
                        SetButtonElement(option3, 3);
                        SetButtonElement(option4, 4);
                        break;
                    default:
                        battletime();
                        break;
                }
            }

        }
    }

    public void Gameend(){
        //reset player
        sendallbundle();
        player.HP = 10;
        player.DEF = 0;
        player.MP = 0;
        player.maintype = elementaltype.Null;
        player.subtype = elementaltype.Null;
        questionsasked = 0;
        gamestart = false;
        canopenstats = false;

        bstats.setText("");
        b1.setText("Press");
        b2.setText("Any");
        b3.setText("button");
        b4.setText("to start");

        out = "Welcome to Wizard Game Press any Button to Start";
        text.setText(out);
        learn.spell = spellz.Null;

        firelearned = 0;
        icelearned = 0;
        ozelearned = 0;
        waterlearned = 0;
        earthlearned = 0;
        airlearned = 0;
        lifelearned = 0;
        metallearned = 0;
        steamlearned = 0;
        poisonlearned = 0;
        lightninglearned = 0;
        soundlearned = 0;
        soullearned = 0;
        lightlearned = 0;
        darklearned = 0;
        gravitylearned = 0;

        wildorder[0] = 0;
        wildorder[1] = 0;
        wildorder[2] = 0;
        wildorder[3] = 0;
        wildorder[4] = 0;
        wildorder[5] = 0;
        wildorder[6] = 0;
        wildorder[7] = 0;

    }

    public int Random(int min, int max) {
        Random random = new Random();
        Integer randInt = random.nextInt((max - min) + 1) + min;
        System.out.println(randInt);

        return randInt;
    }

    public void SetButtonElement(int x, int y){
        String z;
        switch(x){
            case 1:
                z = "Fire";
                break;
            case 2:
                z = "Ice";
                break;
            case 3:
                z = "Oze";
                break;
            case 4:
                z = "Water";
                break;
            case 5:
                z = "Earth";
                break;
            case 6:
                z = "Air";
                break;
            case 7:
                z = "Life";
                break;
            case 8:
                z = "Metal";
                break;
            case 9:
                z = "Steam";
                break;
            case 10:
                z = "Poison";
                break;
            case 11:
                z = "Lightning";
                break;
            case 12:
                z = "Sound";
                break;
            case 13:
                z = "Soul";
                break;
            case 14:
                z = "Light";
                break;
            case 15:
                z = "Dark";
                break;
            case 16:
                z = "Gravity";
                break;
            default:
                z = "null";
                break;
        }
        switch(y){
            case 1:
                b1.setText(z);
                break;
            case 2:
                b2.setText(z);
                break;
            case 3:
                b3.setText(z);
                break;
            case 4:
                b4.setText(z);
                break;
        }
    }
    public String SetElement(int type, int mainorsub) {
        String out = "";
        ran = Random(1, 3);
        System.out.println(ran + " 1-2-3 flavor");
        player.MP = player.MP + 20;
        switch (type) {
            case 1:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Fire;
                }else{
                    player.subtype = elementaltype.Fire;
                }
                player.HP = player.HP + 10;
                player.DEF = player.DEF + 1;
                switch(ran){
                    case 1:
                        out = "So you picked Fire.";
                        break;
                    case 2:
                        out = "Fire you picked";
                        break;
                    case 3:
                        out = "wow many Fire";
                        break;
                }
                break;
            case 2:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Ice;
                }else{
                    player.subtype = elementaltype.Ice;
                }
                player.HP = player.HP + 10;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Ice.";
                        break;
                    case 2:
                        out = "Ice you picked";
                        break;
                    case 3:
                        out = "wow many Ice";
                        break;
                }
                break;
            case 3:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Oze;
                }else{
                    player.subtype = elementaltype.Oze;
                }
                player.HP = player.HP + 8;
                player.DEF = player.DEF + 2;
                switch(ran){
                    case 1:
                        out = "So you picked Oze.";
                        break;
                    case 2:
                        out = "Oze you picked.";
                        break;
                    case 3:
                        out = "wow many Oze.";
                        break;
                }
                break;
            case 4:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Water;
                }else{
                    player.subtype = elementaltype.Water;
                }
                player.HP = player.HP + 8;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Water.";
                        break;
                    case 2:
                        out = "Water you picked.";
                        break;
                    case 3:
                        out = "wow many Water.";
                        break;
                }
                break;
            case 5:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Earth;
                }else{
                    player.subtype = elementaltype.Earth;
                }
                player.HP = player.HP + 12;
                player.DEF = player.DEF + 2;
                switch(ran){
                    case 1:
                        out = "So you picked Earth.";
                        break;
                    case 2:
                        out = "Earth you picked.";
                        break;
                    case 3:
                        out = "wow many Earth.";
                        break;
                }
                break;
            case 6:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Air;
                }else{
                    player.subtype = elementaltype.Air;
                }
                player.HP = player.HP + 10;
                player.DEF = player.DEF + 2;
                switch(ran){
                    case 1:
                        out = "So you picked Air.";
                        break;
                    case 2:
                        out = "Air you picked.";
                        break;
                    case 3:
                        out = "wow many Air.";
                        break;
                }
                break;
            case 7:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Life;
                }else{
                    player.subtype = elementaltype.Life;
                }
                player.HP = player.HP + 12;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Life.";
                        break;
                    case 2:
                        out = "Life you picked.";
                        break;
                    case 3:
                        out = "wow many Life.";
                        break;
                }
                break;
            case 8:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Metal;
                }else{
                    player.subtype = elementaltype.Metal;
                }
                player.HP = player.HP + 12;
                player.DEF = player.DEF + 2;
                switch(ran){
                    case 1:
                        out = "So you picked Metal.";
                        break;
                    case 2:
                        out = "Metal you picked.";
                        break;
                    case 3:
                        out = "wow many Metal.";
                        break;
                }
                break;
            case 9:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Steam;
                }else{
                    player.subtype = elementaltype.Steam;
                }
                player.HP = player.HP + 8;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Steam.";
                        break;
                    case 2:
                        out = "Steam you picked.";
                        break;
                    case 3:
                        out = "wow many Steam.";
                        break;
                }
                break;
            case 10:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Poison;
                }else{
                    player.subtype = elementaltype.Poison;
                }
                player.HP = player.HP + 8;
                player.DEF = player.DEF + 1;
                switch(ran){
                    case 1:
                        out = "So you picked Poison.";
                        break;
                    case 2:
                        out = "Poison you picked.";
                        break;
                    case 3:
                        out = "wow many Poison.";
                        break;
                }
                break;
            case 11:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Lightning;
                }else{
                    player.subtype = elementaltype.Lightning;
                }
                player.HP = player.HP + 10;
                player.DEF = player.DEF + 1;
                switch(ran){
                    case 1:
                        out = "So you picked Lightning.";
                        break;
                    case 2:
                        out = "Lightning you picked.";
                        break;
                    case 3:
                        out = "wow many Lightning.";
                        break;
                }
                break;
            case 12:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Sound;
                }else{
                    player.subtype = elementaltype.Sound;
                }
                player.HP = player.HP + 10;
                player.DEF = player.DEF + 2;
                switch(ran){
                    case 1:
                        out = "So you picked Sound.";
                        break;
                    case 2:
                        out = "Sound you picked.";
                        break;
                    case 3:
                        out = "wow many Sound.";
                        break;
                }
                break;
            case 13:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Soul;
                }else{
                    player.subtype = elementaltype.Soul;
                }
                player.HP = player.HP + 8;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Soul.";
                        break;
                    case 2:
                        out = "Soul you picked.";
                        break;
                    case 3:
                        out = "wow many Soul.";
                        break;
                }
                break;
            case 14:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Light;
                }else{
                    player.subtype = elementaltype.Light;
                }
                player.HP = player.HP + 8;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Light.";
                        break;
                    case 2:
                        out = "Light you picked.";
                        break;
                    case 3:
                        out = "wow many Light.";
                        break;
                }
                break;
            case 15:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Dark;
                }else{
                    player.subtype = elementaltype.Dark;
                }
                player.HP = player.HP + 12;
                player.DEF = player.DEF + 0;
                switch(ran){
                    case 1:
                        out = "So you picked Dark.";
                        break;
                    case 2:
                        out = "Dark you picked.";
                        break;
                    case 3:
                        out = "wow many Dark.";
                        break;
                }
                break;
            case 16:
                if(mainorsub == 0) {
                    player.maintype = elementaltype.Gravity;
                }else{
                    player.subtype = elementaltype.Gravity;
                }
                player.HP = player.HP + 12;
                player.DEF = player.DEF + 1;
                switch(ran){
                    case 1:
                        out = "So you picked Gravity.";
                        break;
                    case 2:
                        out = "Gravity you picked.";
                        break;
                    case 3:
                        out = "wow many Gravity.";
                        break;
                }
                break;
            default:
                gamestart = true;
                System.out.println("error no element found restarting game");
                out = "Something has gone wrong... game is restarting";
                Gameend();
                break;
        }
        return out;
    }

    Spells learn = new Spells();
    public void learnspellsfromselected(int type, boolean mainorsub){
        switch(type){
            case 1:
                stat1 = learnrandomspell(elementaltype.Fire);
                stat2 = learnrandomspell(elementaltype.Fire);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Fire);
                }
                break;
            case 2:
                stat1 = learnrandomspell(elementaltype.Ice);
                stat2 = learnrandomspell(elementaltype.Ice);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Ice);
                }
                break;
            case 3:
                stat1 = learnrandomspell(elementaltype.Oze);
                stat2 = learnrandomspell(elementaltype.Oze);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Oze);
                }
                break;
            case 4:
                stat1 = learnrandomspell(elementaltype.Water);
                stat2 = learnrandomspell(elementaltype.Water);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Water);
                }
                break;
            case 5:
                stat1 = learnrandomspell(elementaltype.Earth);
                stat2 = learnrandomspell(elementaltype.Earth);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Earth);
                }
                break;
            case 6:
                stat1 = learnrandomspell(elementaltype.Air);
                stat2 = learnrandomspell(elementaltype.Air);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Air);
                }
                break;
            case 7:
                stat1 = learnrandomspell(elementaltype.Life);
                stat2 = learnrandomspell(elementaltype.Life);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Life);
                }
                break;
            case 8:
                stat1 = learnrandomspell(elementaltype.Metal);
                stat2 = learnrandomspell(elementaltype.Metal);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Metal);
                }
                break;
            case 9:
                stat1 = learnrandomspell(elementaltype.Steam);
                stat2 = learnrandomspell(elementaltype.Steam);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Steam);
                }
                break;
            case 10:
                stat1 = learnrandomspell(elementaltype.Poison);
                stat2 = learnrandomspell(elementaltype.Poison);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Poison);
                }
                break;
            case 11:
                stat1 = learnrandomspell(elementaltype.Lightning);
                stat2 = learnrandomspell(elementaltype.Lightning);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Lightning);
                }
                break;
            case 12:
                stat1 = learnrandomspell(elementaltype.Sound);
                stat2 = learnrandomspell(elementaltype.Sound);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Sound);
                }
                break;
            case 13:
                stat1 = learnrandomspell(elementaltype.Soul);
                stat2 = learnrandomspell(elementaltype.Soul);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Soul);
                }
                break;
            case 14:
                stat1 = learnrandomspell(elementaltype.Light);
                stat2 = learnrandomspell(elementaltype.Light);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Light);
                }
                break;
            case 15:
                stat1 = learnrandomspell(elementaltype.Dark);
                stat2 = learnrandomspell(elementaltype.Dark);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Dark);
                }
                break;
            case 16:
                stat1 = learnrandomspell(elementaltype.Gravity);
                stat2 = learnrandomspell(elementaltype.Gravity);
                if(mainorsub == true){
                    stat3 = learnrandomspell(elementaltype.Gravity);
                }
                break;
        }
    }
    public String learnrandomspell(elementaltype given){
        switch(given){
            case Fire:
                if(firelearned == 0) {
                    firelearned = Random(1, 12);
                    System.out.println(firelearned + " firelearned");
                }
                switch(firelearned) {
                    case 1:
                        out = "Fire Bolt";
                        learn.spell = spellz.firebolt;
                        firelearned++;
                        break;
                    case 2:
                        out = "Fireball";
                        learn.spell = spellz.fireball;
                        firelearned++;
                        break;
                    case 3:
                        out = "Create Bonfire";
                        learn.spell = spellz.createbonfire;
                        firelearned++;
                        break;
                    case 4:
                        out = "Fire Shield";
                        learn.spell = spellz.fireshield;
                        firelearned++;
                        break;
                    case 5:
                        out = "Crimson Rose";
                        learn.spell = spellz.crimsonrose;
                        firelearned++;
                        break;
                    case 6:
                        out = "Investiture of Heat";
                        learn.spell = spellz.investitureofheat;
                        firelearned = 1;
                        break;
                    case 7:
                        out = "Fire Bolt";
                        learn.spell = spellz.firebolt;
                        firelearned = 12;
                        break;
                    case 8:
                        out = "Fireball";
                        learn.spell = spellz.fireball;
                        firelearned--;
                        break;
                    case 9:
                        out = "Create Bonfire";
                        learn.spell = spellz.createbonfire;
                        firelearned--;
                        break;
                    case 10:
                        out = "Fire Shield";
                        learn.spell = spellz.fireshield;
                        firelearned--;
                        break;
                    case 11:
                        out = "Crimson Rose";
                        learn.spell = spellz.crimsonrose;
                        firelearned--;
                        break;
                    case 12:
                        out = "Investiture of Heat";
                        learn.spell = spellz.investitureofheat;
                        firelearned--;
                        break;
                }
                break;
            case Ice:
                if(icelearned == 0) {
                    icelearned = Random(1, 12);
                    System.out.println(icelearned + " icelearned");
                }
                switch(icelearned){
                    case 1:
                        out = "Ice Knife";
                        learn.spell = spellz.iceknife;
                        icelearned++;
                        break;
                    case 2:
                        out = "Frostbite";
                        learn.spell = spellz.frostbite;
                        icelearned++;
                        break;
                    case 3:
                        out = "Investiture of Cold";
                        learn.spell = spellz.investitureofcold;
                        icelearned++;
                        break;
                    case 4:
                        out = "Wall of Ice";
                        learn.spell = spellz.wallofice;
                        icelearned++;
                        break;
                    case 5:
                        out = "Ice Storm";
                        learn.spell = spellz.icestorm;
                        icelearned++;
                        break;
                    case 6:
                        out = "Cone of Cold";
                        learn.spell = spellz.coneofcold;
                        icelearned = 1;
                        break;
                    case 7:
                        out = "Ice Knife";
                        learn.spell = spellz.iceknife;
                        icelearned = 12;
                        break;
                    case 8:
                        out = "Frostbite";
                        learn.spell = spellz.frostbite;
                        icelearned--;
                        break;
                    case 9:
                        out = "Investiture of Cold";
                        learn.spell = spellz.investitureofcold;
                        icelearned--;
                        break;
                    case 10:
                        out = "Wall of Ice";
                        learn.spell = spellz.wallofice;
                        icelearned--;
                        break;
                    case 11:
                        out = "Ice Storm";
                        learn.spell = spellz.icestorm;
                        icelearned--;
                        break;
                    case 12:
                        out = "Cone of Cold";
                        learn.spell = spellz.coneofcold;
                        icelearned--;
                        break;
                }
                break;
            case Oze:
                if(ozelearned == 0) {
                    ozelearned = Random(1, 12);
                    System.out.println(ozelearned + " ozelearned");
                }
                switch(ozelearned){
                    case 1:
                        out = "Acid Arrow";
                        learn.spell = spellz.acidarrow;
                        ozelearned++;
                        break;
                    case 2:
                        out = "Acid Splash";
                        learn.spell = spellz.acidsplash;
                        ozelearned++;
                        break;
                    case 3:
                        out = "Summon Slime";
                        learn.spell = spellz.summonslime;
                        ozelearned++;
                        break;
                    case 4:
                        out = "Absorb Elements";
                        learn.spell = spellz.absorbelements;
                        ozelearned++;
                        break;
                    case 5:
                        out = "Hunger";
                        learn.spell = spellz.hunger;
                        ozelearned++;
                        break;
                    case 6:
                        out = "Clone";
                        learn.spell = spellz.clone;
                        ozelearned = 1;
                        break;
                    case 7:
                        out = "Acid Arrow";
                        learn.spell = spellz.acidarrow;
                        ozelearned = 12;
                        break;
                    case 8:
                        out = "Acid Splash";
                        learn.spell = spellz.acidsplash;
                        ozelearned--;
                        break;
                    case 9:
                        out = "Summon Slime";
                        learn.spell = spellz.summonslime;
                        ozelearned--;
                        break;
                    case 10:
                        out = "Absorb Elements";
                        learn.spell = spellz.absorbelements;
                        ozelearned--;
                        break;
                    case 11:
                        out = "Hunger";
                        learn.spell = spellz.hunger;
                        ozelearned--;
                        break;
                    case 12:
                        out = "Clone";
                        learn.spell = spellz.clone;
                        ozelearned--;
                        break;
                }
                break;
            case Water:
                if(waterlearned == 0) {
                    waterlearned = Random(1, 12);
                    System.out.println(waterlearned + " waterlearned");
                }
                switch(waterlearned){
                    case 1:
                        out = "Control Water";
                        learn.spell = spellz.controlwater;
                        waterlearned++;
                        break;
                    case 2:
                        out = "Splash";
                        learn.spell = spellz.splash;
                        waterlearned++;
                        break;
                    case 3:
                        out = "Rain";
                        learn.spell = spellz.rain;
                        waterlearned++;
                        break;
                    case 4:
                        out = "Bubble Refresher";
                        learn.spell = spellz.bubblerefresher;
                        waterlearned++;
                        break;
                    case 5:
                        out = "Tsunami";
                        learn.spell = spellz.tsunami;
                        waterlearned++;
                        break;
                    case 6:
                        out = "Wall of Water";
                        learn.spell = spellz.wallofwater;
                        waterlearned = 1;
                        break;
                    case 7:
                        out = "Control Water";
                        learn.spell = spellz.controlwater;
                        waterlearned = 12;
                        break;
                    case 8:
                        out = "Splash";
                        learn.spell = spellz.splash;
                        waterlearned--;
                        break;
                    case 9:
                        out = "Rain";
                        learn.spell = spellz.rain;
                        waterlearned--;
                        break;
                    case 10:
                        out = "Bubble Refresher";
                        learn.spell = spellz.bubblerefresher;
                        waterlearned--;
                        break;
                    case 11:
                        out = "Tsunami";
                        learn.spell = spellz.tsunami;
                        waterlearned--;
                        break;
                    case 12:
                        out = "Wall of Water";
                        learn.spell = spellz.wallofwater;
                        waterlearned--;
                        break;
                }
                break;
            case Earth:
                if(earthlearned == 0) {
                    earthlearned = Random(1, 12);
                    System.out.println(earthlearned + " earthlearned");
                }
                switch(earthlearned){
                    case 1:
                        out = "Investiture of Stone";
                        learn.spell = spellz.investitureofstone;
                        earthlearned++;
                        break;
                    case 2:
                        out = "Stoneskin";
                        learn.spell = spellz.stoneskin;
                        earthlearned++;
                        break;
                    case 3:
                        out = "Earth Tremor";
                        learn.spell = spellz.earthtremor;
                        earthlearned++;
                        break;
                    case 4:
                        out = "Guardian of Stone";
                        learn.spell = spellz.guardianofstone;
                        earthlearned++;
                        break;
                    case 5:
                        out = "Wall of Stone";
                        learn.spell = spellz.wallofstone;
                        earthlearned++;
                        break;
                    case 6:
                        out = "Stone Prison";
                        learn.spell = spellz.stoneprison;
                        earthlearned = 1;
                        break;
                    case 7:
                        out = "Investiture of Stone";
                        learn.spell = spellz.investitureofstone;
                        earthlearned = 12;
                        break;
                    case 8:
                        out = "Stoneskin";
                        learn.spell = spellz.stoneskin;
                        earthlearned--;
                        break;
                    case 9:
                        out = "Earth Tremor";
                        learn.spell = spellz.earthtremor;
                        earthlearned--;
                        break;
                    case 10:
                        out = "Guardian of Stone";
                        learn.spell = spellz.guardianofstone;
                        earthlearned--;
                        break;
                    case 11:
                        out = "Wall of Stone";
                        learn.spell = spellz.wallofstone;
                        earthlearned--;
                        break;
                    case 12:
                        out = "Stone Prison";
                        learn.spell = spellz.stoneprison;
                        earthlearned--;
                        break;
                }
                break;
            case Air:
                if(airlearned == 0) {
                    airlearned = Random(1, 12);
                    System.out.println(airlearned + " airlearned");
                }
                switch(airlearned){
                    case 1:
                        out = "Catapult";
                        learn.spell = spellz.catapult;
                        airlearned++;
                        break;
                    case 2:
                        out = "Control Winds";
                        learn.spell = spellz.controlwinds;
                        airlearned++;
                        break;
                    case 3:
                        out = "Investiture of Winds";
                        learn.spell = spellz.investitureofwinds;
                        airlearned++;
                        break;
                    case 4:
                        out = "Gust";
                        learn.spell = spellz.gust;
                        airlearned++;
                        break;
                    case 5:
                        out = "Wind Strike";
                        learn.spell = spellz.windstrike;
                        airlearned++;
                        break;
                    case 6:
                        out = "Whirlwind";
                        learn.spell = spellz.whirlwind;
                        airlearned = 1;
                        break;
                    case 7:
                        out = "Catapult";
                        learn.spell = spellz.catapult;
                        airlearned = 12;
                        break;
                    case 8:
                        out = "Control Winds";
                        learn.spell = spellz.controlwinds;
                        airlearned--;
                        break;
                    case 9:
                        out = "Investiture of Winds";
                        learn.spell = spellz.investitureofwinds;
                        airlearned--;
                        break;
                    case 10:
                        out = "Gust";
                        learn.spell = spellz.gust;
                        airlearned--;
                        break;
                    case 11:
                        out = "Wind Strike";
                        learn.spell = spellz.windstrike;
                        airlearned--;
                        break;
                    case 12:
                        out = "Whirlwind";
                        learn.spell = spellz.whirlwind;
                        airlearned--;
                        break;
                }
                break;
            case Life:
                if(lifelearned == 0) {
                    lifelearned = Random(1, 12);
                    System.out.println(lifelearned + " lifelearned");
                }
                switch(lifelearned){
                    case 1:
                        out = "barkskin";
                        learn.spell = spellz.barkskin;
                        lifelearned++;
                        break;
                    case 2:
                        out = "summonent";
                        learn.spell = spellz.summonent;
                        lifelearned++;
                        break;
                    case 3:
                        out = "enlarge";
                        learn.spell = spellz.enlarge;
                        lifelearned++;
                        break;
                    case 4:
                        out = "graspingvine";
                        learn.spell = spellz.graspingvine;
                        lifelearned++;
                        break;
                    case 5:
                        out = "guardianofnature";
                        learn.spell = spellz.guardianofnature;
                        lifelearned++;
                        break;
                    case 6:
                        out = "thornwhip";
                        learn.spell = spellz.thornwhip;
                        lifelearned = 1;
                        break;
                    case 7:
                        out = "barkskin";
                        learn.spell = spellz.barkskin;
                        lifelearned = 12;
                        break;
                    case 8:
                        out = "summonent";
                        learn.spell = spellz.summonent;
                        lifelearned--;
                        break;
                    case 9:
                        out = "enlarge";
                        learn.spell = spellz.enlarge;
                        lifelearned--;
                        break;
                    case 10:
                        out = "graspingvine";
                        learn.spell = spellz.graspingvine;
                        lifelearned--;
                        break;
                    case 11:
                        out = "guardianofnature";
                        learn.spell = spellz.guardianofnature;
                        lifelearned--;
                        break;
                    case 12:
                        out = "thornwhip";
                        learn.spell = spellz.thornwhip;
                        lifelearned--;
                        break;
                }
                break;
            case Metal:
                if(metallearned == 0) {
                    metallearned = Random(1, 12);
                    System.out.println(metallearned + " metallearned");
                }
                switch(metallearned){
                    case 1:
                        out = "Investiture of Iron";
                        learn.spell = spellz.investitureofiron;
                        metallearned++;
                        break;
                    case 2:
                        out = "Heat Metal";
                        learn.spell = spellz.heatmetal;
                        metallearned++;
                        break;
                    case 3:
                        out = "Guardian of Steel";
                        learn.spell = spellz.guardianofsteel;
                        metallearned++;
                        break;
                    case 4:
                        out = "Spike Shot";
                        learn.spell = spellz.spikeshot;
                        metallearned++;
                        break;
                    case 5:
                        out = "Summon Magic Sword";
                        learn.spell = spellz.summonmagicsword;
                        metallearned++;
                        break;
                    case 6:
                        out = "Iron Maiden";
                        learn.spell = spellz.ironmaiden;
                        metallearned = 1;
                        break;
                    case 7:
                        out = "Investiture of Iron";
                        learn.spell = spellz.investitureofiron;
                        metallearned = 12;
                        break;
                    case 8:
                        out = "Heat Metal";
                        learn.spell = spellz.heatmetal;
                        metallearned--;
                        break;
                    case 9:
                        out = "Guardian of Steel";
                        learn.spell = spellz.guardianofsteel;
                        metallearned--;
                        break;
                    case 10:
                        out = "Spike Shot";
                        learn.spell = spellz.spikeshot;
                        metallearned--;
                        break;
                    case 11:
                        out = "Summon Magic Sword";
                        learn.spell = spellz.summonmagicsword;
                        metallearned--;
                        break;
                    case 12:
                        out = "Iron Maiden";
                        learn.spell = spellz.ironmaiden;
                        metallearned--;
                        break;
                }
                break;
            case Steam:
                if(steamlearned == 0) {
                    steamlearned = Random(1, 12);
                    System.out.println(steamlearned + " steamlearned");
                }
                switch(steamlearned){
                    case 1:
                        out = "Blur";
                        learn.spell = spellz.blur;
                        steamlearned++;
                        break;
                    case 2:
                        out = "Investiture of Fog";
                        learn.spell = spellz.investitureoffog;
                        steamlearned++;
                        break;
                    case 3:
                        out = "Fog Cloud";
                        learn.spell = spellz.fogcloud;
                        steamlearned++;
                        break;
                    case 4:
                        out = "Gaseous Form";
                        learn.spell = spellz.gaseousform;
                        steamlearned++;
                        break;
                    case 5:
                        out = "Sleep";
                        learn.spell = spellz.sleep;
                        steamlearned++;
                        break;
                    case 6:
                        out = "Cloud Kill";
                        learn.spell = spellz.cloudkill;
                        steamlearned = 1;
                        break;
                    case 7:
                        out = "Blur";
                        learn.spell = spellz.blur;
                        steamlearned = 12;
                        break;
                    case 8:
                        out = "Investiture of Fog";
                        learn.spell = spellz.investitureoffog;
                        steamlearned--;
                        break;
                    case 9:
                        out = "Fog Cloud";
                        learn.spell = spellz.fogcloud;
                        steamlearned--;
                        break;
                    case 10:
                        out = "Gaseous Form";
                        learn.spell = spellz.gaseousform;
                        steamlearned--;
                        break;
                    case 11:
                        out = "Sleep";
                        learn.spell = spellz.sleep;
                        steamlearned--;
                        break;
                    case 12:
                        out = "Cloud Kill";
                        learn.spell = spellz.cloudkill;
                        steamlearned--;
                        break;
                }
                break;
            case Poison:
                if(poisonlearned == 0) {
                    poisonlearned = Random(1, 12);
                    System.out.println(poisonlearned + " poisonlearned");
                }
                switch(poisonlearned){
                    case 1:
                        out = "Fear";
                        learn.spell = spellz.fear;
                        poisonlearned++;
                        break;
                    case 2:
                        out = "Poison Spray";
                        learn.spell = spellz.poisonspray;
                        poisonlearned++;
                        break;
                    case 3:
                        out = "Sickening Radiance";
                        learn.spell = spellz.sickeningradiance;
                        poisonlearned++;
                        break;
                    case 4:
                        out = "Poison Cloud";
                        learn.spell = spellz.poisoncloud;
                        poisonlearned++;
                        break;
                    case 5:
                        out = "Tipped Thorn Armor";
                        learn.spell = spellz.tipedthornarmor;
                        poisonlearned++;
                        break;
                    case 6:
                        out = "Corruption";
                        learn.spell = spellz.corruption;
                        poisonlearned = 1;
                        break;
                    case 7:
                        out = "Fear";
                        learn.spell = spellz.fear;
                        poisonlearned = 12;
                        break;
                    case 8:
                        out = "Poison Spray";
                        learn.spell = spellz.poisonspray;
                        poisonlearned--;
                        break;
                    case 9:
                        out = "Sickening Radiance";
                        learn.spell = spellz.sickeningradiance;
                        poisonlearned--;
                        break;
                    case 10:
                        out = "Poison Cloud";
                        learn.spell = spellz.poisoncloud;
                        poisonlearned--;
                        break;
                    case 11:
                        out = "Tipped Thorn Armor";
                        learn.spell = spellz.tipedthornarmor;
                        poisonlearned--;
                        break;
                    case 12:
                        out = "Corruption";
                        learn.spell = spellz.corruption;
                        poisonlearned--;
                        break;
                }
                break;
            case Lightning:
                if(lightninglearned == 0) {
                    lightninglearned = Random(1, 12);
                    System.out.println(lightninglearned + " lightninglearned");
                }
                switch(lightninglearned){
                    case 1:
                        out = "Chain Lightning";
                        learn.spell = spellz.chainlightning;
                        lightninglearned++;
                        break;
                    case 2:
                        out = "Lightning Bolt";
                        learn.spell = spellz.lightningbolt;
                        lightninglearned++;
                        break;
                    case 3:
                        out = "Guardian of Thunder";
                        learn.spell = spellz.guardianofthunder;
                        lightninglearned++;
                        break;
                    case 4:
                        out = "Summon Storm";
                        learn.spell = spellz.summonstorm;
                        lightninglearned++;
                        break;
                    case 5:
                        out = "Thunder Clap";
                        learn.spell = spellz.thunderclap;
                        lightninglearned++;
                        break;
                    case 6:
                        out = "Thunder Step";
                        learn.spell = spellz.thunderstep;
                        lightninglearned = 1;
                        break;
                    case 7:
                        out = "Chain Lightning";
                        learn.spell = spellz.chainlightning;
                        lightninglearned = 12;
                        break;
                    case 8:
                        out = "Lightning Bolt";
                        learn.spell = spellz.lightningbolt;
                        lightninglearned--;
                        break;
                    case 9:
                        out = "Guardian of Thunder";
                        learn.spell = spellz.guardianofthunder;
                        lightninglearned--;
                        break;
                    case 10:
                        out = "Summon Storm";
                        learn.spell = spellz.summonstorm;
                        lightninglearned--;
                        break;
                    case 11:
                        out = "Thunder Clap";
                        learn.spell = spellz.thunderclap;
                        lightninglearned--;
                        break;
                    case 12:
                        out = "Thunder Step";
                        learn.spell = spellz.thunderstep;
                        lightninglearned--;
                        break;
                }
                break;
            case Sound:
                if(soundlearned == 0) {
                    soundlearned = Random(1, 12);
                    System.out.println(soundlearned + " soundlearned");
                }
                switch(soundlearned){
                    case 1:
                        out = "Healing Word";
                        learn.spell = spellz.healingword;
                        soundlearned++;
                        break;
                    case 2:
                        out = "Charm";
                        learn.spell = spellz.charm;
                        soundlearned++;
                        break;
                    case 3:
                        out = "Command";
                        learn.spell = spellz.command;
                        soundlearned++;
                        break;
                    case 4:
                        out = "Dissonant Whispers";
                        learn.spell = spellz.dissonantwhispers;
                        soundlearned++;
                        break;
                    case 5:
                        out = "Power Word Kill";
                        learn.spell = spellz.powerwordkill;
                        soundlearned++;
                        break;
                    case 6:
                        out = "Power Word Stun";
                        learn.spell = spellz.powerwordstun;
                        soundlearned = 1;
                        break;
                    case 7:
                        out = "Healing Word";
                        learn.spell = spellz.healingword;
                        soundlearned = 12;
                        break;
                    case 8:
                        out = "Charm";
                        learn.spell = spellz.charm;
                        soundlearned--;
                        break;
                    case 9:
                        out = "Command";
                        learn.spell = spellz.command;
                        soundlearned--;
                        break;
                    case 10:
                        out = "Dissonant Whispers";
                        learn.spell = spellz.dissonantwhispers;
                        soundlearned--;
                        break;
                    case 11:
                        out = "Power Word Kill";
                        learn.spell = spellz.powerwordkill;
                        soundlearned--;
                        break;
                    case 12:
                        out = "Power Word Stun";
                        learn.spell = spellz.powerwordstun;
                        soundlearned--;
                        break;
                }
                break;
            case Soul:
                if(soullearned == 0) {
                    soullearned = Random(1, 12);
                    System.out.println(soullearned + " soullearned");
                }
                switch(soullearned){
                    case 1:
                        out = "Astral Projection";
                        learn.spell = spellz.astralprojection;
                        soullearned++;
                        break;
                    case 2:
                        out = "Death Ward";
                        learn.spell = spellz.deathward;
                        soullearned++;
                        break;
                    case 3:
                        out = "Dream";
                        learn.spell = spellz.dream;
                        soullearned++;
                        break;
                    case 4:
                        out = "Guardian of Dream";
                        learn.spell = spellz.guardianofdream;
                        soullearned++;
                        break;
                    case 5:
                        out = "Healing Spirit";
                        learn.spell = spellz.healingspirit;
                        soullearned++;
                        break;
                    case 6:
                        out = "Phantasmal Killer";
                        learn.spell = spellz.phantasmalkiller;
                        soullearned = 1;
                        break;
                    case 7:
                        out = "Astral Projection";
                        learn.spell = spellz.astralprojection;
                        soullearned = 12;
                        break;
                    case 8:
                        out = "Death Ward";
                        learn.spell = spellz.deathward;
                        soullearned--;
                        break;
                    case 9:
                        out = "Dream";
                        learn.spell = spellz.dream;
                        soullearned--;
                        break;
                    case 10:
                        out = "Guardian of Dream";
                        learn.spell = spellz.guardianofdream;
                        soullearned--;
                        break;
                    case 11:
                        out = "Healing Spirit";
                        learn.spell = spellz.healingspirit;
                        soullearned--;
                        break;
                    case 12:
                        out = "Phantasmal Killer";
                        learn.spell = spellz.phantasmalkiller;
                        soullearned--;
                        break;
                }
                break;
            case Light:
                if(lightlearned == 0) {
                    lightlearned = Random(1, 12);
                    System.out.println(lightlearned + " lightlearned");
                }
                switch(lightlearned){
                    case 1:
                        out = "Dawn";
                        learn.spell = spellz.dawn;
                        lightlearned++;
                        break;
                    case 2:
                        out = "Heal";
                        learn.spell = spellz.heal;
                        lightlearned++;
                        break;
                    case 3:
                        out = "Day Light";
                        learn.spell = spellz.daylight;
                        lightlearned++;
                        break;
                    case 4:
                        out = "Investiture of Sun";
                        learn.spell = spellz.investitureofsun;
                        lightlearned++;
                        break;
                    case 5:
                        out = "Guardian of Light";
                        learn.spell = spellz.guardianoflight;
                        lightlearned++;
                        break;
                    case 6:
                        out = "Sunbeam";
                        learn.spell = spellz.sunbeam;
                        lightlearned = 1;
                        break;
                    case 7:
                        out = "Dawn";
                        learn.spell = spellz.dawn;
                        lightlearned = 12;
                        break;
                    case 8:
                        out = "Heal";
                        learn.spell = spellz.heal;
                        lightlearned--;
                        break;
                    case 9:
                        out = "Day Light";
                        learn.spell = spellz.daylight;
                        lightlearned--;
                        break;
                    case 10:
                        out = "Investiture of Sun";
                        learn.spell = spellz.investitureofsun;
                        lightlearned--;
                        break;
                    case 11:
                        out = "Guardian of Light";
                        learn.spell = spellz.guardianoflight;
                        lightlearned--;
                        break;
                    case 12:
                        out = "Sunbeam";
                        learn.spell = spellz.sunbeam;
                        lightlearned--;
                        break;
                }
                break;
            case Dark:
                if(darklearned == 0) {
                    darklearned = Random(1, 12);
                    System.out.println(darklearned + " darklearned");
                }
                switch(darklearned){
                    case 1:
                        out = "Shadow Arms";
                        learn.spell = spellz.shadowarms;
                        darklearned++;
                        break;
                    case 2:
                        out = "Summon Shadow";
                        learn.spell = spellz.summonshadow;
                        darklearned++;
                        break;
                    case 3:
                        out = "Investiture of Moon";
                        learn.spell = spellz.investitureofmoon;
                        darklearned++;
                        break;
                    case 4:
                        out = "Moonbeam";
                        learn.spell = spellz.moonbeam;
                        darklearned++;
                        break;
                    case 5:
                        out = "Eldritch Blast";
                        learn.spell = spellz.eldritchblast;
                        darklearned++;
                        break;
                    case 6:
                        out = "Darkness";
                        learn.spell = spellz.darkness;
                        darklearned = 1;
                        break;
                    case 7:
                        out = "Shadow Arms";
                        learn.spell = spellz.shadowarms;
                        darklearned = 12;
                        break;
                    case 8:
                        out = "Summon Shadow";
                        learn.spell = spellz.summonshadow;
                        darklearned--;
                        break;
                    case 9:
                        out = "Investiture of Moon";
                        learn.spell = spellz.investitureofmoon;
                        darklearned--;
                        break;
                    case 10:
                        out = "Moonbeam";
                        learn.spell = spellz.moonbeam;
                        darklearned--;
                        break;
                    case 11:
                        out = "Eldritch Blast";
                        learn.spell = spellz.eldritchblast;
                        darklearned--;
                        break;
                    case 12:
                        out = "Darkness";
                        learn.spell = spellz.darkness;
                        darklearned--;
                        break;
                }
                break;
            case Gravity:
                if(gravitylearned == 0) {
                    gravitylearned = Random(1, 12);
                    System.out.println(gravitylearned + " gravitylearned");
                }
                switch(gravitylearned){
                    case 1:
                        out = "Dark Star";
                        learn.spell = spellz.darkstar;
                        gravitylearned++;
                        break;
                    case 2:
                        out = "Force Wave";
                        learn.spell = spellz.forcewave;
                        gravitylearned++;
                        break;
                    case 3:
                        out = "Wall of Force";
                        learn.spell = spellz.wallofforce;
                        gravitylearned++;
                        break;
                    case 4:
                        out = "Gravity Fissure";
                        learn.spell = spellz.gravityfissure;
                        gravitylearned++;
                        break;
                    case 5:
                        out = "Magic Missile";
                        learn.spell = spellz.magicmissile;
                        gravitylearned++;
                        break;
                    case 6:
                        out = "Magnify Gravity";
                        learn.spell = spellz.magnifygravity;
                        gravitylearned = 1;
                        break;
                    case 7:
                        out = "Dark Star";
                        learn.spell = spellz.darkstar;
                        gravitylearned = 12;
                        break;
                    case 8:
                        out = "Force Wave";
                        learn.spell = spellz.forcewave;
                        gravitylearned--;
                        break;
                    case 9:
                        out = "Wall of Force";
                        learn.spell = spellz.wallofforce;
                        gravitylearned--;
                        break;
                    case 10:
                        out = "Gravity Fissure";
                        learn.spell = spellz.gravityfissure;
                        gravitylearned--;
                        break;
                    case 11:
                        out = "Magic Missile";
                        learn.spell = spellz.magicmissile;
                        gravitylearned--;
                        break;
                    case 12:
                        out = "Magnify Gravity";
                        learn.spell = spellz.magnifygravity;
                        gravitylearned--;
                        break;
                }
                break;
            case Wild:
                looper = 0;
                while(looper == 0) {
                    wildlearned = Random(1, 8);
                    System.out.println(wildlearned + " wildlearned");
                    switch (wildlearned) {
                        case 1:
                            if(wildorder[1] == 0) {
                                out = "Chaos Bolt";
                                learn.spell = spellz.chaosbolt;
                                wildorder[1] = 1;
                                looper = 1;
                            }
                            break;
                        case 2:
                            if(wildorder[2] == 0) {
                                out = "Summon Elemental";
                                learn.spell = spellz.summonelemental;
                                wildorder[2] = 1;
                                looper = 1;
                            }
                            break;
                        case 3:
                            if(wildorder[3] == 0) {
                                out = "Investiture of Chaos";
                                learn.spell = spellz.investitureofchaos;
                                wildorder[3] = 1;
                                looper = 1;
                            }
                            break;
                        case 4:
                            if(wildorder[4] == 0) {
                                out = "Chromatic Blast";
                                learn.spell = spellz.chromaticblast;
                                wildorder[4] = 1;
                                looper = 1;
                            }
                            break;
                        case 5:
                            if(wildorder[5] == 0) {
                                out = "Coin Flip";
                                learn.spell = spellz.coinflip;
                                wildorder[5] = 1;
                                looper = 1;
                            }
                            break;
                        case 6:
                            if(wildorder[6] == 0) {
                                out = "Create Anti";
                                learn.spell = spellz.createanti;
                                wildorder[6] = 1;
                                looper = 1;
                            }
                            break;
                        case 7:
                            if(wildorder[7] == 0) {
                                out = "Create Void";
                                learn.spell = spellz.createvoid;
                                wildorder[7] = 1;
                                looper = 1;
                            }
                            break;
                        case 8:
                            if(wildorder[0] == 0) {
                                out = "Create Artha";
                                learn.spell = spellz.createartha;
                                wildorder[0] = 1;
                                looper = 1;
                            }
                            break;
                    }
                }
                break;
            case Null:
                ran = Random(1,16);
                System.out.println(ran + " wild element slection");
                switch(player.maintype){
                    case Fire:
                        saved1 = 1;
                        break;
                    case Ice:
                        saved1 = 2;
                        break;
                    case Oze:
                        saved1 = 3;
                        break;
                    case Water:
                        saved1 = 4;
                        break;
                    case Earth:
                        saved1 = 5;
                        break;
                    case Air:
                        saved1 = 6;
                        break;
                    case Life:
                        saved1 = 7;
                        break;
                    case Metal:
                        saved1 = 8;
                        break;
                    case Steam:
                        saved1 = 9;
                        break;
                    case Poison:
                        saved1 = 10;
                        break;
                    case Lightning:
                        saved1 = 11;
                        break;
                    case Sound:
                        saved1 = 12;
                        break;
                    case Soul:
                        saved1 = 13;
                        break;
                    case Light:
                        saved1 = 14;
                        break;
                    case Dark:
                        saved1 = 15;
                        break;
                    case Gravity:
                        saved1 = 16;
                        break;
                }
                switch(player.subtype){
                    case Fire:
                        saved2 = 1;
                        break;
                    case Ice:
                        saved2 = 2;
                        break;
                    case Oze:
                        saved2 = 3;
                        break;
                    case Water:
                        saved2 = 4;
                        break;
                    case Earth:
                        saved2 = 5;
                        break;
                    case Air:
                        saved2 = 6;
                        break;
                    case Life:
                        saved2 = 7;
                        break;
                    case Metal:
                        saved2 = 8;
                        break;
                    case Steam:
                        saved2 = 9;
                        break;
                    case Poison:
                        saved2 = 10;
                        break;
                    case Lightning:
                        saved2 = 11;
                        break;
                    case Sound:
                        saved2 = 12;
                        break;
                    case Soul:
                        saved2 = 13;
                        break;
                    case Light:
                        saved2 = 14;
                        break;
                    case Dark:
                        saved2 = 15;
                        break;
                    case Gravity:
                        saved2 = 16;
                        break;
                    case Null:
                        saved2 = 0;
                        break;
                }

                looper = 0;
                while(looper == 0) {
                    if (ran == saved1 || ran == saved2) {
                        ran = Random(1, 16);
                    }else{
                        looper = 1;
                    }
                }
                System.out.println(ran + " wild element slection final");

                switch(ran){
                    case 1:
                        learnrandomspell(elementaltype.Fire);
                        break;
                    case 2:
                        learnrandomspell(elementaltype.Ice);
                        break;
                    case 3:
                        learnrandomspell(elementaltype.Oze);
                        break;
                    case 4:
                        learnrandomspell(elementaltype.Water);
                        break;
                    case 5:
                        learnrandomspell(elementaltype.Earth);
                        break;
                    case 6:
                        learnrandomspell(elementaltype.Air);
                        break;
                    case 7:
                        learnrandomspell(elementaltype.Life);
                        break;
                    case 8:
                        learnrandomspell(elementaltype.Metal);
                        break;
                    case 9:
                        learnrandomspell(elementaltype.Steam);
                        break;
                    case 10:
                        learnrandomspell(elementaltype.Poison);
                        break;
                    case 11:
                        learnrandomspell(elementaltype.Lightning);
                        break;
                    case 12:
                        learnrandomspell(elementaltype.Sound);
                        break;
                    case 13:
                        learnrandomspell(elementaltype.Soul);
                        break;
                    case 14:
                        learnrandomspell(elementaltype.Light);
                        break;
                    case 15:
                        learnrandomspell(elementaltype.Dark);
                        break;
                    case 16:
                        learnrandomspell(elementaltype.Gravity);
                        break;
                }

                break;
        }
        sendbundle();
        return out;
    }
    public void sendallbundle(){
        int send = 0;
        Intent i = new Intent(this, activity_battle.class);

        bundle.putInt("Story01", send);
        bundle.putInt("Story02", send);
        bundle.putInt("Story03", send);
        bundle.putInt("Story04", send);
        bundle.putInt("Story05", send);
        bundle.putInt("Story06", send);
        bundle.putInt("Story11", send);
        bundle.putInt("Story12", send);
        bundle.putInt("Story13", send);
        bundle.putInt("Story14", send);
        bundle.putInt("Story15", send);
        bundle.putInt("Story16", send);
        bundle.putInt("Fire1", send);
        bundle.putInt("Fire2", send);
        bundle.putInt("Fire3", send);
        bundle.putInt("Fire4", send);
        bundle.putInt("Fire5", send);
        bundle.putInt("Fire6", send);
        bundle.putInt("Ice1", send);
        bundle.putInt("Ice2", send);
        bundle.putInt("Ice3", send);
        bundle.putInt("Ice4", send);
        bundle.putInt("Ice5", send);
        bundle.putInt("Ice6", send);
        bundle.putInt("Oze1", send);
        bundle.putInt("Oze2", send);
        bundle.putInt("Oze3", send);
        bundle.putInt("Oze4", send);
        bundle.putInt("Oze5", send);
        bundle.putInt("Oze6", send);
        bundle.putInt("Water1", send);
        bundle.putInt("Water3", send);
        bundle.putInt("Water3", send);
        bundle.putInt("Water4", send);
        bundle.putInt("Water5", send);
        bundle.putInt("Water6", send);
        bundle.putInt("Earth1", send);
        bundle.putInt("Earth2", send);
        bundle.putInt("Earth3", send);
        bundle.putInt("Earth4", send);
        bundle.putInt("Earth5", send);
        bundle.putInt("Earth6", send);
        bundle.putInt("Air1", send);
        bundle.putInt("Air2", send);
        bundle.putInt("Air3", send);
        bundle.putInt("Air4", send);
        bundle.putInt("Air5", send);
        bundle.putInt("Air6", send);
        bundle.putInt("Life1", send);
        bundle.putInt("Life2", send);
        bundle.putInt("Life3", send);
        bundle.putInt("Life4", send);
        bundle.putInt("Life5", send);
        bundle.putInt("Life6", send);
        bundle.putInt("Metal1", send);
        bundle.putInt("Metal2", send);
        bundle.putInt("Metal3", send);
        bundle.putInt("Metal4", send);
        bundle.putInt("Metal5", send);
        bundle.putInt("Metal6", send);
        bundle.putInt("Steam1", send);
        bundle.putInt("Steam2", send);
        bundle.putInt("Steam3", send);
        bundle.putInt("Steam4", send);
        bundle.putInt("Steam5", send);
        bundle.putInt("Steam6", send);
        bundle.putInt("Poison1", send);
        bundle.putInt("Poison2", send);
        bundle.putInt("Poison3", send);
        bundle.putInt("Poison4", send);
        bundle.putInt("Poison5", send);
        bundle.putInt("Poison6", send);
        bundle.putInt("Lightning1", send);
        bundle.putInt("Lightning2", send);
        bundle.putInt("Lightning3", send);
        bundle.putInt("Lightning4", send);
        bundle.putInt("Lightning5", send);
        bundle.putInt("Lightning6", send);
        bundle.putInt("Sound1", send);
        bundle.putInt("Sound2", send);
        bundle.putInt("Sound3", send);
        bundle.putInt("Sound4", send);
        bundle.putInt("Sound5", send);
        bundle.putInt("Sound6", send);
        bundle.putInt("Sou1", send);
        bundle.putInt("Sou2", send);
        bundle.putInt("Sou3", send);
        bundle.putInt("Sou4", send);
        bundle.putInt("Sou5", send);
        bundle.putInt("Sou6", send);
        bundle.putInt("Light1", send);
        bundle.putInt("Light2", send);
        bundle.putInt("Light3", send);
        bundle.putInt("Light4", send);
        bundle.putInt("Light5", send);
        bundle.putInt("Light6", send);
        bundle.putInt("Dark1", send);
        bundle.putInt("Dark2", send);
        bundle.putInt("Dark3", send);
        bundle.putInt("Dark4", send);
        bundle.putInt("Dark5", send);
        bundle.putInt("Dark6", send);
        bundle.putInt("Gravity1", send);
        bundle.putInt("Gravity2", send);
        bundle.putInt("Gravity3", send);
        bundle.putInt("Gravity4", send);
        bundle.putInt("Gravity5", send);
        bundle.putInt("Gravity6", send);
        bundle.putInt("Wild1", send);
        bundle.putInt("Wild2", send);
        bundle.putInt("Wild3", send);
        bundle.putInt("Wild4", send);
        bundle.putInt("Wild5", send);
        bundle.putInt("Wild6", send);
        bundle.putInt("Wild7", send);
        bundle.putInt("Wild8", send);

        i.putExtras(bundle);

    }
    public void sendbundle(){
        int send = 1;
        Intent i = new Intent(this, activity_battle.class);
        switch(learn.spell){
            //Story
            case portal:
                bundle.putInt("Story01", send);
                break;
            case broom:
                bundle.putInt("Story02", send);
                break;
            case selfillusion:
                bundle.putInt("Story03", send);
                break;
            case snowball:
                bundle.putInt("Story04", send);
                break;
            case bookspower:
                bundle.putInt("Story05", send);
                break;
            case minorillusion:
                bundle.putInt("Story06", send);
                break;
            case placeholder11:
                bundle.putInt("Story11", send);
                break;
            case placeholder12:
                bundle.putInt("Story12", send);
                break;
            case placeholder13:
                bundle.putInt("Story13", send);
                break;
            case placeholder14:
                bundle.putInt("Story14", send);
                break;
            case placeholder15:
                bundle.putInt("Story15", send);
                break;
            case placeholder16:
                bundle.putInt("Story16", send);
                break;
            //fire
            case firebolt:
                bundle.putInt("Fire1", send);
                break;
            case fireball:
                bundle.putInt("Fire2", send);
                break;
            case createbonfire:
                bundle.putInt("Fire3", send);
                break;
            case fireshield:
                bundle.putInt("Fire4", send);
                break;
            case crimsonrose:
                bundle.putInt("Fire5", send);
                break;
            case investitureofheat:
                bundle.putInt("Fire6", send);
                break;
            //ice
            case iceknife:
                bundle.putInt("Ice1", send);
                break;
            case frostbite:
                bundle.putInt("Ice2", send);
                break;
            case investitureofcold:
                bundle.putInt("Ice3", send);
                break;
            case wallofice:
                bundle.putInt("Ice4", send);
                break;
            case icestorm:
                bundle.putInt("Ice5", send);
                break;
            case coneofcold:
                bundle.putInt("Ice6", send);
                break;
            //oze
            case acidarrow:
                bundle.putInt("Oze1", send);
                break;
            case acidsplash:
                bundle.putInt("Oze2", send);
                break;
            case summonslime:
                bundle.putInt("Oze3", send);
                break;
            case absorbelements:
                bundle.putInt("Oze4", send);
                break;
            case hunger:
                bundle.putInt("Oze5", send);
                break;
            case clone:
                bundle.putInt("Oze6", send);
                break;
            //water
            case controlwater:
                bundle.putInt("Water1", send);
                break;
            case splash:
                bundle.putInt("Water2", send);
                break;
            case rain:
                bundle.putInt("Water3", send);
                break;
            case bubblerefresher:
                bundle.putInt("Water4", send);
                break;
            case tsunami:
                bundle.putInt("Water5", send);
                break;
            case wallofwater:
                bundle.putInt("Water6", send);
                break;
            //earth
            case investitureofstone:
                bundle.putInt("Earth1", send);
                break;
            case stoneskin:
                bundle.putInt("Earth2", send);
                break;
            case earthtremor:
                bundle.putInt("Earth3", send);
                break;
            case guardianofstone:
                bundle.putInt("Earth4", send);
                break;
            case wallofstone:
                bundle.putInt("Earth5", send);
                break;
            case stoneprison:
                bundle.putInt("Earth6", send);
                break;
            //air
            case catapult:
                bundle.putInt("Air1", send);
                break;
            case controlwinds:
                bundle.putInt("Air2", send);
                break;
            case investitureofwinds:
                bundle.putInt("Air3", send);
                break;
            case gust:
                bundle.putInt("Air4", send);
                break;
            case windstrike:
                bundle.putInt("Air5", send);
                break;
            case whirlwind:
                bundle.putInt("Air6", send);
                break;
            //life
            case barkskin:
                bundle.putInt("Life1", send);
                break;
            case summonent:
                bundle.putInt("Life2", send);
                break;
            case enlarge:
                bundle.putInt("Life3", send);
                break;
            case graspingvine:
                bundle.putInt("Life4", send);
                break;
            case guardianofnature:
                bundle.putInt("Life5", send);
                break;
            case thornwhip:
                bundle.putInt("Life6", send);
                break;
            //metal
            case investitureofiron:
                bundle.putInt("Metal1", send);
                break;
            case heatmetal:
                bundle.putInt("Metal2", send);
                break;
            case guardianofsteel:
                bundle.putInt("Metal3", send);
                break;
            case spikeshot:
                bundle.putInt("Metal4", send);
                break;
            case summonmagicsword:
                bundle.putInt("Metal5", send);
                break;
            case ironmaiden:
                bundle.putInt("Metal6", send);
                break;
            //steam
            case blur:
                bundle.putInt("Steam1", send);
                break;
            case investitureoffog:
                bundle.putInt("Steam2", send);
                break;
            case fogcloud:
                bundle.putInt("Steam3", send);
                break;
            case gaseousform:
                bundle.putInt("Steam4", send);
                break;
            case sleep:
                bundle.putInt("Steam5", send);
                break;
            case cloudkill:
                bundle.putInt("Steam6", send);
                break;
            //poison
            case fear:
                bundle.putInt("Poison1", send);
                break;
            case poisonspray:
                bundle.putInt("Poison2", send);
                break;
            case sickeningradiance:
                bundle.putInt("Poison3", send);
                break;
            case poisoncloud:
                bundle.putInt("Poison4", send);
                break;
            case tipedthornarmor:
                bundle.putInt("Poison5", send);
                break;
            case corruption:
                bundle.putInt("Poison6", send);
                break;
            //lightning
            case chainlightning:
                bundle.putInt("Lightning1", send);
                break;
            case lightningbolt:
                bundle.putInt("Lightning2", send);
                break;
            case guardianofthunder:
                bundle.putInt("Lightning3", send);
                break;
            case summonstorm:
                bundle.putInt("Lightning4", send);
                break;
            case thunderclap:
                bundle.putInt("Lightning5", send);
                break;
            case thunderstep:
                bundle.putInt("Lightning6", send);
                break;
            //sound
            case healingword:
                bundle.putInt("Sound1", send);
                break;
            case charm:
                bundle.putInt("Sound2", send);
                break;
            case command:
                bundle.putInt("Sound3", send);
                break;
            case dissonantwhispers:
                bundle.putInt("Sound4", send);
                break;
            case powerwordkill:
                bundle.putInt("Sound5", send);
                break;
            case powerwordstun:
                bundle.putInt("Sound6", send);
                break;
            //soul
            case astralprojection:
                bundle.putInt("Soul1", send);
                break;
            case deathward:
                bundle.putInt("Soul2", send);
                break;
            case dream:
                bundle.putInt("Soul3", send);
                break;
            case guardianofdream:
                bundle.putInt("Soul4", send);
                break;
            case healingspirit:
                bundle.putInt("Soul5", send);
                break;
            case phantasmalkiller:
                bundle.putInt("Soul6", send);
                break;
            //light
            case dawn:
                bundle.putInt("Light1", send);
                break;
            case heal:
                bundle.putInt("Light2", send);
                break;
            case daylight:
                bundle.putInt("Light3", send);
                break;
            case investitureofsun:
                bundle.putInt("Light4", send);
                break;
            case guardianoflight:
                bundle.putInt("Light5", send);
                break;
            case sunbeam:
                bundle.putInt("Light6", send);
                break;
            //dark
            case shadowarms:
                bundle.putInt("Dark1", send);
                break;
            case summonshadow:
                bundle.putInt("Dark2", send);
                break;
            case investitureofmoon:
                bundle.putInt("Dark3", send);
                break;
            case moonbeam:
                bundle.putInt("Dark4", send);
                break;
            case eldritchblast:
                bundle.putInt("Dark5", send);
                break;
            case darkness:
                bundle.putInt("Dark6", send);
                break;
            //gravity
            case darkstar:
                bundle.putInt("Gravity1", send);
                break;
            case forcewave:
                bundle.putInt("Gravity2", send);
                break;
            case wallofforce:
                bundle.putInt("Gravity3", send);
                break;
            case gravityfissure:
                bundle.putInt("Gravity4", send);
                break;
            case magicmissile:
                bundle.putInt("Gravity5", send);
                break;
            case magnifygravity:
                bundle.putInt("Gravity6", send);
                break;
            //wild
            case chaosbolt:
                bundle.putInt("Wild1", send);
                break;
            case summonelemental:
                bundle.putInt("Wild2", send);
                break;
            case investitureofchaos:
                bundle.putInt("Wild3", send);
                break;
            case chromaticblast:
                bundle.putInt("Wild4", send);
                break;
            case coinflip:
                bundle.putInt("Wild5", send);
                break;
            case createanti:
                bundle.putInt("Wild6", send);
                break;
            case createvoid:
                bundle.putInt("Wild7", send);
                break;
            case createartha:
                bundle.putInt("Wild8", send);
                break;

            default:
                System.out.println("error dldldldldldl");
                break;
        }
        learn.spell = spellz.Null;
    }
}


///start of battle activity -----------------------------------------------------------------<_<_<_<_<_<_<_<_<<_<_<_<_<_<_<__<
//<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<__<_<_<_<_<
//<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<__<_<_<_<_<
//<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<__<_<_<_<_<
//<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<__<_<_<_<_<
//<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<_<__<_<_<_<_<
package com.example.wizardgame;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import java.util.Random;

public class activity_battle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        inveiw();
        onstart();
        System.out.println(knownspelltotal + " you know this many spells");
    }
    public void inveiw(){
        //todo
        main = findViewById(R.id.maintxt);
        title = findViewById(R.id.titletxt);
        health = findViewById(R.id.hptxt);
        defence = findViewById(R.id.deftxt);
        mana = findViewById(R.id.manatxt);

        bnext = (Button)findViewById(R.id.nextbtn);
        bsll = (Button)findViewById(R.id.yourspellsbtn);
        bdef = (Button)findViewById(R.id.defendbtn);
        bmix = (Button)findViewById(R.id.mixbtn);
        breg = (Button)findViewById(R.id.rechargebtn);

        b1 = (Button)findViewById(R.id.spell1btn);
        b2 = (Button)findViewById(R.id.spell2btn);
        b3 = (Button)findViewById(R.id.spell3btn);
        b4 = (Button)findViewById(R.id.spell4btn);
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    TextView main, title, health, defence, mana;
    Button bnext,bdef,bmix,breg,bsll,b1,b2,b3,b4;
    boolean buttonson;
    boolean inbattle;
    boolean instats;
    boolean restart;
    String out;
    String playersout;
    String monstersout;
    String saved1;
    String saved2;
    String saved3;
    String saved4;
    String saved5;
    String saved6;
    String saved7;
    int holder;
    int button;
    int spell1;
    int spell2;
    int spell3;
    int spell4;
    int looper;
    int adventureprogress;

    //stats
    int HPMax;
    int ManaMax;
    int DEFMax;

    //the spell chaos
    Spells spellbeingcast = new Spells();
    Spells knownspell1 = new Spells();
    Spells knownspell2 = new Spells();
    Spells knownspell3 = new Spells();
    Spells knownspell4 = new Spells();
    Spells knownspell5 = new Spells();
    Spells knownspell6 = new Spells();
    Spells knownspell7 = new Spells();
    Spells knownspell8 = new Spells();
    Spells knownspell9 = new Spells();
    Spells knownspell10 = new Spells();
    Spells knownspell11 = new Spells();
    String[] spellstrings = new String[]{"1","2","3","4","5","6","7","8","9","10","11",};
    int knownspelltotal;
    String spellknown;

    int firebonus, icebonus, ozebonus, waterbonus, earthbonus, airbonus, lifebonus, metalbonus;
    int steambonus, poisonbonus, lightningbonus, soundbonus, soulbonus, lightbonus, darkbonus, gravitybonus;

    Spells learn = new Spells();
    Wizard player = new Wizard();
    Wizard baddy = new Wizard();
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public void onstart(){
        buttonson = false;
        inbattle = false;
        instats = false;
        restart = false;

        Intent i = new Intent(this, MainActivity.class);
        Bundle bundle = getIntent().getExtras();

        spellknown = "";
        playersout = "";
        monstersout = "";

        //bundles in point //todo
        HPMax = bundle.getInt("hp");
        ManaMax = bundle.getInt("mp");
        DEFMax = bundle.getInt("def");

        saved1 = Integer.toString(HPMax);
        out = "Heath: " + HPMax + "/" + HPMax;
        health.setText(out);
        saved1 = Integer.toString(DEFMax);
        out = "Defence: " + DEFMax;
        defence.setText(out);
        saved1 = Integer.toString(HPMax);
        out = "Mana: " + ManaMax + "/" + ManaMax;
        mana.setText(out);

        firebonus = 0;
        icebonus = 0;
        ozebonus = 0;
        waterbonus = 0;
        earthbonus = 0;
        airbonus = 0;
        lifebonus = 0;
        metalbonus = 0;
        steambonus = 0;
        poisonbonus = 0;
        lightningbonus = 0;
        soundbonus = 0;
        soulbonus = 0;
        lightbonus = 0;
        darkbonus = 0;
        gravitybonus = 0;

        player.HP = HPMax;
        player.DEF = DEFMax;
        player.MP = ManaMax;
        player.maintype = elementaltype.Null;

        out = "Start Your Adventure";
        bnext.setText(out);
        out = "Graduation";
        title.setText(out);
        out = "Congratulations! You have graduated School without dieing. Now that you're a real wizard though it's time for you to start monster hunting. That said you will likely die if you didn’t get through school with flying colors. I wish you luck on your adventure.";
        main.setText(out);

        out = "";
        bdef.setText(out);
        bmix.setText(out);
        breg.setText(out);
        b1.setText(out);
        b2.setText(out);
        b3.setText(out);
        b4.setText(out);

        out = "Start Your Adventure";
        bnext.setText(out);

        adventureprogress = 0;

        //spell time :(
        knownspell1.spell = spellz.Null;
        knownspell2.spell = spellz.Null;
        knownspell3.spell = spellz.Null;
        knownspell4.spell = spellz.Null;
        knownspell5.spell = spellz.Null;
        knownspell6.spell = spellz.Null;
        knownspell7.spell = spellz.Null;
        knownspell8.spell = spellz.Null;
        knownspell9.spell = spellz.Null;
        knownspell10.spell = spellz.Null;
        knownspell11.spell = spellz.Null;
        knownspelltotal = 0;

        int findallofthespells = 0;
        if(findallofthespells == 0) {
            holder = bundle.getInt("Story01");
            if (holder == 1) {
                setspelltoknown(1, 1);
            }
            holder = bundle.getInt("Story02");
            if (holder == 1) {
                setspelltoknown(1, 2);
            }
            holder = bundle.getInt("Story03");
            if (holder == 1) {
                setspelltoknown(1, 3);
            }
            holder = bundle.getInt("Story04");
            if (holder == 1) {
                setspelltoknown(1, 4);
            }
            holder = bundle.getInt("Story05");
            if (holder == 1) {
                setspelltoknown(1, 5);
            }
            holder = bundle.getInt("Story06");
            if (holder == 1) {
                setspelltoknown(1, 6);
            }
            holder = bundle.getInt("Story11");
            if (holder == 1) {
                setspelltoknown(1, 11);
            }
            holder = bundle.getInt("Story12");
            if (holder == 1) {
                setspelltoknown(1, 12);
            }
            holder = bundle.getInt("Story13");
            if (holder == 1) {
                setspelltoknown(1, 13);
            }
            holder = bundle.getInt("Story14");
            if (holder == 1) {
                setspelltoknown(1, 14);
            }
            holder = bundle.getInt("Story15");
            if (holder == 1) {
                setspelltoknown(1, 15);
            }
            holder = bundle.getInt("Story16");
            if (holder == 1) {
                setspelltoknown(1, 16);
            }

            holder = bundle.getInt("Fire1");
            if (holder == 1) {
                setspelltoknown(2, 1);
            }
            holder = bundle.getInt("Fire2");
            if (holder == 1) {
                setspelltoknown(2, 2);
            }
            holder = bundle.getInt("Fire3");
            if (holder == 1) {
                setspelltoknown(2, 3);
            }
            holder = bundle.getInt("Fire4");
            if (holder == 1) {
                setspelltoknown(2, 4);
            }
            holder = bundle.getInt("Fire5");
            if (holder == 1) {
                setspelltoknown(2, 5);
            }
            holder = bundle.getInt("Fire6");
            if (holder == 1) {
                setspelltoknown(2, 6);
            }

            holder = bundle.getInt("Ice1");
            if (holder == 1) {
                setspelltoknown(3, 1);
            }
            holder = bundle.getInt("Ice2");
            if (holder == 1) {
                setspelltoknown(3, 2);
            }
            holder = bundle.getInt("Ice3");
            if (holder == 1) {
                setspelltoknown(3, 3);
            }
            holder = bundle.getInt("Ice4");
            if (holder == 1) {
                setspelltoknown(3, 4);
            }
            holder = bundle.getInt("Ice5");
            if (holder == 1) {
                setspelltoknown(3, 5);
            }
            holder = bundle.getInt("Ice6");
            if (holder == 1) {
                setspelltoknown(3, 6);
            }

            holder = bundle.getInt("Oze1");
            if (holder == 1) {
                setspelltoknown(4, 1);
            }
            holder = bundle.getInt("Oze2");
            if (holder == 1) {
                setspelltoknown(4, 2);
            }
            holder = bundle.getInt("Oze3");
            if (holder == 1) {
                setspelltoknown(4, 3);
            }
            holder = bundle.getInt("Oze4");
            if (holder == 1) {
                setspelltoknown(4, 4);
            }
            holder = bundle.getInt("Oze5");
            if (holder == 1) {
                setspelltoknown(4, 5);
            }
            holder = bundle.getInt("Oze6");
            if (holder == 1) {
                setspelltoknown(4, 6);
            }

            holder = bundle.getInt("Water1");
            if (holder == 1) {
                setspelltoknown(5, 1);
            }
            holder = bundle.getInt("Water2");
            if (holder == 1) {
                setspelltoknown(5, 2);
            }
            holder = bundle.getInt("Water3");
            if (holder == 1) {
                setspelltoknown(5, 3);
            }
            holder = bundle.getInt("Water4");
            if (holder == 1) {
                setspelltoknown(5, 4);
            }
            holder = bundle.getInt("Water5");
            if (holder == 1) {
                setspelltoknown(5, 5);
            }
            holder = bundle.getInt("Water6");
            if (holder == 1) {
                setspelltoknown(5, 6);
            }

            holder = bundle.getInt("Earth1");
            if (holder == 1) {
                setspelltoknown(6, 1);
            }
            holder = bundle.getInt("Earth2");
            if (holder == 1) {
                setspelltoknown(6, 2);
            }
            holder = bundle.getInt("Earth3");
            if (holder == 1) {
                setspelltoknown(6, 3);
            }
            holder = bundle.getInt("Earth4");
            if (holder == 1) {
                setspelltoknown(6, 4);
            }
            holder = bundle.getInt("Earth5");
            if (holder == 1) {
                setspelltoknown(6, 5);
            }
            holder = bundle.getInt("Earth6");
            if (holder == 1) {
                setspelltoknown(6, 6);
            }

            holder = bundle.getInt("Air1");
            if (holder == 1) {
                setspelltoknown(7, 1);
            }
            holder = bundle.getInt("Air2");
            if (holder == 1) {
                setspelltoknown(7, 2);
            }
            holder = bundle.getInt("Air3");
            if (holder == 1) {
                setspelltoknown(7, 3);
            }
            holder = bundle.getInt("Air4");
            if (holder == 1) {
                setspelltoknown(7, 4);
            }
            holder = bundle.getInt("Air5");
            if (holder == 1) {
                setspelltoknown(7, 5);
            }
            holder = bundle.getInt("Air6");
            if (holder == 1) {
                setspelltoknown(7, 6);
            }

            holder = bundle.getInt("Life1");
            if (holder == 1) {
                setspelltoknown(8, 1);
            }
            holder = bundle.getInt("Life2");
            if (holder == 1) {
                setspelltoknown(8, 2);
            }
            holder = bundle.getInt("Life3");
            if (holder == 1) {
                setspelltoknown(8, 3);
            }
            holder = bundle.getInt("Life4");
            if (holder == 1) {
                setspelltoknown(8, 4);
            }
            holder = bundle.getInt("Life5");
            if (holder == 1) {
                setspelltoknown(8, 5);
            }
            holder = bundle.getInt("Life6");
            if (holder == 1) {
                setspelltoknown(8, 6);
            }

            holder = bundle.getInt("Metal1");
            if (holder == 1) {
                setspelltoknown(9, 1);
            }
            holder = bundle.getInt("Metal2");
            if (holder == 1) {
                setspelltoknown(9, 2);
            }
            holder = bundle.getInt("Metal3");
            if (holder == 1) {
                setspelltoknown(9, 3);
            }
            holder = bundle.getInt("Metal4");
            if (holder == 1) {
                setspelltoknown(9, 4);
            }
            holder = bundle.getInt("Metal5");
            if (holder == 1) {
                setspelltoknown(9, 5);
            }
            holder = bundle.getInt("Metal6");
            if (holder == 1) {
                setspelltoknown(9, 6);
            }

            holder = bundle.getInt("Steam1");
            if (holder == 1) {
                setspelltoknown(10, 1);
            }
            holder = bundle.getInt("Steam2");
            if (holder == 1) {
                setspelltoknown(10, 2);
            }
            holder = bundle.getInt("Steam3");
            if (holder == 1) {
                setspelltoknown(10, 3);
            }
            holder = bundle.getInt("Steam4");
            if (holder == 1) {
                setspelltoknown(10, 4);
            }
            holder = bundle.getInt("Steam5");
            if (holder == 1) {
                setspelltoknown(10, 5);
            }
            holder = bundle.getInt("Steam6");
            if (holder == 1) {
                setspelltoknown(10, 6);
            }

            holder = bundle.getInt("Poison1");
            if (holder == 1) {
                setspelltoknown(11, 1);
            }
            holder = bundle.getInt("Poison2");
            if (holder == 1) {
                setspelltoknown(11, 2);
            }
            holder = bundle.getInt("Poison3");
            if (holder == 1) {
                setspelltoknown(11, 3);
            }
            holder = bundle.getInt("Poison4");
            if (holder == 1) {
                setspelltoknown(11, 4);
            }
            holder = bundle.getInt("Poison5");
            if (holder == 1) {
                setspelltoknown(11, 5);
            }
            holder = bundle.getInt("Poison6");
            if (holder == 1) {
                setspelltoknown(11, 6);
            }

            holder = bundle.getInt("Lightning1");
            if (holder == 1) {
                setspelltoknown(12, 1);
            }
            holder = bundle.getInt("Lightning2");
            if (holder == 1) {
                setspelltoknown(12, 2);
            }
            holder = bundle.getInt("Lightning3");
            if (holder == 1) {
                setspelltoknown(12, 3);
            }
            holder = bundle.getInt("Lightning4");
            if (holder == 1) {
                setspelltoknown(12, 4);
            }
            holder = bundle.getInt("Lightning5");
            if (holder == 1) {
                setspelltoknown(12, 5);
            }
            holder = bundle.getInt("Lightning6");
            if (holder == 1) {
                setspelltoknown(12, 6);
            }

            holder = bundle.getInt("Sound1");
            if (holder == 1) {
                setspelltoknown(13, 1);
            }
            holder = bundle.getInt("Sound2");
            if (holder == 1) {
                setspelltoknown(13, 2);
            }
            holder = bundle.getInt("Sound3");
            if (holder == 1) {
                setspelltoknown(13, 3);
            }
            holder = bundle.getInt("Sound4");
            if (holder == 1) {
                setspelltoknown(13, 4);
            }
            holder = bundle.getInt("Sound5");
            if (holder == 1) {
                setspelltoknown(13, 5);
            }
            holder = bundle.getInt("Sound6");
            if (holder == 1) {
                setspelltoknown(13, 6);
            }

            holder = bundle.getInt("Soul1");
            if (holder == 1) {
                setspelltoknown(14, 1);
            }
            holder = bundle.getInt("Soul2");
            if (holder == 1) {
                setspelltoknown(14, 2);
            }
            holder = bundle.getInt("Soul3");
            if (holder == 1) {
                setspelltoknown(14, 3);
            }
            holder = bundle.getInt("Soul4");
            if (holder == 1) {
                setspelltoknown(14, 4);
            }
            holder = bundle.getInt("Soul5");
            if (holder == 1) {
                setspelltoknown(14, 5);
            }
            holder = bundle.getInt("Soul6");
            if (holder == 1) {
                setspelltoknown(14, 6);
            }

            holder = bundle.getInt("Light1");
            if (holder == 1) {
                setspelltoknown(15, 1);
            }
            holder = bundle.getInt("Light2");
            if (holder == 1) {
                setspelltoknown(15, 2);
            }
            holder = bundle.getInt("Light3");
            if (holder == 1) {
                setspelltoknown(15, 3);
            }
            holder = bundle.getInt("Light4");
            if (holder == 1) {
                setspelltoknown(15, 4);
            }
            holder = bundle.getInt("Light5");
            if (holder == 1) {
                setspelltoknown(15, 5);
            }
            holder = bundle.getInt("Light6");
            if (holder == 1) {
                setspelltoknown(15, 6);
            }

            holder = bundle.getInt("Dark1");
            if (holder == 1) {
                setspelltoknown(16, 1);
            }
            holder = bundle.getInt("Dark2");
            if (holder == 1) {
                setspelltoknown(16, 2);
            }
            holder = bundle.getInt("Dark3");
            if (holder == 1) {
                setspelltoknown(16, 3);
            }
            holder = bundle.getInt("Dark4");
            if (holder == 1) {
                setspelltoknown(16, 4);
            }
            holder = bundle.getInt("Dark5");
            if (holder == 1) {
                setspelltoknown(16, 5);
            }
            holder = bundle.getInt("Dark6");
            if (holder == 1) {
                setspelltoknown(16, 6);
            }

            holder = bundle.getInt("Gravity1");
            if (holder == 1) {
                setspelltoknown(17, 1);
            }
            holder = bundle.getInt("Gravity2");
            if (holder == 1) {
                setspelltoknown(17, 2);
            }
            holder = bundle.getInt("Gravity3");
            if (holder == 1) {
                setspelltoknown(17, 3);
            }
            holder = bundle.getInt("Gravity4");
            if (holder == 1) {
                setspelltoknown(17, 4);
            }
            holder = bundle.getInt("Gravity5");
            if (holder == 1) {
                setspelltoknown(17, 5);
            }
            holder = bundle.getInt("Gravity6");
            if (holder == 1) {
                setspelltoknown(17, 6);
            }

            holder = bundle.getInt("Wild1");
            if (holder == 1) {
                setspelltoknown(18, 1);
            }
            holder = bundle.getInt("Wild2");
            if (holder == 1) {
                setspelltoknown(18, 2);
            }
            holder = bundle.getInt("Wild3");
            if (holder == 1) {
                setspelltoknown(18, 3);
            }
            holder = bundle.getInt("Wild4");
            if (holder == 1) {
                setspelltoknown(18, 4);
            }
            holder = bundle.getInt("Wild5");
            if (holder == 1) {
                setspelltoknown(18, 5);
            }
            holder = bundle.getInt("Wild6");
            if (holder == 1) {
                setspelltoknown(18, 6);
            }
            holder = bundle.getInt("Wild7");
            if (holder == 1) {
                setspelltoknown(18, 7);
            }
            holder = bundle.getInt("Wild8");
            if (holder == 1) {
                setspelltoknown(18, 8);
            }
        }
        System.out.println(spellknown);
        //for(int x = 0; x < knownspelltotal; x++){System.out.println(spellstrings[x]); }
    }
    public void setspelltoknown(int element,int number){
        switch(element){
            //story
            case 1:
                switch(number){
                    case 1:
                        out = "Portal";
                        learn.spell = spellz.portal;
                        break;
                    case 2:
                        out = "Broom";
                        learn.spell = spellz.broom;
                        break;
                    case 3:
                        out = "Self Illusion";
                        learn.spell = spellz.selfillusion;
                        break;
                    case 4:
                        out = "Snowball";
                        learn.spell = spellz.snowball;
                        break;
                    case 5:
                        out = "The Books Power";
                        learn.spell = spellz.bookspower;
                        break;
                    case 6:
                        out = "Minor Illusion";
                        learn.spell = spellz.minorillusion;
                        break;
                    case 11:
                        out = "Self Illuion";
                        learn.spell = spellz.selfillusion;
                        break;
                    case 12:
                        out = "Self Illsion";
                        learn.spell = spellz.selfillusion;
                        break;
                    case 13:
                        out = "Self Ilusion";
                        learn.spell = spellz.selfillusion;
                        break;
                    case 14:
                        out = "Self llusion";
                        learn.spell = spellz.selfillusion;
                        break;
                    case 15:
                        out = "Sel Illusion";
                        learn.spell = spellz.selfillusion;
                        break;
                    case 16:
                        out = "Sef Illusion";
                        learn.spell = spellz.selfillusion;
                        break;
                }
                break;
            //fire
            case 2:
                switch(number){
                    case 1:
                        out = "Fire Bolt";
                        learn.spell = spellz.firebolt;
                        break;
                    case 2:
                        out = "Fireball";
                        learn.spell = spellz.fireball;
                        break;
                    case 3:
                        out = "Create Bonfire";
                        learn.spell = spellz.createbonfire;
                        break;
                    case 4:
                        out = "Fire Shield";
                        learn.spell = spellz.fireshield;
                        break;
                    case 5:
                        out = "Crimson Rose";
                        learn.spell = spellz.crimsonrose;
                        break;
                    case 6:
                        out = "Investiture of Heat";
                        learn.spell = spellz.investitureofheat;
                        break;
                }
                break;
            //ice
            case 3:
                switch(number){
                    case 1:
                        out = "Ice Knife";
                        learn.spell = spellz.iceknife;
                        break;
                    case 2:
                        out = "Frostbite";
                        learn.spell = spellz.frostbite;
                        break;
                    case 3:
                        out = "Investiture of Cold";
                        learn.spell = spellz.investitureofcold;
                        break;
                    case 4:
                        out = "Wall of Ice";
                        learn.spell = spellz.wallofice;
                        break;
                    case 5:
                        out = "Ice Storm";
                        learn.spell = spellz.icestorm;
                        break;
                    case 6:
                        out = "Cone of Cold";
                        learn.spell = spellz.coneofcold;
                        break;
                }
                break;
            //Oze
            case 4:
                switch(number){
                    case 1:
                        out = "Acid Arrow";
                        learn.spell = spellz.acidarrow;
                        break;
                    case 2:
                        out = "Acid Splash";
                        learn.spell = spellz.acidsplash;
                        break;
                    case 3:
                        out = "Summon Slime";
                        learn.spell = spellz.summonslime;
                        break;
                    case 4:
                        out = "Absorb Elements";
                        learn.spell = spellz.absorbelements;
                        break;
                    case 5:
                        out = "Hunger";
                        learn.spell = spellz.hunger;
                        break;
                    case 6:
                        out = "Clone";
                        learn.spell = spellz.clone;
                        break;
                }
                break;
            // Water
            case 5:
                switch(number){
                    case 1:
                        out = "Control Water";
                        learn.spell = spellz.controlwater;
                        break;
                    case 2:
                        out = "Splash";
                        learn.spell = spellz.splash;
                        break;
                    case 3:
                        out = "Rain";
                        learn.spell = spellz.rain;
                        break;
                    case 4:
                        out = "Bubble Refresher";
                        learn.spell = spellz.bubblerefresher;
                        break;
                    case 5:
                        out = "Tsunami";
                        learn.spell = spellz.tsunami;
                        break;
                    case 6:
                        out = "Wall of Water";
                        learn.spell = spellz.wallofwater;
                        break;
                }
                break;
            //Earth
            case 6:
                switch(number){
                    case 1:
                        out = "Investiture of Stone";
                        learn.spell = spellz.investitureofstone;
                        break;
                    case 2:
                        out = "Stoneskin";
                        learn.spell = spellz.stoneskin;
                        break;
                    case 3:
                        out = "Earth Tremor";
                        learn.spell = spellz.earthtremor;
                        break;
                    case 4:
                        out = "Guardian of Stone";
                        learn.spell = spellz.guardianofstone;
                        break;
                    case 5:
                        out = "Wall of Stone";
                        learn.spell = spellz.wallofstone;
                        break;
                    case 6:
                        out = "Stone Prison";
                        learn.spell = spellz.stoneprison;
                        break;
                }
                break;
            //Air
            case 7:
                switch(number){
                    case 1:
                        out = "Catapult";
                        learn.spell = spellz.catapult;
                        break;
                    case 2:
                        out = "Control Winds";
                        learn.spell = spellz.controlwinds;
                        break;
                    case 3:
                        out = "Investiture of Winds";
                        learn.spell = spellz.investitureofwinds;
                        break;
                    case 4:
                        out = "Gust";
                        learn.spell = spellz.gust;
                        break;
                    case 5:
                        out = "Wind Strike";
                        learn.spell = spellz.windstrike;
                        break;
                    case 6:
                        out = "Whirlwind";
                        learn.spell = spellz.whirlwind;
                        break;
                }
                break;
            //Life
            case 8:
                switch(number){
                    case 1:
                        out = "barkskin";
                        learn.spell = spellz.barkskin;
                        break;
                    case 2:
                        out = "summonent";
                        learn.spell = spellz.summonent;
                        break;
                    case 3:
                        out = "enlarge";
                        learn.spell = spellz.enlarge;
                        break;
                    case 4:
                        out = "graspingvine";
                        learn.spell = spellz.graspingvine;
                        break;
                    case 5:
                        out = "guardianofnature";
                        learn.spell = spellz.guardianofnature;
                        break;
                    case 6:
                        out = "thornwhip";
                        learn.spell = spellz.thornwhip;
                        break;
                }
                break;
            //Metal
            case 9:
                switch(number){
                    case 1:
                        out = "Investiture of Iron";
                        learn.spell = spellz.investitureofiron;
                        break;
                    case 2:
                        out = "Heat Metal";
                        learn.spell = spellz.heatmetal;
                        break;
                    case 3:
                        out = "Guardian of Steel";
                        learn.spell = spellz.guardianofsteel;
                        break;
                    case 4:
                        out = "Spike Shot";
                        learn.spell = spellz.spikeshot;
                        break;
                    case 5:
                        out = "Summon Magic Sword";
                        learn.spell = spellz.summonmagicsword;
                        break;
                    case 6:
                        out = "Iron Maiden";
                        learn.spell = spellz.ironmaiden;
                        break;
                }
                break;
            //Steam
            case 10:
                switch(number){
                    case 1:
                        out = "Blur";
                        learn.spell = spellz.blur;
                        break;
                    case 2:
                        out = "Investiture of Fog";
                        learn.spell = spellz.investitureoffog;
                        break;
                    case 3:
                        out = "Fog Cloud";
                        learn.spell = spellz.fogcloud;
                        break;
                    case 4:
                        out = "Gaseous Form";
                        learn.spell = spellz.gaseousform;
                        break;
                    case 5:
                        out = "Sleep";
                        learn.spell = spellz.sleep;
                        break;
                    case 6:
                        out = "Cloud Kill";
                        learn.spell = spellz.cloudkill;
                        break;
                }
                break;
            //Poison
            case 11:
                switch(number){
                    case 1:
                        out = "Fear";
                        learn.spell = spellz.fear;
                        break;
                    case 2:
                        out = "Poison Spray";
                        learn.spell = spellz.poisonspray;
                        break;
                    case 3:
                        out = "Sickening Radiance";
                        learn.spell = spellz.sickeningradiance;
                        break;
                    case 4:
                        out = "Poison Cloud";
                        learn.spell = spellz.poisoncloud;
                        break;
                    case 5:
                        out = "Tipped Thorn Armor";
                        learn.spell = spellz.tipedthornarmor;
                        break;
                    case 6:
                        out = "Corruption";
                        learn.spell = spellz.corruption;
                        break;
                }
                break;
            //Lightning
            case 12:
                switch(number){
                    case 1:
                        out = "Chain Lightning";
                        learn.spell = spellz.chainlightning;
                        break;
                    case 2:
                        out = "Lightning Bolt";
                        learn.spell = spellz.lightningbolt;
                        break;
                    case 3:
                        out = "Guardian of Thunder";
                        learn.spell = spellz.guardianofthunder;
                        break;
                    case 4:
                        out = "Summon Storm";
                        learn.spell = spellz.summonstorm;
                        break;
                    case 5:
                        out = "Thunder Clap";
                        learn.spell = spellz.thunderclap;
                        break;
                    case 6:
                        out = "Thunder Step";
                        learn.spell = spellz.thunderstep;
                        break;
                }
                break;
            //Sound
            case 13:
                switch(number){
                    case 1:
                        out = "Healing Word";
                        learn.spell = spellz.healingword;
                        break;
                    case 2:
                        out = "Charm";
                        learn.spell = spellz.charm;
                        break;
                    case 3:
                        out = "Command";
                        learn.spell = spellz.command;
                        break;
                    case 4:
                        out = "Dissonant Whispers";
                        learn.spell = spellz.dissonantwhispers;
                        break;
                    case 5:
                        out = "Power Word Kill";
                        learn.spell = spellz.powerwordkill;
                        break;
                    case 6:
                        out = "Power Word Stun";
                        learn.spell = spellz.powerwordstun;
                        break;
                }
                break;
            //Soul
            case 14:
                switch(number){
                    case 1:
                        out = "Astral Projection";
                        learn.spell = spellz.astralprojection;
                        break;
                    case 2:
                        out = "Death Ward";
                        learn.spell = spellz.deathward;
                        break;
                    case 3:
                        out = "Dream";
                        learn.spell = spellz.dream;
                        break;
                    case 4:
                        out = "Guardian of Dream";
                        learn.spell = spellz.guardianofdream;
                        break;
                    case 5:
                        out = "Healing Spirit";
                        learn.spell = spellz.healingspirit;
                        break;
                    case 6:
                        out = "Phantasmal Killer";
                        learn.spell = spellz.phantasmalkiller;
                        break;
                }
                break;
            //Light
            case 15:
                switch(number){
                    case 1:
                        out = "Dawn";
                        learn.spell = spellz.dawn;
                        break;
                    case 2:
                        out = "Heal";
                        learn.spell = spellz.heal;
                        break;
                    case 3:
                        out = "Day Light";
                        learn.spell = spellz.daylight;
                        break;
                    case 4:
                        out = "Investiture of Sun";
                        learn.spell = spellz.investitureofsun;
                        break;
                    case 5:
                        out = "Guardian of Light";
                        learn.spell = spellz.guardianoflight;
                        break;
                    case 6:
                        out = "Sunbeam";
                        learn.spell = spellz.sunbeam;
                        break;
                }
                break;
            //Dark
            case 16:
                switch(number){
                    case 1:
                        out = "Shadow Arms";
                        learn.spell = spellz.shadowarms;
                        break;
                    case 2:
                        out = "Summon Shadow";
                        learn.spell = spellz.summonshadow;
                        break;
                    case 3:
                        out = "Investiture of Moon";
                        learn.spell = spellz.investitureofmoon;
                        break;
                    case 4:
                        out = "Moonbeam";
                        learn.spell = spellz.moonbeam;
                        break;
                    case 5:
                        out = "Eldritch Blast";
                        learn.spell = spellz.eldritchblast;
                        break;
                    case 6:
                        out = "Darkness";
                        learn.spell = spellz.darkness;
                        break;
                }
                break;
            //Gravity
            case 17:
                switch(number){
                    case 1:
                        out = "Dark Star";
                        learn.spell = spellz.darkstar;
                        break;
                    case 2:
                        out = "Force Wave";
                        learn.spell = spellz.forcewave;
                        break;
                    case 3:
                        out = "Wall of Force";
                        learn.spell = spellz.wallofforce;
                        break;
                    case 4:
                        out = "Gravity Fissure";
                        learn.spell = spellz.gravityfissure;
                        break;
                    case 5:
                        out = "Magic Missile";
                        learn.spell = spellz.magicmissile;
                        break;
                    case 6:
                        out = "Magnify Gravity";
                        learn.spell = spellz.magnifygravity;
                        break;
                }
                break;
            //Wild
            case 18:
                switch(number){
                    case 1:
                        out = "Chaos Bolt";
                        learn.spell = spellz.chaosbolt;
                        break;
                    case 2:
                        out = "Summon Elemental";
                        learn.spell = spellz.summonelemental;
                        break;
                    case 3:
                        out = "Investiture of Chaos";
                        learn.spell = spellz.investitureofchaos;
                        break;
                    case 4:
                        out = "Chromatic Blast";
                        learn.spell = spellz.chromaticblast;
                        break;
                    case 5:
                        out = "Coin Flip";
                        learn.spell = spellz.coinflip;
                        break;
                    case 6:
                        out = "Create Anti";
                        learn.spell = spellz.createanti;
                        break;
                    case 7:
                        out = "Create Void";
                        learn.spell = spellz.createvoid;
                        break;
                    case 8:
                        out = "Create Artha";
                        learn.spell = spellz.createartha;
                        break;
                }
                break;

        }
        if(learn.spell != spellz.Null){
            spellknown = spellknown + "\n-" + out;
            spellstrings[knownspelltotal] = out;

            knownspelltotal++;
            switch(knownspelltotal){
                case 1:
                    knownspell1.spell = learn.spell;
                    break;
                case 2:
                    knownspell2.spell = learn.spell;
                    break;
                case 3:
                    knownspell3.spell = learn.spell;
                    break;
                case 4:
                    knownspell4.spell = learn.spell;
                    break;
                case 5:
                    knownspell5.spell = learn.spell;
                    break;
                case 6:
                    knownspell6.spell = learn.spell;
                    break;
                case 7:
                    knownspell7.spell = learn.spell;
                    break;
                case 8:
                    knownspell8.spell = learn.spell;
                    break;
                case 9:
                    knownspell9.spell = learn.spell;
                    break;
                case 10:
                    knownspell10.spell = learn.spell;
                    break;
                case 11:
                    knownspell11.spell = learn.spell;
                    break;
                default:
                    System.out.println("too many spells");
                    System.out.println("too many spells bro");
                    System.out.println("bro bro too many spells");
                    System.out.println("BROOOO");
                    System.out.println("TOO MANY SPELLS BRO");
                    break;
            }

            learn.spell = spellz.Null;
        }
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public void next(View v){
        updateplayersstats();
        if(restart == true) {
            restartgame();
        }else if(instats == false){
            if(inbattle == false) {
                switch (adventureprogress) {
                    case 0:
                        battle(1);
                        adventureprogress++;
                        break;
                    case 1:
                    case 2:
                    case 3:
                        holder = Random(1,3,"camp or battle 1-3");
                        switch(holder){
                            case 1:
                                battle(1);
                                break;
                            case 2:
                                rest(1);
                                break;
                            case 3:
                                rest(2);
                                break;
                        }
                        adventureprogress++;
                        break;
                    case 4:
                    case 8:
                        holder = Random(2,3,"camp 2-3");
                        switch(holder){
                            case 2:
                                rest(1);
                                break;
                            case 3:
                                rest(2);
                                break;
                        }
                        adventureprogress++;
                        break;
                    case 5:
                    case 6:
                    case 7:
                        holder = Random(2,6,"bad battles or camp 1-6");
                        switch(holder){
                            case 1:
                                battle(1);
                            case 2:
                                rest(1);
                                break;
                            case 3:
                                rest(2);
                                break;
                            case 4:
                            case 5:
                            case 6:
                                battle(2);
                                break;
                        }
                        adventureprogress++;
                        break;
                    case 9:
                        battle(2);
                        adventureprogress++;
                        break;
                    case 10:
                        battle(3);
                        adventureprogress++;
                        break;
                    case 11:
                        win();
                        break;
                }
            }
        }else{
            title.setText(saved1);
            main.setText(saved2);
            bnext.setText(saved3);
            if(inbattle == true) {
                bdef.setText("Defend");
                bmix.setText("Mix");
                breg.setText("Recharge");
            }
            instats = false;
            b1.setText(saved4);
            b1.setText(saved5);
            b1.setText(saved6);
            b1.setText(saved7);
            out = "Your Spells";
            bsll.setText(out);
        }
    }
    public void yourspells(View v){
        if(instats == false) {
            saved1 = title.getText().toString();
            saved2 = main.getText().toString();
            saved3 = bnext.getText().toString();
            out = "Your Spells";
            title.setText(out);
            out = "here is a list of your spells\n" + spellknown;
            main.setText(out);
            out = "Leave Spells";
            bnext.setText(out);
            out = "";
            bsll.setText(out);
            bdef.setText(out);
            bmix.setText(out);
            breg.setText(out);
            instats = true;

            saved4 = b1.getText().toString();
            saved5 = b2.getText().toString();
            saved6 = b3.getText().toString();
            saved7 = b4.getText().toString();
            b1.setText(out);
            b2.setText(out);
            b3.setText(out);
            b4.setText(out);
        }
    }

    public void defend(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 1;
                regenthedefend();
            }
        }
    }
    public void mix(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 2;
                regenthedefend();
            }
        }
    }
    public void recharge(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 3;
                regenthedefend();
            }
        }
    }

    public void spell1(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 1;
                castspell();
            }
        }
    }
    public void spell2(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 2;
                castspell();
            }
        }
    }
    public void spell3(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 3;
                castspell();
            }
        }
    }
    public void spell4(View v){
        if(instats == false) {
            if (inbattle == true) {
                button = 4;
                castspell();
            }
        }
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public void regenthedefend(){
        System.out.println("mixture time");
        switch(button){
            case 1:
                playersout = "You Defended on your Turn";
                player.DEF = player.DEF + 20;
                break;
            case 2:
                playersout = "You Defended while trying to recover some mana on your Turn";
                player.DEF = player.DEF + 10;
                player.MP = player.MP + player.MP / 4;
                break;
            case 3:
                playersout = "You recovered half of you mana on your Turn";
                player.MP = player.MP + player.MP / 2;
                break;
        }
        updateplayersstats();
        domonstersturn();
        switch(button){
            case 1:
                player.DEF = player.DEF - 20;
                break;
            case 2:
                player.DEF = player.DEF - 10;
                break;
        }
        updateplayersstats();
    }
    public void castspell(){
        System.out.println("spell time");
        updateplayersstats();

        //spells
        switch(button){
            case 1:
                holder = spell1;
                spell1 = Random(1, knownspelltotal, "random spell slection");
                looper = 0;
                while(looper == 0){
                    if(spell1 == spell2 || spell1 == spell3 || spell1 == spell4 || spell1 == holder) {
                        spell1 = Random(1, knownspelltotal, "random spell slection");
                    }else{
                        looper = 1;
                    }
                }
                break;
            case 2:
                holder = spell2;
                spell2 = Random(1, knownspelltotal, "random spell slection");
                looper = 0;
                while(looper == 0){
                    if(spell2 == spell1 || spell2 == spell3 || spell2 == spell4 || spell2 == holder) {
                        spell2 = Random(1, knownspelltotal, "random spell slection");
                    }else{
                        looper = 1;
                    }
                }
                break;
            case 3:
                holder = spell3;
                spell3 = Random(1, knownspelltotal, "random spell slection");
                looper = 0;
                while(looper == 0){
                    if(spell3 == spell1 || spell3 == spell2 || spell3 == spell4 || spell3 == holder) {
                        spell3 = Random(1, knownspelltotal, "random spell slection");
                    }else{
                        looper = 1;
                    }
                }
                break;
            case 4:
                holder = spell4;
                spell4 = Random(1, knownspelltotal, "random spell slection");
                looper = 0;
                while(looper == 0){
                    if(spell4 == spell1 || spell4 == spell2 || spell4 == spell3 || spell4 == holder) {
                        spell4 = Random(1, knownspelltotal, "random spell slection");
                    }else{
                        looper = 1;
                    }
                }
                break;
        }
        switch(holder){
            case 1:
                spellbeingcast.spell = knownspell1.spell;
                break;
            case 2:
                spellbeingcast.spell = knownspell2.spell;
                break;
            case 3:
                spellbeingcast.spell = knownspell3.spell;
                break;
            case 4:
                spellbeingcast.spell = knownspell4.spell;
                break;
            case 5:
                spellbeingcast.spell = knownspell5.spell;
                break;
            case 6:
                spellbeingcast.spell = knownspell6.spell;
                break;
            case 7:
                spellbeingcast.spell = knownspell7.spell;
                break;
            case 8:
                spellbeingcast.spell = knownspell8.spell;
                break;
            case 9:
                spellbeingcast.spell = knownspell9.spell;
                break;
            case 10:
                spellbeingcast.spell = knownspell10.spell;
                break;
            case 11:
                spellbeingcast.spell = knownspell11.spell;
                break;
        }

        switch(spellbeingcast.spell){
            case portal:
                if(player.MP >= 5) {
                    player.MP -= 5;
                    playersout += "\nYou Cast the Spell Portal and dropped a rock on the " + baddy.monster + " head";
                    player.maintype = elementaltype.Gravity;
                    attackspell(10);
                }else{
                    playersout += "\nYou Tried to cast Portal but didn't have the Mana for it";
                }
                break;
            case broom:
                playersout += "\nYou Cast? the Spell Broom and hit " + baddy.monster + " on the head";
                player.maintype = elementaltype.Gravity;
                attackspell(1);
                break;
            default:
                player.maintype = elementaltype.Fire;
                attackspell(25);

                player.maintype = elementaltype.Fire;
                infesturespell();

                healingspell(25);
                break;
        }
        placespell(spell1,1);
        placespell(spell2,2);
        placespell(spell3,3);
        placespell(spell4,4);

        domonstersturn();
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public void attackspell(int damage){
        int elementalbonus = 0;
        switch(player.maintype){
            case Fire:
                elementalbonus = elementalbonus + firebonus;
                break;
            case Ice:
                elementalbonus = elementalbonus + icebonus;
                break;
            case Oze:
                elementalbonus = elementalbonus + ozebonus;
                break;
            case Water:
                elementalbonus = elementalbonus + waterbonus;
                break;
            case Earth:
                elementalbonus = elementalbonus + earthbonus;
                break;
            case Air:
                elementalbonus = elementalbonus + airbonus;
                break;
            case Life:
                elementalbonus = elementalbonus + lifebonus;
                break;
            case Metal:
                elementalbonus = elementalbonus + metalbonus;
                break;
            case Steam:
                elementalbonus = elementalbonus + steambonus;
                break;
            case Poison:
                elementalbonus = elementalbonus + poisonbonus;
                break;
            case Lightning:
                elementalbonus = elementalbonus + lightningbonus;
                break;
            case Sound:
                elementalbonus = elementalbonus + soundbonus;
                break;
            case Soul:
                elementalbonus = elementalbonus + soulbonus;
                break;
            case Light:
                elementalbonus = elementalbonus + lightbonus;
                break;
            case Dark:
                elementalbonus = elementalbonus + darkbonus;
                break;
            case Gravity:
                elementalbonus = elementalbonus + gravitybonus;
                break;
            case Wild:
                elementalbonus = elementalbonus + firebonus + icebonus + ozebonus + waterbonus + earthbonus + airbonus + lifebonus + metalbonus + steambonus + poisonbonus + lightningbonus + soundbonus + soulbonus + lightbonus + darkbonus + gravitybonus;
                break;
            case Null:
                elementalbonus = 0;
                break;
        }
        player.maintype = elementaltype.Null;
        damage = damage - baddy.DEF + elementalbonus;
        if(damage < 1){
            damage = 1;
        }
        baddy.HP = baddy.HP - damage;
        saved1 = Integer.toString(damage);
        playersout = playersout + "\nYou dealt " + saved1 + " to the monster";

        updateplayersstats();
    }
    public void healingspell(int healing){
        player.HP = player.HP + healing;
        saved1 = Integer.toString(healing);
        playersout = playersout + "\nYou healed " + saved1;
        updateplayersstats();
    }
    public void infesturespell(){
        switch(player.maintype){
            case Fire:
                firebonus = firebonus + 3;
                playersout = playersout + "\nYour Fire Spells grow stronger";
                break;
            case Ice:
                icebonus = icebonus + 3;
                playersout = playersout + "\nYour Ice Spells grow stronger";
                break;
            case Oze:
                ozebonus = ozebonus + 3;
                playersout = playersout + "\nYour Oze Spells grow stronger";
                break;
            case Water:
                waterbonus = waterbonus + 3;
                playersout = playersout + "\nYour Water Spells grow stronger";
                break;
            case Earth:
                earthbonus = earthbonus + 3;
                playersout = playersout + "\nYour Earth Spells grow stronger";
                break;
            case Air:
                airbonus = airbonus + 3;
                playersout = playersout + "\nYour Air Spells grow stronger";
                break;
            case Life:
                lifebonus = lifebonus + 3;
                playersout = playersout + "\nYour Life Spells grow stronger";
                break;
            case Metal:
                metalbonus = metalbonus + 3;
                playersout = playersout + "\nYour Metal Spells grow stronger";
                break;
            case Steam:
                steambonus = steambonus + 3;
                playersout = playersout + "\nYour Steam Spells grow stronger";
                break;
            case Poison:
                poisonbonus = poisonbonus + 3;
                playersout = playersout + "\nYour Poison Spells grow stronger";
                break;
            case Lightning:
                lightningbonus = lightningbonus + 3;
                playersout = playersout + "\nYour Lightning Spells grow stronger";
                break;
            case Sound:
                soundbonus = soundbonus + 3;
                playersout = playersout + "\nYour Sound Spells grow stronger";
                break;
            case Soul:
                soulbonus = soulbonus + 3;
                playersout = playersout + "\nYour Soul Spells grow stronger";
                break;
            case Light:
                lightbonus = lightbonus + 3;
                playersout = playersout + "\nYour Light Spells grow stronger";
                break;
            case Dark:
                darkbonus = darkbonus + 3;
                playersout = playersout + "\nYour Dark Spells grow stronger";
                break;
            case Gravity:
                gravitybonus = gravitybonus + 3;
                playersout = playersout + "\nYour Gravity Spells grow stronger";
                break;
            case Wild:
                firebonus = firebonus + 1;
                icebonus = icebonus + 1;
                ozebonus = ozebonus + 1;
                waterbonus = waterbonus + 1;
                earthbonus = earthbonus + 1;
                airbonus = airbonus + 1;
                lifebonus = lifebonus + 1;
                metalbonus = metalbonus + 1;
                steambonus = steambonus + 1;
                poisonbonus = poisonbonus + 1;
                lightningbonus = lightningbonus + 1;
                soundbonus = soundbonus + 1;
                soulbonus = soulbonus + 1;
                lightbonus = lightbonus + 1;
                darkbonus = darkbonus + 1;
                gravitybonus = gravitybonus + 1;
                playersout = playersout + "\nYour Spells grow stronger";
                break;
        }
        player.maintype = elementaltype.Null;
        updateplayersstats();
    }
    public void buffspell(int buffing, int type){
        saved1 = Integer.toString(buffing);
        switch(type){
            case 1:
                player.DEF = player.DEF + buffing;
                playersout = playersout + "\nYour defence went up by " + saved1;
                break;
            case 2:
                ManaMax = ManaMax + buffing;
                playersout = playersout + "\nYour Max mana went up by " + saved1;
            case 3:
                player.MP = player.MP + buffing;
                playersout = playersout + "\nYour Mana went up by " + saved1;
                break;
        }
        player.maintype = elementaltype.Null;
        updateplayersstats();
    }
    public void debuffspell(int debuffing, int type){
        saved1 = Integer.toString(debuffing);
        switch(type){
            case 1:
                baddy.DEF = player.DEF - debuffing;
                playersout = playersout + "\nYou lowered the monsters defence by " + saved1;
                break;
            case 2:
                baddy.MP = baddy.MP - debuffing;
                playersout = playersout + "\nYou lowered the monsters action points by " + saved1;
            case 3:
                baddy.ATK = baddy.ATK - debuffing;
                playersout = playersout + "\nYou lowered the monsters by attack power " + saved1;
        }
        updateplayersstats();
    }
    public void otherspell(int other){
        //will do when needed
        updateplayersstats();
    }
    public void domonstersturn(){
        TextView main = findViewById(R.id.maintxt);
        if(baddy.HP <= 0){
            endbattle();
        }else {
            //choose action
            int damage;
            switch (baddy.monster) {
                case Slime:
                    looper = 0;
                    while (looper == 0) {
                        holder = Random(1, 3, "Slimes Turn");
                        switch (holder) {
                            case 1:
                                if (baddy.MP > 3) {
                                    baddy.MP = baddy.MP - 3;
                                    damage = baddy.ATK - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Slime dealt " + saved1 + " to you";
                                    looper = 1;
                                }
                                break;
                            case 2:
                                if (baddy.MP < 4) {
                                    baddy.MP = baddy.MP + 5;
                                    monstersout += "\nThe Slime Recovered some action points";
                                    looper = 1;
                                }
                                break;
                            case 3:
                                if (baddy.MP < 4) {
                                    baddy.MP = baddy.MP + 2;
                                    monstersout += "\nThe Slime Recovered some action points and increased its defence by 1";
                                    looper = 1;
                                }
                                break;
                        }
                    }
                    break;
                case Goblin:
                    looper = 0;
                    while (looper == 0) {
                        holder = Random(1, 4, "Goblin Turn");
                        switch (holder) {
                            case 1:
                                if (baddy.MP > 4) {
                                    baddy.MP = baddy.MP - 4;
                                    damage = baddy.ATK - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Goblin dealt " + saved1 + " to you";
                                    looper = 1;
                                }
                                break;
                            case 2:
                                if (baddy.MP < 6) {
                                    baddy.MP = baddy.MP + 4;
                                    monstersout += "\nThe Goblin Recovered some action points";
                                    looper = 1;
                                }
                                break;
                            case 3:
                                if (baddy.MP < 3) {
                                    baddy.MP = baddy.MP + 8;
                                    monstersout += "\nThe Goblin Recovered some action points by a ton";
                                    looper = 1;
                                }
                                break;
                            case 4:
                                if (baddy.MP > 5) {
                                    baddy.MP = baddy.MP - 5;
                                    damage = baddy.ATK + 5 - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Goblin dealt " + saved1 + " to you using a heavy attack";
                                    looper = 1;
                                }
                                break;
                        }
                    }
                    break;
                case Ogre:
                    looper = 0;
                    while (looper < 2) {
                        holder = Random(1, 5, "Ogre Turn");
                        switch (holder) {
                            case 1:
                                if(baddy.MP > 7) {
                                    baddy.MP = baddy.MP - 7;
                                    damage = baddy.ATK - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Ogre dealt " + saved1 + " to you";
                                    looper++;
                                }
                                break;
                            case 2:
                                if(baddy.MP < 10) {
                                    baddy.MP = baddy.MP + 8;
                                    monstersout += "\nThe Ogre Recovered some action points";
                                    looper++;
                                }
                                break;
                            case 3:
                                if(baddy.MP < 5) {
                                    baddy.MP = baddy.MP + 12;
                                    monstersout += "\nThe Ogre Recovered some action points by a ton";
                                    looper++;
                                }
                                break;
                            case 4:
                                if(baddy.MP > 8) {
                                    baddy.MP = baddy.MP - 8;
                                    damage = baddy.ATK + 5 - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Ogre dealt " + saved1 + " to you using a heavy attack";
                                    looper++;
                                }
                            case 5:
                                if(baddy.HP < 25){
                                    baddy.HP = baddy.HP + 5;
                                    monstersout += "\nThe Ogre healed 5 by eating some food";
                                    looper++;
                                }
                                break;
                        }
                    }
                    break;
                case Dragon:
                    looper = 0;
                    while (looper < 3) {
                        holder = Random(1, 6, "Dragon Turn");
                        switch (holder) {
                            case 1:
                                if(baddy.MP > 8) {
                                    baddy.MP = baddy.MP - 8;
                                    damage = baddy.ATK - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Dragon dealt " + saved1 + " to you";
                                    looper++;
                                }
                                break;
                            case 2:
                                if(baddy.MP < 10) {
                                    baddy.MP = baddy.MP + 25;
                                    monstersout += "\nThe Dragon Recovered some action points";
                                    looper++;
                                }
                                break;
                            case 3:
                                if(baddy.MP < 30) {
                                    baddy.MP = baddy.MP + 15;
                                    monstersout += "\nThe Dragon Recovered some action points by a ton";
                                    looper++;
                                }
                                break;
                            case 4:
                                if(baddy.MP > 10) {
                                    baddy.MP = baddy.MP - 10;
                                    damage = baddy.ATK + 8 - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Dragon dealt " + saved1 + " to you using a heavy attack";
                                    looper++;
                                }
                            case 5:
                                if(baddy.HP < 50){
                                    baddy.HP = baddy.HP + 10;
                                    monstersout += "\nThe Dragon healed 10 by eating some food";
                                    looper++;
                                }
                                break;
                            case 6:
                                if(baddy.MP > 35) {
                                    baddy.MP = baddy.MP - 35;
                                    damage = baddy.ATK + 20 - player.DEF;
                                    if (damage <= 0) {
                                        damage = 1;
                                    }
                                    player.HP = player.HP - damage;
                                    saved1 = Integer.toString(damage);
                                    monstersout += "\nThe Dragon dealt " + saved1 + " to you using his breath Weapon";
                                    looper++;
                                }
                                break;
                        }
                    }
                    break;
            }
            out = "Actions Taken" + "\n" + playersout + "\n" + monstersout;
            System.out.println(playersout);
            System.out.println(monstersout);
            main.setText(out);
        }
        //display playerout and monsterout

        updateplayersstats();
        playersout = "";
        monstersout = "";
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public void battle(int dificulty){
        //randomizer for starting a battle
        out = "\nWhat action will you take?";
        switch(dificulty){
            case 1:
                holder = Random(1,2,"easy monster");
                switch(holder) {
                    case 1:
                        title.setText("Goblin");
                        main.setText("A Wild Goblin appeared!" + out);
                        baddy.monster = Monsterz.Goblin;
                        baddy.HP = 20;
                        baddy.DEF = 3;
                        baddy.MP = 10;
                        baddy.ATK = 10;
                        break;
                    case 2:
                        title.setText("Slime");
                        main.setText("A Wild Slime appeared!" + out);
                        baddy.monster = Monsterz.Slime;
                        baddy.HP = 5;
                        baddy.DEF = 15;
                        baddy.MP = 10;
                        baddy.ATK = 5;
                        break;
                }
                break;
            case 2:
                title.setText("Ogre");
                main.setText("A Wild Ogre appeared!" + out);
                baddy.monster = Monsterz.Ogre;
                baddy.HP = 50;
                baddy.DEF = 5;
                baddy.MP = 20;
                baddy.ATK = 18;
                break;
            case 3:
                title.setText("Dragon");
                main.setText("A Wild Dragon appeared!" + out);
                baddy.monster = Monsterz.Dragon;
                baddy.HP = 150;
                baddy.DEF = 10;
                baddy.MP = 50;
                baddy.ATK = 25;
                break;
        }

        inbattle = true;

        bdef.setText("Defend");
        bmix.setText("Mix");
        breg.setText("Recharge");

        out = "";
        bnext.setText(out);

        //sleect 4 starting spells
        spell1 = Random(1,knownspelltotal, "random spell slection");
        spell2 = Random(1,knownspelltotal, "random spell slection");
        spell3 = Random(1,knownspelltotal, "random spell slection");
        spell4 = Random(1,knownspelltotal, "random spell slection");
        looper = 0;
        while(looper == 0){
            if(spell1 == spell2 || spell1 == spell3 || spell1 == spell4){
                spell2 = Random(1,knownspelltotal, "random spell slection");
                spell3 = Random(1,knownspelltotal, "random spell slection");
                spell4 = Random(1,knownspelltotal, "random spell slection");
            }else if(spell2 == spell3 || spell2 == spell4){
                spell3 = Random(1,knownspelltotal, "random spell slection");
                spell4 = Random(1,knownspelltotal, "random spell slection");
            }else if(spell3 == spell4){
                spell4 = Random(1,knownspelltotal, "random spell slection");
            }else{
                looper = 1;
                System.out.println(spell1 + " " + spell2 + " " + spell3 + " " + spell4);
            }
        }
        //use the generated spells
        placespell(spell1,1);
        placespell(spell2,2);
        placespell(spell3,3);
        placespell(spell4,4);
    }
    public void endbattle(){
        inbattle = false;

        out = "";
        bdef.setText(out);
        bmix.setText(out);
        breg.setText(out);

        b1.setText(out);
        b2.setText(out);
        b3.setText(out);
        b4.setText(out);

        out = "Continue Adventure";
        bnext.setText(out);
        out = "Victory";
        title.setText(out);
        out = "You killed the monster";
        main.setText(out);

        player.DEF = DEFMax;
        player.MP = player.MP + ManaMax / 2;
        updateplayersstats();
    }
    public void rest(int type){
        switch(type){
            case 1:
                out = "Camp";
                title.setText(out);
                out = "You set up camp and rest for a while. you take the time to patch some wounds and recover your mana.";
                main.setText(out);
                player.HP = player.HP + HPMax / 2;
                player.MP = player.MP + ManaMax;
                break;
            case 2:
                out = "Town";
                title.setText(out);
                out = "You come across a town and rest for a while. you recover fully.";
                main.setText(out);
                player.HP = player.HP + HPMax;
                player.MP = player.MP + ManaMax;
                break;
        }
        bnext.setText("Rest and Continue Adventuring");
    }
    public void placespell(int witchspell, int buttons){
        switch(witchspell){
            case 1:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[0]);
                    case 2:
                        b2.setText(spellstrings[0]);
                    case 3:
                        b3.setText(spellstrings[0]);
                    case 4:
                        b4.setText(spellstrings[0]);
                }
                break;
            case 2:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[1]);
                    case 2:
                        b2.setText(spellstrings[1]);
                    case 3:
                        b3.setText(spellstrings[1]);
                    case 4:
                        b4.setText(spellstrings[1]);
                }
                break;
            case 3:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[2]);
                    case 2:
                        b2.setText(spellstrings[2]);
                    case 3:
                        b3.setText(spellstrings[2]);
                    case 4:
                        b4.setText(spellstrings[2]);
                }
                break;
            case 4:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[3]);
                    case 2:
                        b2.setText(spellstrings[3]);
                    case 3:
                        b3.setText(spellstrings[3]);
                    case 4:
                        b4.setText(spellstrings[3]);
                }
                break;
            case 5:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[4]);
                    case 2:
                        b2.setText(spellstrings[4]);
                    case 3:
                        b3.setText(spellstrings[4]);
                    case 4:
                        b4.setText(spellstrings[4]);
                }
                break;
            case 6:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[5]);
                    case 2:
                        b2.setText(spellstrings[5]);
                    case 3:
                        b3.setText(spellstrings[5]);
                    case 4:
                        b4.setText(spellstrings[5]);
                }
                break;
            case 7:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[6]);
                    case 2:
                        b2.setText(spellstrings[6]);
                    case 3:
                        b3.setText(spellstrings[6]);
                    case 4:
                        b4.setText(spellstrings[6]);
                }
                break;
            case 8:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[7]);
                    case 2:
                        b2.setText(spellstrings[7]);
                    case 3:
                        b3.setText(spellstrings[7]);
                    case 4:
                        b4.setText(spellstrings[7]);
                }
                break;
            case 9:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[8]);
                    case 2:
                        b2.setText(spellstrings[8]);
                    case 3:
                        b3.setText(spellstrings[8]);
                    case 4:
                        b4.setText(spellstrings[8]);
                }
                break;
            case 10:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[9]);
                    case 2:
                        b2.setText(spellstrings[9]);
                    case 3:
                        b3.setText(spellstrings[9]);
                    case 4:
                        b4.setText(spellstrings[9]);
                }
                break;
            case 11:
                switch(buttons){
                    case 1:
                        b1.setText(spellstrings[10]);
                    case 2:
                        b2.setText(spellstrings[10]);
                    case 3:
                        b3.setText(spellstrings[10]);
                    case 4:
                        b4.setText(spellstrings[10]);
                }
                break;
            default:
                System.out.println("bro i told you it was too many spells");
                break;
        }
    }
    public void updateplayersstats(){
        if(player.HP > HPMax){
            player.HP = HPMax;
        }
        if(player.MP > ManaMax){
            player.MP = ManaMax;
        }

        health.setText("Heath: " + player.HP + "/" + HPMax);
        defence.setText("Defence: " + player.DEF);
        mana.setText("Mana: " + player.MP + "/" + ManaMax);

        if(player.HP <= 0){
            youdied();
        }
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public int Random(int min, int max,String what) {
        Random random = new Random();
        Integer randInt = random.nextInt((max - min) + 1) + min;
        System.out.println(randInt + " " + what);

        return randInt;
    }
    //-------------------------------//-------------------------------//-------------------------------//-------------------------------
    public void youdied(){
        restart = true;
        instats = true;

        out = "";
        bdef.setText(out);
        bmix.setText(out);
        breg.setText(out);
        bsll.setText(out);
        b1.setText(out);
        b2.setText(out);
        b3.setText(out);
        b4.setText(out);

        out = "You Died";
        bnext.setText(out);
    }
    public void win(){
        restart = true;
        instats = true;

        main.setText("Thank you for playing my game!");
        title.setText("You killed the Boss and Won");

        out = "";
        bdef.setText(out);
        bmix.setText(out);
        breg.setText(out);
        bsll.setText(out);
        b1.setText(out);
        b2.setText(out);
        b3.setText(out);
        b4.setText(out);

        out = "Play Again?";
        bnext.setText(out);
    }
    public void restartgame(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}