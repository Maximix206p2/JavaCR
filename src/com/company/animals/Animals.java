package com.company.animals;

import java.util.LinkedList;
import java.util.List;

public class Animals {
    public static void main(String[] args) {
        //Animal[] animals = {new Cat(), new Dog()};
        Animal[] animals = new Animal[3];
        animals[0] = new Cat(); //anonymous object
        animals[1] = new Dog();
        animals[2] = new Mouse();
        for (Animal animal:animals) animal.sound();

        //LinkedList, ArrayList
        List<Animal> animalsList = new LinkedList<>(); //diamond
        animalsList.add(new Cat());
        animalsList.add(new Dog());
        animalsList.add(new Mouse());
        for (Animal animal:animalsList) animal.sound(); //полиморфизм
    }
}

//GUI, CLI

abstract class Animal{
    abstract public void sound();
}

class Cat extends Animal{

    @Override
    public void sound() {
        System.out.println("meow");
    }
}
class Dog extends Animal{

    @Override
    public void sound() {
        System.out.println("woof");
    }
}

class Mouse extends Animal{

    @Override
    public void sound() {
        System.out.println("squeck");
    }
}