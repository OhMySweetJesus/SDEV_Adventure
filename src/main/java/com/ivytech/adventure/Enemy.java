package com.ivytech.adventure;

import java.util.Random;

public class Enemy {
    // VARIABLES
    private int health;
    private int strength;
    private int magicPower;
    private int mana;
    private int physicalDefense;
    private int magicDefense;

    // GETTERS
    public int getHealth() { return this.health; }
    public int getStrength() { return this.strength; }
    public int getMagicPower() { return this.magicPower; }
    public int getMana() { return this.mana; }
    public int getPhysicalDefense() { return this.physicalDefense; }
    public int getMagicDefense() { return this.magicDefense; }

    // SETTERS
    public void setHealth(int newHealth) { this.health = newHealth; }
    public void setStrength(int newStrength) { this.strength = newStrength; }
    public void setMagicPower(int newMagicPower) { this.magicPower = newMagicPower; }
    public void setMana(int newMana) { this.mana = newMana; }
    public void setPhysicalDefense(int newPhysicalDefense) { this.physicalDefense = newPhysicalDefense; }
    public void setMagicDefense(int newMagicDefense) { this.magicDefense = newMagicDefense; }

    // CONSTRUCTORS
    Enemy() {
        this.health = 15;
        this.strength = 5; // TODO: Implement random number generator for strength + mana (1-20?)
        this.magicPower = 1;
        this.mana = 10;
        this.physicalDefense = 1;
        this.magicDefense = 1;
    }
    Enemy(int health, int strength, int magicPower, int mana, int physicalDefense, int magicDefense) {
        this.health = health;
        this.strength = strength;
        this.magicPower = magicPower;
        this.mana = mana;
        this.physicalDefense = physicalDefense;
        this.magicDefense = magicDefense;
    }

    // METHODS
    public int meleeAttack(int playerDefense) {
        Random power = new Random();
        return (power.nextInt(this.strength) - playerDefense);
    }

    public int magicAttack(int playerMagicDefense) {
        Random power = new Random();
        return (power.nextInt(this.magicPower)- playerMagicDefense);
    }

    public void guardPhysical(int playerAttack) {
        Random defMax = new Random();
        int damage;
        int damageAvoided = defMax.nextInt(this.physicalDefense);

        if ((playerAttack - damageAvoided) > 0)
            damage = playerAttack - damageAvoided;
        else
            damage = 0;
        System.out.println("The player's attack did " + damage + " damage!");
        this.health -= damage;
    }
    public void guardMagic(int playerAttack) {
        Random defMax = new Random();
        int damage;
        int damageAvoided = defMax.nextInt(this.magicDefense);

        if ((playerAttack - damageAvoided) > 0)
            damage = playerAttack - damageAvoided;
        else
            damage = 0;
        System.out.println("The player's attack did " + damage + " damage!");
        this.health -= damage;
    }
    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
