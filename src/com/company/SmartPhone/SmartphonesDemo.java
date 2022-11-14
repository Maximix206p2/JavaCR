package com.company.SmartPhone;

public class SmartphonesDemo {
    public static void main(String[] args) {
        Smartphone.setSeller("Рога и копыта");
        //Статическое поле относится не к объекту, а к классу
        //Статический метод
        Smartphone smartphone = new Smartphone(Company.Apple, "iPhone 13", OS.IOS, 6, 200);
        System.out.println(smartphone.getSeller());
    }
}
