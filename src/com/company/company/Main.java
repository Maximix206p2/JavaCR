package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    //API - application ... interface
    public static void main(String[] args) {
        //Сгенерироваь массив последовательных натуральных чисел в заданном диапазоне
        System.out.println(Arrays.toString(genNatural(1, 9)));
        //Отфильтровать нечётные числа
        System.out.println(Arrays.toString(genEven(1, 9)));
        //2-ой способ
        int[] arr = genNatural(1, 9);
        int[] arr2 = Arrays.stream(arr)
                .filter(n->n%2==0)
                .toArray();
        System.out.println(Arrays.toString(arr2));
        //Получить сумму чисел
        System.out.println(Arrays.stream(arr).sum());
        //Получить количество чисел
        System.out.println(Arrays.stream(arr).count());
        //Сгенерироваь массив случайных натуральных чисел чисел в заданном диапазоне
        System.out.println(Arrays.toString(genRandom(1,10,10)));
        //Вывести все числа от 1 до 1000, которые делятся на 3, 5, и 11
        System.out.println(Arrays.toString(gen3_5_11()));
        //Вывести квадраты первых n натуральных чисел
        System.out.println(Arrays.toString(genSquares(10)));
        int n = 10;
        //n^20
        //int n2 = n*n, n4= n2*n2, n8 = n4*n4, n16 = n8*n8, n20 = n16*n4;
        int square = n*n; //CPU
        square = (int) Math.pow(n,2); //FPU
        //Степени числа 2
    }

    static int[] genNatural(int min, int max) {
        return IntStream
                .range(min, max + 1)
                .toArray();
    }

    static int[] genEven(int min, int max) {
        return IntStream
                .range(min, max + 1)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    static int[] genRandom(int min, int max, int count) {
        Random random = new Random();
        return IntStream
                .generate(()->random.nextInt(max-min+1)+min)
                .limit(count)
                .toArray();
    }
    static int[] gen3_5_11() {
        return IntStream
                .range(1,1001)
                .filter(n -> n % 3 == 0 || n % 5 == 0 || n % 11 == 0)
                .toArray();
    }
    static int[] genSquares(int count) {
        return IntStream
                .range(1, count+1)
                .map(n->n*n)
                .toArray();
    }
    static int[] genSquares_2(int count) {
        return IntStream
                .iterate(1, i -> i+1)
                .filter(n->Math.abs((int)Math.sqrt(n)-Math.sqrt(n))<1e-10)
                .limit(10)
                .toArray();
    }
}
