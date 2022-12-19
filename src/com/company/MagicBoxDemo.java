package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicBoxDemo {
    public static void main(String[] args) {
        MagicBox magicBox = new MagicBox();
        magicBox.setObject(1); //Integer
        //
        Object object = magicBox.getObject();
        //Можно ли узнать его тип?
        Class clazz = object.getClass();
        System.out.println(clazz);
        //
        System.out.println(magicBox.getObject());
        magicBox.setObject("2"); //String
        System.out.println(magicBox.getObject());
        magicBox.setObject('Y'); //Char
        System.out.println(magicBox.getObject());
        magicBox.setObject(2.32); //Double
        System.out.println(magicBox.getObject());
        magicBox.setObject(new ArrayList<String>(Arrays.asList("focus","pocus","spell"))); //Collection
        System.out.println(magicBox.getObject());

        MagicBoxGeneric<Number> magicBoxGeneric = new MagicBoxGeneric<>();
        magicBoxGeneric.setObject(1234);

        MagicBoxGeneric <MagicBoxGeneric<Number>> magicBoxGeneric1 = new MagicBoxGeneric();
        magicBoxGeneric1.setObject(magicBoxGeneric);
        System.out.println(magicBoxGeneric1.getObject().getObject());
    }
}

class MagicBox{
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

class MagicBoxGeneric<T>{ //Синтаксический сахар
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}