package com.company.simple;

public class Pen { //Informal, POJO
    private Colors color;

    public Pen(Colors color) { //Инициализирующий конструктор (code > Generate > Ok)
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }
}
