package com.company.simple;

class Car {
    private Colors color;

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Car(Colors color) {
        this.color = color;
    }

    @Override
    public String toString() {
        //return "Car{"+"color="+ color+ '}';
        return String.format("Car{color=%s}", color);
    }
}
