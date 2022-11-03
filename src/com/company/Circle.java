package com.company.figures;

//Инкопсуляция
public class Circle extends Figure {
    private double radius; //Радиус круга

    public double area() {
        return Math.PI * radius * radius;
    }

    public double length() {
        return 2 * Math.PI * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
