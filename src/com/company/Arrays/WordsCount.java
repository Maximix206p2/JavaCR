package com.company.Arrays;

public class WordsCount {
    public static void main(String[] args) {
        String[] arr = {"It  is", "hello, world", "main  method in the class"};
        String s = "It aiasa";
        String[] result = s.split("[ is]+");
        for (String str : result)
            System.out.println(str);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split("[ ]+");
            count += temp.length;
        }
        System.out.println(count);
    }
}//regular expression one or more