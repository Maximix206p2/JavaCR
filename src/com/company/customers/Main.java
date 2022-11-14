package com.company.customers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Aaa", 100);
        Customer customer2 = new Customer("Ccc");
        Customer customer3 = new Customer("Bbb");

        Customers customers = new Customers();
        customers.addCustomer(customer1,0);
        customers.addCustomer(customer2,1);
        customers.addCustomer(customer3,2);

        customers.sort();
        customers.print();
        customers.printSomeNumbers(0,101); //(100,101)
    }
}

class Customers{
    private Customer[] customers = new Customer[3];

    public void addCustomer(Customer customer, int index){
        customers[index] = customer;
    }

    public void sort(){
        Comparator<Customer> comparator = (c1, c2) -> c1.getSurname().compareTo(c2.getSurname());
        Arrays.sort(customers, comparator);
    }

    public void print(){
        for (Customer customer:customers)
            System.out.println(customer.toString());
    }

    public void printSomeNumbers(long begin, int end){
        for (Customer customer : customers)
            if (customer.getNumber()>begin && customer.getNumber()<=end)
            System.out.println(customer.toString());
    }
}