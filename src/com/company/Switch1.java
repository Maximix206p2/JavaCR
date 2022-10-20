package com.company;

public class Switch1 {

    public static void main(String[] args) {
        int mark = 0;
        switch (mark){
            case 1:
                System.out.println("very bad");
                break;
            case 2:
                System.out.println("bad");
                break;
            case 3:
                System.out.println("satisfactory");
                break;
            case 4:
                System.out.println("good");
                break;
            case 5:
                System.out.println("perfect!");
                break;
            default:
                System.out.println("undefined");
        }
    }
}
