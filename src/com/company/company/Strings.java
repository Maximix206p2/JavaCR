package com.company;
import java.sql.SQLOutput;

public class Strings {
    public static void main(String[] args) {
        String s1 = "first", s2 = "second";
        System.out.println(s1.compareTo(s2));
        String s3 = "fir";
        System.out.println(s1.contains(s3));

        String left = s1.substring(2, 4);
        System.out.println(left);

        //Собрать строку из символов
        char c1 = '2', c2 = '\u00B7', c3 = '\u03C0', c4 = '=', c5 = '1',
                c6 = '8', c7 = '0', c8 = '\u00B0';
        String s4 = "" + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
        System.out.println(s4);
        System.out.printf("Symbol: %c, number: %d%n", c2, (int) c2);

        //String s5 = s1+s2;
        StringBuilder sb2 = new StringBuilder(s1);
        sb2.append(s2);
        String s5 = sb2.toString();

        //String s5 = s1.concat(s4);
        System.out.println(sb2);

        //Содержит ли строка только цифры
        System.out.println(isOnlDigits("123a"));

        //Хеш код строки
        System.out.println(s1.hashCode());

        //Заменить символ в стоке
        String s6 = "machine.cbp.";
        String s7 = s6.replace('.','!');
        String s8 = s6.replaceFirst("[c]", "s");
        System.out.println(s7);
        System.out.println(s8);

        String s9 = "{w}{{sdf}}";
        String s10 = s9.replaceAll("[{}]", "");
        System.out.println(s10);

        s9 = "    wo    srd    ";
        s9 = s9.trim();
        System.out.println(s9);
    }

    static boolean isOnlDigits(String s) {
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                return false;
        return true;
    }
}
