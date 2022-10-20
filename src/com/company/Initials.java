package com.company;

import java.util.Scanner;

public class Initials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your first name: ");
        String first = scanner.nextLine();
        System.out.println("Input your last name: ");
        String last = scanner.nextLine();

        System.out.printf("Your initials are: %c.%c.%n", first.charAt(0), last.charAt(0));
    }
}
