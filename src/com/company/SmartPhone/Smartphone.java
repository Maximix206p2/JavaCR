package com.company.SmartPhone;

public class Smartphone {
    //Компания
    private Company company;
    //Модель
    private String model;
    //Операционная система
    private OS os;
    //Размер экрана
    private double displaySize;
    //Вес
    private double weight;
    //Цвет
    //private String color;

    public String getSeller() {
        return seller;
    }

    private static String seller; //Продавец

    public static void setSeller(String seller) {
        Smartphone.seller = seller;
    }

    public Smartphone(Company company, String model, OS os, double displaySize, double weight) {
        this.company = company;
        this.model = model;
        this.os = os;
        this.displaySize = displaySize;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "company=" + company +
                ", model='" + model + '\'' +
                ", os=" + os +
                ", displaySize=" + displaySize +
                ", weight=" + weight +
                '}';
    }

    public Company getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public OS getOs() {
        return os;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public double getWeight() {
        return weight;
    }

    public Smartphone(Company company, String model) {
        this.company = company;
        this.model = model;
    }
}

enum Company{Samsung, Apple, Xiaomi, Sony}
enum OS{Android, IOS, Windows}