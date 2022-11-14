package com.company.customers;

public class Customer {
    String surname;
    long number;

    @Override
    public String toString() {
        return "Customer{" +
                "surname='" + surname + '\'' +
                ", number=" + number +
                '}';
    }

    public Customer(String surname, long number){
        this.surname = surname;
        this.number = number;
    }

    public Customer(String surname){
        this.surname = surname;
        this.number = -1;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
