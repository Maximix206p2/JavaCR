package com.company;

/*
Контрольная работа:
1. Вывести паттерн в виде треугольника заданной высоты:
             *
           *  *
          *    *
         ********
2. Номиналы белорусских монет: 1,2,5,10,20,50.
Дана сумма сдачи: 51..99 копеек.
Выдать сдачу минимальным количеством монет.
 */
public class JavaCR2 {
    public static void main(String[] args) {
        //1
        int count = 5;
        for (int row = 1; row <= count; row++) {
            for (int i = count - 1; i >= row; i--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j < row; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        //2
        int cops = 99;
        System.out.println(cops);
        while (cops - 50 >= 0) {
            System.out.printf("%d - 50 = %d", cops, cops - 50);
            cops -= 50;
            System.out.println();
        }
        while (cops - 20 >= 0) {
            System.out.printf("%d - 20 = %d", cops, cops - 20);
            cops -= 20;
            System.out.println();
        }
        while (cops - 10 >= 0) {
            System.out.printf("%d - 10 = %d", cops, cops - 10);
            cops -= 10;
            System.out.println();
        }
        while (cops - 5 >= 0) {
            System.out.printf("%d - 5 = %d", cops, cops - 5);
            cops -= 5;
            System.out.println();
        }
        while (cops - 2 >= 0) {
            System.out.printf("%d - 2 = %d", cops, cops - 2);
            cops -= 2;
            System.out.println();
        }
        while (cops - 1 >= 0) {
            System.out.printf("%d - 1 = %d", cops, cops - 1);
            cops -= 1;
            System.out.println();
        }
    }
}
