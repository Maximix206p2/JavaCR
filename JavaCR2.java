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
    }
}