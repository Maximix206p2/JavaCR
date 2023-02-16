package com.company.basic;

import java.util.Scanner;

//https://www.w3resource.com/java-exercises/basic/index.php
public class Basic {
    public static void main(String[] args) {
        task7(35);
    }

    public static int[] task7(int num1) {
        /*Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num1 = in.nextInt();*/

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println(num1 + " x " + (i + 1) + " = " +
                    (num1 * (i + 1)));
            arr[i] = num1 * (i + 1);
        }
        return arr;
    }
    public static void task8(){
        System.out.println("   J    a   v     v  a ");
        System.out.println("   J   a a   v   v  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa");
        System.out.println(" JJ  a     a   V  a     a");
    }

    public static boolean task54(int p, int q, int r){
        return (p % 10 == q % 10) || (p % 10 == r % 10) || (q % 10 == r % 10);
    }
}
