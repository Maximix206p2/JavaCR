package com.company.specialNumbers;

public class Balanced {
    public static void main(String[] args) {
        /*
        Сбалансированные числа: сумма цифр слева от середины равна сумме цифр справа от середины.
        Вывести первые 10 4-значных сбалансированных чисел.
        */
        int a=1000, count = 0;
        while (count < 10) {
            String s = Integer.toString(a);
            int l = s.length();
            int left = 0, right = 0;
            for (int i = 0; i < l / 2; i++) {
                Character c = s.charAt(i);
                int d = Integer.parseInt(c.toString());
                left += d;
            }
            int e = l % 2 == 1 ? 1 : 0;
            for (int i = l / 2 + e; i < l; i++) {
                Character c = s.charAt(i);
                int d = Integer.parseInt(c.toString());
                right += d;
            }
            if(left == right) {
                System.out.println(a);
                count++;
            }
            a++;
        }
    }
}
