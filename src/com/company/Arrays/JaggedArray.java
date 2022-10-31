package com.company;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Arrays;

public class JaggedArray {
    static int rows = 5;

    public static void main(String[] args) {
        int[][] arr = new int [rows][];
        for (int i = rows; i>0; i--)
            arr[rows-i] = new int[i];
        /*
        *****
        ****
        ***
        **
        *
        */

        //Заполнение
        for (int i = 0; i<rows; i++)
            for (int j = 0; j< rows -i; j++)
                arr[i][j] = j+1;

            //Печать
        for (int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(arr[i]));

        System.out.println(arr[0][0]);
    }
}
