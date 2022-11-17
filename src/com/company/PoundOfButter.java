package com.company;

//Factory method – порождающий шаблон – используется, когда какой-то вспомогательный класс создаёт объект
//Делегировать
//patterns — шаблоны(собеседование)
public class PoundOfButter {

    public static void main(String[] args) {
        Producer farmer = new Farmer();
        Producer backer = new Backer();
        Judge judge = new Judge();

        Product bread = backer.make(1);
        Product butter = farmer.make(bread.getWeight());
        Product decision = judge.make(0);

        System.out.println("butter: " + butter.getWeight());
        System.out.println("bread: " + bread.getWeight());
        System.out.println(((Decision) decision).getDecision());
    }
}

interface Product {
    double getWeight();

    void setWeight(double weight);
}

class Butter implements Product {
    private double weight;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Bread implements Product {
    private double weight;

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Decision implements Product {

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void setWeight(double weight) {
    }

    public String getDecision() {
        return "Don't try to cheat";
    }
}

interface Producer {
    Product make(double weight);
}

class Farmer implements Producer {

    @Override
    public Product make(double weight) {
        Butter butter = new Butter();
        butter.setWeight(weight);
        return butter;
    }
}

class Backer implements Producer {

    @Override
    public Product make(double weight) {
        Bread bread = new Bread();
        bread.setWeight(Math.random() * 0.1 + 0.9);
        return bread;
    }
}

class Judge implements Producer {

    @Override
    public Product make(double weight) {
        Decision decision = new Decision();
        return decision;
    }
}