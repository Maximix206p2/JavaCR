package com.company.bounded;

public class MagicBoxBoundedDemo {
    public static void main(String[] args) {
        MagicBoxBounded<Pigeon> magicBoxBounded = new MagicBoxBounded<>();
        magicBoxBounded.setObject(new Pigeon());
        System.out.println(magicBoxBounded.getObject());
    }
}

interface IMagicPrinter<T>{
    void print(T object);
}

class MagicPrinter<T> implements IMagicPrinter<T>{
    @Override
    public void print(T object){

    }

}

class MagicBoxBounded<T extends Bird>{
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
