package com.company.Arrays;

import java.util.Arrays;

public class task6 {
    public static void main(String[] args) {
        int min = 10_000_000;
        int max = 99_999_999;
        int count = 0;
        for (int i = min; i<=max; i++){
            String s = Integer.toString(i);
            char [] carr = s.toCharArray();
            int[] arr = new int[carr.length];
            for (int j = 0; j< carr.length; j++)
                arr[j] = Integer.parseInt(String.valueOf(carr[j]));
            //System.out.println(Arrays.toString(arr));
            boolean flag = true;
            for (int j = 0; j< carr.length; j++)
                for (int k = j+1; k<carr.length; k++)
                    if (arr[j]==arr[k])
                        flag = false;
                if (flag && i%12_345==0){
                    System.out.println(i);
                    count++;
                }
        }
        System.out.println(count);
    }
}
