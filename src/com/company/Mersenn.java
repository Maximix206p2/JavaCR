package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
Простое число Мерсенна — это простое число, имеющее вид 2^n - 1.
Первыми простыми числами Мерсенна являются 3, 7, 31 и 127, соответствующие n = 2, 3, 5 и 7.
*/
public class Mersenn {
    public static void main(String[] args) {
        int[] arr = IntStream.iterate(1,i->i+1)
                .map(i-> (int) (Math.pow(2,i)-1))
                .filter(i->isPrime(i))
                .limit(15)
                .toArray();
        System.out.println(Arrays.toString(arr));
    }
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
