package com.company;

public class StackTrace {
    public static void main(String[] args) {
        call();
    }

    static void call(){
        Exception e = new Exception();
        e.printStackTrace();
        String message = e.getStackTrace()[1].getClassName();
        System.out.println(message);

        message = e.getStackTrace()[1].getMethodName();
        System.out.println(message);

        int number = e.getStackTrace()[1].getLineNumber();
        System.out.println(number);
    }
}
