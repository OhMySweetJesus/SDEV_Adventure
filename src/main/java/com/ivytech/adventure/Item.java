package com.ivytech.adventure;

public class Item {
    // VARIABLES
    private int weight;
    private int attackPower;
    private int defensePower;
    private int healthPointRecoveryAmount;

    // GETTERS
    public int getWeight() { return this.weight; }
    public int getAttackPower() { return this.attackPower; }
    public int getDefensePower() { return this.defensePower; }
    public int getHealthPointRecoveryAmount() { return this.healthPointRecoveryAmount; }

    // SETTERS
    public void setWeight(int weight) { this.weight = weight; }
    public void setAttackPower(int attackPower) { this.attackPower = attackPower; };
    public void setDefensePower(int defensePower) { this.defensePower = defensePower; }
    public void setHealthPointRecoveryAmount(int healthPointRecoveryAmount) { this.healthPointRecoveryAmount = healthPointRecoveryAmount;}

    // CONSTRUCTORS
    Item() {
        this.weight = 1;
        this.attackPower = 0;
        this.defensePower = 0;
        this.healthPointRecoveryAmount = 0;
    }

    Item(int weight, int attackPower, int defensePower, int healthPointRecoveryAmount) {
        this.weight = weight;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.healthPointRecoveryAmount = healthPointRecoveryAmount;
    }

    // METHODS
    // I've realized that all methods can be replaced with one of the getters
}
