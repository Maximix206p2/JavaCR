package com.company.nested;

import java.util.Arrays;

public class Pascal {
    public static void main(String[] args) {
        int rows = 12, cols = 2 * rows - 1;
        int arr[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (i == 0)
                    arr[0][cols / 2] = 1;
                else if (j == 0) arr[i][j] = arr[i - 1][j + 1];
                else if (j == cols - 1) arr[i][j] = arr[i - 1][j - 1];
                else arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
            }
        //for (int i = 0; i < rows; i++)
        //System.out.println(Arrays.toString(arr[i]));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String s = Integer.toString(arr[i][j]);
                String pad = String.format("%3s", s);
                if (arr[i][j] != 0)
                    System.out.print(pad);
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
}
