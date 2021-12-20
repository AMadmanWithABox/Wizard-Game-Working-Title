package com.example.wizardgame;

public class Creature {
    private ElementalTypes maintype;
    private ElementalTypes subtype;
    private Monsters monster;
    private int health;
    private int defense;
    private int mana;
    private int attack;

    public Creature(ElementalTypes maintype, ElementalTypes subtype, Monsters monster, int health, int defense, int mana, int attack){
        this.maintype = maintype;
        this.subtype = subtype;
        this.monster = monster;
        this.health = health;
        this.defense = defense;
        this.mana = mana;
        this.attack = attack;
    }
}
