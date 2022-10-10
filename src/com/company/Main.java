package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //1
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            default:
                System.out.println("I don't know");
                break;
        }
        //2
        int a = 1, d2 = 0, d3 = 0;
        while (d2 + d3 != 10) {
            if (a % 2 == 0) {
                d2++;
                a++;
            }
            else if (a % 3 == 0) {
                d3++;
                a++;
            }
        }
        System.out.printf("Делятся на 2: %d%nДелятся на 3: %d", d2, d3);
    }
}