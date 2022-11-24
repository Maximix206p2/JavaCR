package com.company;

import java.util.HashMap;
import java.util.Map;

//Flyweight — легковес
public class Mushrooms {
    public static void main(String[] args) {
        Micelium micelium = new Micelium();
        System.out.println(micelium.getMushroom(MushroomType.PennyBun, 1, 1));
        System.out.println(micelium.getMushroom(MushroomType.Russula, 2, 2));
        System.out.println(micelium.getMushroom(MushroomType.PennyBun, 3, 3));
    }
}

enum MushroomType {PennyBun, Russula, Honey} //Белый гриб, Сыроежка, Опёнок

class Mushroom {
    private MushroomType type;
    private int x;
    private int y;

    public MushroomType getType() {
        return type;
    }

    public void setType(MushroomType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Mushroom(MushroomType type) {
        this.type = type;
    }

}

class Micelium { //Mushrooms' fabric
    Map<MushroomType, Mushroom> mushroomMap = new HashMap<>(); //коллекция "map"

    public Mushroom getMushroom(MushroomType type, int x, int y) {
        Mushroom mushroom = mushroomMap.get(type);
        if (mushroom == null) {
            mushroom = new Mushroom(type);
            mushroomMap.put(type, mushroom);
        }
        mushroom.setX(x);
        mushroom.setY(y);
        return mushroom;
    }
    //cash - закладка на будущее, cashирование - сохранение
    //hash - функция преобразования String в int
    //collision
}