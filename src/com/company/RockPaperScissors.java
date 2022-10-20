package com.company;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x1 = "";
        while ((true)) {
            int a = (int) (Math.random() * 3) + 1;
            switch (a) {
                case 1:
                    x1 = "rock";
                    break;
                case 2:
                    x1 = "paper";
                    break;
                case 3:
                    x1 = "scissors";
                    break;
            }
            System.out.printf("Enter number : 1 - rock, 2 - paper, 3 - scissors: ");
            int b = sc.nextInt();
            System.out.println("My choice is " + x1);
            if (a == b)
                System.out.println("draw");
            else if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2))
                System.out.println("you loose");
            else System.out.println("you won!");
        }
    }
}