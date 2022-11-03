package com.company.figures;

public class Rectangle extends Figure {
    private double a;
    private double b; //Длины сторон

    public double area() {
        return a*b;
    }

    public double length() {
        return (a+b)*2;
    }

    public double setA(double a) {
        return a;
    }
    public double setB(double b) {
        return b;
    }
}
