package com.company.simple;

public class SimpleClasses {
    public static void main(String[] args) { //namespace, struct, union

        Pen pen = new Pen(Colors.Red);
        System.out.println(pen.getColor());

        Car car = new Car(Colors.Gray);
        System.out.println(car.toString());

        Mixer mixer = new Mixer();
        mixer.setValues(5,1);
        System.out.println(mixer.getTemp());
    }
}

