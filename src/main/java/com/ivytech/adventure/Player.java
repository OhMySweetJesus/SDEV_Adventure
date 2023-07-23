package com.ivytech.adventure;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    // VARIABLES
    private int health;
    private int strength;
    private int magicPower;
    private int mana;
    private int physicalDefense;
    private int magicDefense;
    private ArrayList<Item> inventory = new ArrayList<>();

    // GETTERS
    public int getHealth() { return this.health; }
    public int getStrength() { return this.strength; }
    public int getMagicPower() { return this.magicPower; }
    public int getMana() { return this.mana; }
    public int getPhysicalDefense() { return this.physicalDefense; }
    public int getMagicDefense() { return this.magicDefense; }
    public ArrayList getInventory() { return this.inventory; }

    // SETTERS
    public void setHealth(int newHealth) { this.health = newHealth; }
    public void setStrength(int newStrength) { this.strength = newStrength; }
    public void setMagicPower(int newMagicPower) { this.magicPower = newMagicPower; }
    public void setMana(int newMana) { this.mana = newMana; }
    public void setPhysicalDefense(int newPhysicalDefense) { this.physicalDefense = newPhysicalDefense; }
    public void setMagicDefense(int newMagicDefense) { this.magicDefense = newMagicDefense; }
    public void setInventory(Item item) { inventory.add(item); }

    // CONSTRUCTORS
    Player() {
        this.health = 100;
        this.strength = 15; // TODO: Implement random number generator for strength + mana (1-20?)
        this.magicPower = 10;
        this.mana = 100;
        this.physicalDefense = 3;
        this.magicDefense = 15;
    }
    Player(int health, int strength, int magicPower, int mana, int physicalDefense, int magicDefense) {
        this.health = health;
        this.strength = strength;
        this.magicPower = magicPower;
        this.mana = mana;
        this.physicalDefense = physicalDefense;
        this.magicDefense = magicDefense;
    }

    // METHODS
    public int meleeAttack(int enemyDefense) {
        Random power = new Random();
        return (power.nextInt(this.strength) - enemyDefense);
    }

    public int magicAttack(int enemyMagicDefense) {
        Random power = new Random();
        return (power.nextInt(this.magicPower)- enemyMagicDefense);
    }

    public void guardPhysical(int enemyAttack) {
        Random defMax = new Random();
        int damage;
        int damageAvoided = defMax.nextInt(this.physicalDefense);

        if ((enemyAttack - damageAvoided) > 0)
            damage = enemyAttack - damageAvoided;
        else
            damage = 0;
        System.out.println("The enemy's attack did " + damage + " damage!");
        this.health -= damage;
    }
    public void guardMagic(int enemyAttack) {
        Random defMax = new Random();
        int damage;
        int damageAvoided = defMax.nextInt(this.magicDefense);

        if ((enemyAttack - damageAvoided) > 0)
            damage = enemyAttack - damageAvoided;
        else
            damage = 0;
        System.out.println("The enemy's attack did " + damage + " damage!");
        this.health -= damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
