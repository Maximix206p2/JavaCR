package com.company.Arrays;

public class Arrays2D {
    static int rows = 5, cols = 5;
    static int[][] arr = new int[rows][cols];

    public static void main(String[] args) {
        //fillOrder2();
        //fillSnake2();
        fillOrder();
        print();
        traversalDiag();
        //sumCols();
    }

    static void fillOrder() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = j + 1 + i * cols;
    }

    static void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.printf("%3d", arr[i][j]);
            System.out.println();
        }
    }

    static void fillOrder2() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = i + 1 + j * rows;
    }

    static void sumCols() {
        int[] sums = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sums[j] += arr[i][j];
            }
        }
        for (int i = 0; i < cols; i++)
            System.out.printf("%3d", sums[i]);
    }

    static void fillSnake() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = i % 2 == 0 ? j + 1 + i * cols : cols - j + i * cols;
    }

    static void fillSnake2() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = j % 2 == 0 ? i + 1 + j * rows : rows - i + j * rows;
    }

    static void traversal1() {
        int i = 0, j = 0;
        while (i < rows && j < cols) {
            System.out.print(arr[i][j] + " ");
            if (i % 2 == 0) {
                i++;
                j++;
            } else i++;
        }
    }

    static void traversal2() {
        int i = 0, j = 0;
        int count = rows / 2;
        for (int k = 0; k < count; k++) {
            j = 0;
            while (i < rows && j < cols) {
                System.out.print(arr[i][j] + " ");
                if (i % 2 == 0) {
                    i++;
                } else {
                    i--;
                    j++;
                }
            }
            i += 2;
        }
        if (rows % 2 == 1)
            for (int k = 0; k < cols; k++) {
                System.out.print(arr[i][k] + " ");
            }
    }

    static void traversalDiag() {
        int i = 0, j = 0;
        System.out.print(arr[i][j] + " ");
        j++;
        while (j < rows && j < cols && j >= 0) {
            System.out.print(arr[i][j] + " ");
            i++;
            j--;
            if (j == -1) {
                j = i;
                i = 0;
            }
            if (j==cols)
        }
    }
}
