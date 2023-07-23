package com.ivytech.adventure;

public class Animal extends Enemy {
    // VARIABLES
    String color;
    int height;
    int weight;

    // GETTERS
    String getColor() { return this.color; }
    int getHeight() { return this.height; }
    int getWeight() { return this.weight; }

    // SETTERS
    void setColor(String color) { this.color = color; }
    void setHeight(int height) { this.height = height; }
    void setWeight(int weight) { this.weight = weight; }

    // CONSTRUCTORS
    Animal() {
        this.height = 2;
        this.weight = 50;
        this.color = "grey";
    }
    Animal(String color, int height, int weight) {
        this.color = color;
        this.height = height;
        this.weight = weight;
    }

    void growl() {
        System.out.println("GRRRRRR");
    }
}
