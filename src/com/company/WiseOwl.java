package com.company;

//Шаблоны: порождающие, поведенческие, структурные
//Singleton — одиночка
public class WiseOwl {
    public static void main(String[] args) {
        Singleton owl = Singleton.getInstance();
        System.out.println(owl);
        Singleton owl2 = Singleton.getInstance();
        System.out.println(owl2);
    }
}

class Singleton{
    private static Singleton instance = new Singleton();
    private int wisdom = 0;

    private Singleton(){
        System.out.println("There was an old owl");
    }

    public static Singleton getInstance(){
        return instance;
    }

    public void incWisdom(){
        wisdom++;
    }

    public int getWisdom() {
        return wisdom;
    }
}