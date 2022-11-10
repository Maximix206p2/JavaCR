package com.company.animals;

public class AnimalSchool { //https://www.linkedin.com/pulse/animal-school-beautiful-story-intelligence-niranjana-iyer
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        rabbit.run();
        Squirrel squirrel = new Squirrel();
        squirrel.climb();
    }
}

interface Running{ //Printing, Visible
    void run();
}
interface Swimming{ //Interface vs abstract class
    void swim();
}
interface Climbing{
    void climb();
}
class Rabbit implements Running, Swimming{
    @Override
    public void run() {
        System.out.println("rabbit runs");
    }

    @Override
    public void swim() {
        System.out.println("rabbit swims");
    } //множественное наследование
}
class Squirrel implements Running, Climbing{
    @Override
    public void run() {
        System.out.println("squirrel runs");
    }
    @Override
    public void climb() {
        System.out.println("squirrel climbs");
    }
}