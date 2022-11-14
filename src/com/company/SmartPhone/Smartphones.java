package com.company.SmartPhone;

import java.util.LinkedList;

//Каталог смартфонов
public class Smartphones {
    private LinkedList<Smartphone> smartphones = new LinkedList<>();

    public void add(Smartphone smartphone){
        smartphones.add(smartphone);
    }

    public void printCompany(Company company){
        for (Smartphone smartphone:smartphones)
        if (smartphone.getCompany().equals(company))
            System.out.println(smartphone);
    }
}
