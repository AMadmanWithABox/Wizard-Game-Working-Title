package com.example.wizardgame;

public class Spell{
    private Spells name;
    private SpellTypes type;
    private ElementalTypes element;

    public Spell(Spells name, SpellTypes type, ElementalTypes element){
        this.name = name;
        this.type = type;
        this.element = element;
    }


}
