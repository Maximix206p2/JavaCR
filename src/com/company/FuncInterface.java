package com.company;

import java.util.ArrayList;
import java.util.List;

public class FuncInterface {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Iron iron = new Iron();
        Button button = new Button();
        button.add(lamp);
        button.add(iron);
        button.turnOn();
    }
}

@FunctionalInterface //имеет один метод
interface Switchable {
    void switchOn();
}

class Lamp implements Switchable{
    @Override
    public void switchOn(){
        System.out.println("Lamp is turn on");
    }
}

class Iron implements Switchable{

    private final static double temp;
    //чем отличается final от private

    static {   //лучше в конструкторе
        temp = 100;
    }

    @Override
    public void switchOn(){
        System.out.println("Iron is turn on");
    }
}

class Button{ //управляющий класс
    Switchable device;
    List<Switchable> devices = new ArrayList<>();

    public void turnOn(){
        //device.switchOn();
        for (Switchable device:devices)
            device.switchOn();
    }

    public void setDevice(Switchable device) {
        this.device = device;
    }

    public void add(Switchable device){
        devices.add(device);
    }
}

/*  this, super
    functional interface
    лямбда выражение
    ссылочные тип interface, class, enum
    GUI     */