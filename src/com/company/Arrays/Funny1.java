package com.company.Arrays;

public class Funny1 {
    public static void main(String[] args) {
        /*int n = 1;
        for (int i = 1; i < 8; i++) {
            String left = String.format("%d * %d = ", n, n);
            System.out.printf("%20s%d%n", left, (long) n * n);
            n += Math.pow(10, i);
        }*/
        String c = "5";
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += c;
            String left = String.format("%s * %s = ", c, s);
            System.out.printf("%20s%d%n", left, Long.parseLong(s)*5);

        }
    }
}
