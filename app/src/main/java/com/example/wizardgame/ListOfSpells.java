package com.example.wizardgame;

import java.util.ArrayList;

public class ListOfSpells {
    private ArrayList<Spell> spells = new ArrayList<>();

    public ListOfSpells(){
        generateSpells();
    }

    public void generateSpells(){
        spells.add(new Spell(Spells.Portal, SpellTypes.Damage, ElementalTypes.Gravity, 5));
    }
}
