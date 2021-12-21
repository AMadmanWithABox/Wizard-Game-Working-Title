package com.example.wizardgame;

public class Spell{
    private Spells name;
    private SpellTypes type;
    private ElementalTypes element;
    private int base;
    private int level;

    public Spell(Spells name, SpellTypes type, ElementalTypes element, int base, int level){
        this.name = name;
        this.type = type;
        this.element = element;
        this.base = base;
        this.level = level;
    }


}
