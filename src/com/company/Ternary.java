package com.company;

import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {
        //угадай число
        int a2 = (int) (Math.random()*100+1);
        //System.out.println(a);
        int b2 = 0;
        Scanner scanner = new Scanner(System.in);
        while (a2 != b2){
            System.out.println("Enter a number: ");
            b2 = scanner.nextInt();
            if (a2 > b2) System.out.println("greater");
            else if (a2 == b2) break;
            else System.out.println("less");
        }
        System.out.println("You are right!");
        //1
        int age = 17;
        System.out.println(age < 18 ? "denied" : "legalized");
        //2 заглавные и строчные буквы
        System.out.printf("%d, %d, %d, %d%n", (int) 'a', (int) 'z', (int) 'A', (int) 'Z');
        //System.out.printf("%d, %d, %d, %d%n", (int) 'а', (int) 'я', (int)'А', (int)'Я');
        char ch = 'b';
        String answer = (int) ch >= 97 && (int) ch <= 122 ? "lowercase" :
                (int) ch >= 65 && (int) ch <= 90 ? "uppercase" : "not a letter";
        System.out.println(answer);
        //3
        int a = 1, b = 3, c = 2;
        //int max = a > b ? b > c ? a : a > c ? a : c : a > c ? b : b > c ? b : c;
        int max =   a > b && a > c ? a:
                    b > a && b > c ? b:
                    c > a && c > b ? c: 0;
        System.out.println(max);
    }
}
