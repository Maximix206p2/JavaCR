package com.company;

import java.util.Scanner;

public class UserExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number from 1 to 9:");
        int a = scanner.nextInt();
        try {
            validateNumber(a);
        } catch (FromOneToNineException e) {
            e.printStackTrace();
        }
    }

    static void validateNumber(int a) throws FromOneToNineException {
        //if (a<1 || a >9) throw new FromOneToNineException("From 1 to 9, please");
        if (a%2!=0) throw new FromOneToNineException("/2, please");
    }
}

class FromOneToNineException extends Exception{ //Обычно в отдельном файле
    public FromOneToNineException(String message) {
        super(message);
    }
}