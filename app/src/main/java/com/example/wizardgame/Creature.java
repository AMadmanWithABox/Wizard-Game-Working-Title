package com.example.wizardgame;

public class Creature {
    elementaltype maintype;
    elementaltype subtype;
    Monsterz monster;
    int HP;
    int DEF;
    int MP;
    int ATK;
}
enum elementaltype{
    Fire, Ice, Oze, Water, Earth, Air, Life, Metal, Steam, Poison, Lightning, Sound, Soul, Light, Dark, Gravity, Wild, Null
}

enum Monsterz{
    Goblin, Slime, Ogre, Dragon
}
