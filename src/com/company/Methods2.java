package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
public class Methods2 {
    public static void main(String[] args) {
        System.out.println(isPrime(5));
        for (int elem : calcFactors(24))
            if (elem != 0) System.out.println(elem);
        Object[] arr = new Object[5];
        arr[0] = 1;
        arr[1] = "str";
/*
            for (Object elem:arr)
                System.out.println(elem);

 */
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(deleteStrings(arr)));

        String s = "Java: How to check if object is null";
        System.out.println(countVowels(s));
    }

    static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) result = false;
        return result;
    }

    //Определить все множители числа (а не только простые)
    static int[] calcFactors(int number) {
        int[] result = new int[100];
        int index = 0;
        for (int i = 2; i <= number / 2; i++)
            if (number % i == 0)
                result[index++] = i;
        return result;
    }

    //В массиве содержатся строки и целые числа. Вернуть массив, из которого удалены все строки
    //String, Integer -> Object
    static Object[] deleteStrings(Object[] arr) {
        int count = 0;
        for (Object elem : arr)
            if (!Objects.isNull(elem)/*elem != null*/ && !elem.getClass().equals(String.class))
                count++;
        Object[] result = new Object[count];
        int index = 0;
        for (Object elem : arr)
            if (!Objects.isNull(elem) && !elem.getClass().equals(String.class))
                result[index++] = elem;
        return result;
    }

    //Количество гласных букв в строке
    static int countVowels(String s){
        int result = 0;
        String str = s.toLowerCase();
        char[] vowels = {'a','i','o','u','e','y'};
        for (int i = 0; i< str.length(); i++){
            boolean flag = false;
            for (int j = 0; j<vowels.length; j++)
            if (str.charAt(i)==vowels[j])
                flag = true;
            if (flag) result++;
        }
        return result;
    }
}
