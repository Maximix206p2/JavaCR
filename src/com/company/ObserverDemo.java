package com.company;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

//Observer pattern
public class ObserverDemo {
    public static void main(String[] args) {
        Child child = new Child();
        Mother mother = new Mother();
        child.addObserver(mother);
        child.make();
    }
}

class Child extends Observable { //до 8 || 9-ой версии java

    public void make(){
        setChanged();
        notifyObservers();
    }
}

class Mother implements Observer{
    private Child child;

    @Override
    public void update(Observable o, Object arg) {
        if (o==child)
            System.out.println("mother is observing");
    }
}