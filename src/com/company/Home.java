package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

//Умение конструировать код и распознавать код
public class Home {
    public static void main(String[] args) {
        //ArrayList of LinkedList
        //System.out.println(generateString(3,6));
        //Упаковка
        ArrayList<LinkedList<String>> bigBox = new ArrayList<>();
        for (int i=0; i<5; i++){
            LinkedList<String> smallBox = new LinkedList<>();
            for (int j=0; j<5; j++)
                smallBox.add(generateString(3,6));
            bigBox.add(smallBox);
        }

        //Изменение элементов (2-ой маленькой коробки, 3-его элемента)
        bigBox.get(2).set(3,"elem");

        //Замена маленькой коробки
        LinkedList<String> box = new LinkedList<>();
        for (int i = 0; i<5; i++)
            box.add("s");

        bigBox.set(2,box);

        //Распаковка
        for (LinkedList<String> smallBox:bigBox) {
            for (String s : smallBox)
                System.out.print(s + " ");
            System.out.println();
        }
    }

    //Сгенерировать случайную строку
    public static String generateString(int minCount, int maxCount){
        Random random = new Random();
        //Получить случайное число от minCount до maxCount
        int count = random.nextInt(maxCount-minCount)+minCount;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; i++){
            char c = (char)(random.nextInt((int)'z'-(int)'a')+'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
