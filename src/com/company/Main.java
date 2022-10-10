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
        int d2 = 0, d3 = 0;
        for (int i=0; i<11; i++) {
            if (i % 2 == 0) {
                d2++;
            }
            else if (i % 3 == 0) {
                d3++;
            }
        }
        System.out.printf("Делятся на 2: %d%nДелятся на 3: %d", d2, d3);
    }
}
