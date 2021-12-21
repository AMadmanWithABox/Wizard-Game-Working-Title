package com.example.wizardgame;

import java.util.ArrayList;

public class ListOfSpells {
    private ArrayList<Spell> spells = new ArrayList<>();

    public ListOfSpells(){
        generateSpells();
    }
    public void generateSpells(){
        //story
        spells.add(new Spell(Spells.Portal, SpellTypes.Attack, ElementalTypes.Gravity, 10, 0));
        spells.add(new Spell(Spells.Broom, SpellTypes.Attack, ElementalTypes.Null, 1, 0));
        spells.add(new Spell(Spells.SelfIllusion, SpellTypes.Barrier, ElementalTypes.Sound, 1, 0));
        spells.add(new Spell(Spells.Snowball, SpellTypes.Attack, ElementalTypes.Ice, 5, 0));
        spells.add(new Spell(Spells.BooksPower, SpellTypes.Investiture, ElementalTypes.Wild, 7, 0));
        spells.add(new Spell(Spells.MinorIllusion, SpellTypes.AttackingInvestiture, ElementalTypes.Sound, 3, 0));
        spells.add(new Spell(Spells.PlaceHolder11, SpellTypes.Null, ElementalTypes.Null, 0, 0));
        spells.add(new Spell(Spells.PlaceHolder12, SpellTypes.Null, ElementalTypes.Null, 0, 0));
        spells.add(new Spell(Spells.PlaceHolder13, SpellTypes.Null, ElementalTypes.Null, 0, 0));
        spells.add(new Spell(Spells.PlaceHolder14, SpellTypes.Null, ElementalTypes.Null, 0, 0));
        spells.add(new Spell(Spells.PlaceHolder15, SpellTypes.Null, ElementalTypes.Null, 0, 0));
        spells.add(new Spell(Spells.PlaceHolder16, SpellTypes.Null, ElementalTypes.Null, 0, 0));
        //fire
        spells.add(new Spell(Spells.FireBolt, SpellTypes.Attack, ElementalTypes.Fire, 10, 1));
        spells.add(new Spell(Spells.CreateBonFire, SpellTypes.Vampiric, ElementalTypes.Fire, 8, 1));
        spells.add(new Spell(Spells.FireBlade, SpellTypes.AttackingInvestiture, ElementalTypes.Fire, 3,1));
        spells.add(new Spell(Spells.Fireball, SpellTypes.Attack, ElementalTypes.Fire, 20, 2));
        spells.add(new Spell(Spells.FireShield, SpellTypes.Barrier, ElementalTypes.Fire, 1, 2));
        spells.add(new Spell(Spells.SummonHellHound, SpellTypes.Summon, ElementalTypes.Fire, 5, 2));
        spells.add(new Spell(Spells.CrimsonRose, SpellTypes.Attack, ElementalTypes.Fire, 30, 3));
        spells.add(new Spell(Spells.InvestitureOfHeat, SpellTypes.Investiture, ElementalTypes.Fire, 5, 3));
        spells.add(new Spell(Spells.SummonFireElemental, SpellTypes.Summon, ElementalTypes.Fire, 10, 3));
        //ice
        spells.add(new Spell(Spells.Frostbite, SpellTypes.Attack, ElementalTypes.Ice, 10, 1));
        spells.add(new Spell(Spells.ConeOfCold, SpellTypes.TailWhipping, ElementalTypes.Ice, 1, 1));
        spells.add(new Spell(Spells.Freeze, SpellTypes.TailWhip, ElementalTypes.Ice, 2, 1));
        spells.add(new Spell(Spells.IceKnife, SpellTypes.Attack, ElementalTypes.Ice, 20, 2));
        spells.add(new Spell(Spells.WallOfIce, SpellTypes.TailWhipping, ElementalTypes.Ice, 2, 2));
        spells.add(new Spell(Spells.IceArmor, SpellTypes.Barrier, ElementalTypes.Ice, 1, 2));
        spells.add(new Spell(Spells.Blizzard, SpellTypes.Attack, ElementalTypes.Ice, 30, 3));
        spells.add(new Spell(Spells.InvestitureOfCold, SpellTypes.Investiture, ElementalTypes.Ice, 5, 3));
        spells.add(new Spell(Spells.SummonIceElemental, SpellTypes.Summon, ElementalTypes.Ice, 10, 3));
        //oze
        spells.add(new Spell(Spells.AcidSplash, SpellTypes.Attack, ElementalTypes.Oze, 10, 1));
        spells.add(new Spell(Spells.Hunger, SpellTypes.TailWhip, ElementalTypes.Oze, 2, 1));
        spells.add(new Spell(Spells.SummonBabySlime, SpellTypes.Summon, ElementalTypes.Oze, 0, 1));
        spells.add(new Spell(Spells.AbsorbElements, SpellTypes.Barrier, ElementalTypes.Oze, 1, 2));
        spells.add(new Spell(Spells.AcidArrow, SpellTypes.Attack, ElementalTypes.Oze, 20, 2));
        spells.add(new Spell(Spells.Clone, SpellTypes.Heal, ElementalTypes.Oze, 15, 2));
        spells.add(new Spell(Spells.SummonSlime, SpellTypes.Summon, ElementalTypes.Oze, 5, 2));
        spells.add(new Spell(Spells.AcidRain, SpellTypes.Attack, ElementalTypes.Oze, 30, 3));
        spells.add(new Spell(Spells.InvestitureOfSlime, SpellTypes.Investiture, ElementalTypes.Oze, 5, 3));
        spells.add(new Spell(Spells.SummonGreaterSlime, SpellTypes.Summon, ElementalTypes.Oze, 10, 3));

    }
    //attack 1:10 2:20 3:30
    //heal 1:10 2:15 3:20
    //barrier 1:0 2:1 3:2
    //vampiric 1:8 2:16 3:24
    //attackinginvestiture 1:3 2:4 3:5
    //summon 1:0 2:5 3:10
    //investiture 3:5
    //tailwhip 1:2 2:3 3:4
    //tailwhipping 1:1 2:2 3:3
}
