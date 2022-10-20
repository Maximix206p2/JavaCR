package com.company;

public class Taylor {
    public static void main(String[] args) {
        double x = Math.PI / 6;
        double y = Math.sin(x);
        System.out.println(y);

        double eps = 1e-5, sum = x, a = x;
        int i = 1;
        while (Math.abs(a) > eps) {
            a *= -x * x / (i + 1) / (i + 2);
            i += 2;
            sum += a;
        }
        System.out.println(sum);
    }
}
