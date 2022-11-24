package com.company;

//Builder (порождающий)
public class ThreeLittlePigs {
    public static void main(String[] args) {
        IBuilder nifNif = new NifNif();
        IBuilder nafNaf = new NafNaf();
        IBuilder nufNuf = new NufNuf();

        Director director = new Director();
        director.setBuilder(nifNif);
        director.buildBase();
        director.setBuilder(nufNuf);
        director.buildWalls();
        director.buildRoof();
    }
}

interface IBuilder { //interface (множественное наследование) vs abstract class (единичное наследование)
    void buildBase();
    void buildWalls();
    void buildRoof();
}

class NifNif implements IBuilder{

    @Override
    public void buildBase() {
        System.out.println("soil base");
    }

    @Override
    public void buildWalls() {
        System.out.println("clay walls");
    }

    @Override
    public void buildRoof() {
        System.out.println("straw roof");
    }
}
class NafNaf implements IBuilder{

    @Override
    public void buildBase() {
        System.out.println("sand base");
    }

    @Override
    public void buildWalls() {
        System.out.println("sticks walls");
    }

    @Override
    public void buildRoof() {
        System.out.println("leaves roof");
    }
}
class NufNuf implements IBuilder{

    @Override
    public void buildBase() {
        System.out.println("concrete base");
    }

    @Override
    public void buildWalls() {
        System.out.println("bricks walls");
    }

    @Override
    public void buildRoof() {
        System.out.println("tile roof");
    }
}

class Director{
    private IBuilder builder;

    public void setBuilder(IBuilder builder) {
        this.builder = builder;
    }

    public void buildBase(){
        builder.buildBase();
    }
    public void buildWalls(){
        builder.buildWalls();
    }
    public void buildRoof(){
        builder.buildRoof();
    }
}