package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/*
二二二二二二二二二二
二一十二二二二十一二
二二二二一一二二二二
二二十十十十十十二二
一一一一一一一一一一
 */
public class Betty {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/company/data/betty"))) {
            String s;
            do {
                s = br.readLine();
                sb.append(s);
                sb.append(System.lineSeparator());
            }
            while (s != null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = sb.toString();
        content = content.replaceAll("[^A-Za-z]", " ");
        String[] words = content.split(" ");
        //System.out.println(Arrays.toString(words));
        for (String s:words){
            s = s.trim();
            if (s.length()!=0 && (s.charAt(0)=='b' || s.charAt(0) =='B'))
                treeSet.add(s);
        }

        System.out.println(treeSet.toString());
    }
}
