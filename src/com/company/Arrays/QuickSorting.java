package com.company.Arrays;

public class QuickSorting {
    static int size;
    static int[] arr;
    //Слияние внутри одного массива
    public static void merge(int l, int m, int r) {
        size = 20;
        arr = new int[size];
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int i = 0; i < len1; i++)
            left[i] = arr[l + i];
        for (int i = 0; i < len2; i++)
            right[i] = arr[m + 1 + i];
        int i = 0;
        int j = 0;
        int k = l;
        
        // After comparing, we
        // merge those two array
        // in larger sub array
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
    }
}
