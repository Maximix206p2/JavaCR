package com.company;

import java.util.Arrays;
import java.util.Random;

public class SortJaggedArray {
    static int rows;
    static int[][] arr;

    public static void main(String[] args) {
        Random rand = new Random();
        rows = rand.nextInt(3) + 7;

        arr = new int[rows][];
        for (int i = rows; i > 0; i--)
            arr[rows - i] = new int[rand.nextInt(10) + 1];

        //Заполнение случайными числами
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = rand.nextInt(20);

        //Сортировка в строках
        for (int i = 0; i < rows; i++)
            Arrays.sort(arr[i]);

        //Сортировка по длине строк
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < rows; j++)
                if (arr[i].length>arr[j].length)
                    swap(i,j);


                //Вывод
                for (int i = 0; i < rows; i++)
                    System.out.println(Arrays.toString(arr[i]));
    }

    static void swap(int a, int b) {
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

/*  static void swap2(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }*/
}
