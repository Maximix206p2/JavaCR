package com.company.Arrays;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    static int size = 10;
    static int[] arr = new int[size];
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        fillRandom();
        print();
        //bubbleSort();
        //dummySort();
        //shakerSort();
        //oddEvenSort(); (Лажа)
        //gnomeSort();
        //insertionSort();
        //selectionSort();
        //combSort();
        //bogoSort();
        print();
    }

    static void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < size - 1; i++)
            arr[i] = random.nextInt(90) + 10;
    }

    static void print() {
        System.out.println(Arrays.toString(arr));
    }

    public static void dummySort() {
        int i = 0;
        while (i < size - 1) {
            if (arr[i] > arr[i + 1]) {
                printColor(i, i + 1);
                swap(i, i + 1);
                i = 0;
            } else i++;
        }
    }

    static void shakerSort() {
        int left = 0, right = size - 1;
        do {
            for (int i = left; i < right; i++)
                if (arr[i] > arr[i + 1]) {
                    printColor(i, i + 1);
                    swap(i, i + 1);
                }
            right--;
            for (int i = right; i >= left; i--)
                if (arr[i] > arr[i + 1]) {
                    printColor(i, i + 1);
                    swap(i, i + 1);
                }
            left++;
        } while (left < right);
    }

    static void bubbleSort() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    printColor(j, j + 1);
                    swap(j, j + 1);
                }
    }

    /*static void oddEvenSort() { //(Лажа)
        for (int i = 0; i < size - 1; i++)
            for (int j = i % 2 == 0 ? 0 : 1; j < size - 2; j+=2)
                if (arr[j] > arr[j + 2]) {
                    printColor(j, j + 2);
                    swap(j, j + 2);
                }
    }*/

    static void gnomeSort() {
        for (int i = 0; i < size; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                printColor(j, j - 1);
                swap(j, j - 1);
            }
    }

    static void insertionSort() {
        for (int i = 0; i < size; i++) {
            int spec = arr[i];
            int j;
            for (j = i; j > 0 && spec < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = spec;
        }
    }

    static void selectionSort() {
        for (int i = 0; i < size; i++) {
            int min = arr[i], index = 0;
            for (int j = i; j < size; j++)
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            if (index != 0) {
                printColor(i, index);
                swap(i, index);
            }
        }
    }

    static void combSort() {
        double factor = 1.2473309;
        int step = size - 1;
        while (step >= 1) {
            for (int i = 0; i + step < size; i++) {
                if (arr[i] > arr[i + step]) {
                    printColor(i, i + step);
                    swap(i, i + step);
                }
            }
            step /= factor;
        }
    }

    static void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            swap(i, rand.nextInt(size));
    }

    static boolean isSorted() {
        for (int i = 1; i < size; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }

    static void bogoSort(){
        while (!isSorted())
            shuffle();
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Напечатать два элемента массива красным
    public static void printColor(int first, int second) {
        for (int i = 0; i < size; i++) {
            if (i == first || i == second) {
                System.out.print(ANSI_RED);
                System.out.print(arr[i] + " ");
                System.out.print(ANSI_WHITE);
            } else System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
