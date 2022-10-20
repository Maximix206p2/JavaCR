package com.company.Arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShutTheBox {
    public static void main(String[] args) {
        int size = 9;
        int[] arr = new int[size];
        for (int i=0; i<size; i++)
            arr[i] = i+1;
        Scanner scanner = new Scanner(
                System.in
        );
        Random random = new Random();
        boolean move = true; //Ход можно сделать
        int score = 0; //Общий счет
        do {
            int rand = random.nextInt(11) + 2;
            System.out.println("Array: "+Arrays.toString(arr)+"; rand: "+rand);
            System.out.println("Enter numbers: ");
            String s = scanner.nextLine();

            //Подсчет суммы чисел, введенных пользователем
            String[] sArr = s.split(" ");
            int[] numbers = new int[sArr.length];
            for (int i=0; i< sArr.length; i++)
                numbers[i] = Integer.parseInt(sArr[i]);
            int sum = 0;
            for (int i=0; i< sArr.length; i++)
                sum+=numbers[i];
            if (sum==rand){
                for (int i=0; i<arr.length; i++)
                    for (int j=0; j<numbers.length; j++)
                        if (arr[i]==numbers[j]) arr[i] = 0;
                score+=sum;
            }
            else break;
        } while (sum(arr)>0);
        System.out.println("Your score: "+score);
    }

    static int sum(int[] arr){
        int result = 0;
        for (int i=0; i<arr.length; i++)
            result+=arr[i];
        return result;
    }

}
