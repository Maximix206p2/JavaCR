package com.company;

//Chain of responsibility (Цепочка обязанностей)
public class RoosterAndBeenSeed {
    public static void main(String[] args) {
        Hen hen = new Hen();
        Cow cow = new Cow();
        Mower mower = new Mower();
        hen.setNextHelper(cow);
        cow.setNextHelper(mower);

        hen.help();
    }
}

abstract class Helper {
    Helper nextHelper;

    void setNextHelper(Helper helper) {
        nextHelper = helper;
    }

    public void help() {
        sendMessage();
        if (nextHelper != null)
            nextHelper.help();
    }
    abstract void sendMessage();
}

class Hen extends Helper{
    @Override
    void sendMessage() {
        System.out.println("Курица – корове: дай маслица");
    }
}

class Cow extends Helper{
    @Override
    void sendMessage() {
        System.out.println("Корова – косарям: дай сена");
    }
}

class Mower extends Helper{
    @Override
    void sendMessage() {
        System.out.println("Косари – печке: дай калачей");
    }
}