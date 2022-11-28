package com.company;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import javax.sound.sampled.Line;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Vocab {
    public static void main(String[] args) {
        int count = 'z' - 'a' + 1;
        //System.out.println(count);

        //List<String> vocab = new ArrayList<>();
        List<String> vocab = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/com/company/data/vocab"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null)
                    vocab.add(s);
            }
            while (s != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(vocab.size());

        vocab.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //for(String s:vocab) System.out.println(s);
        ListIterator<String> it = vocab.listIterator(0);
        int i = 0;
        while (it.hasNext() && i < 10) {
            System.out.println(it.next());
            i++;
        }

        //Последние 10 слов
        it = vocab.listIterator(vocab.size());
        i = 0;
        while (it.hasPrevious() && i < 10) {
            System.out.println(it.previous());
            i++;
        }

        //Сколько слов 1-буквенных, 2-букв., ...
        int max = 0;
        for (i = 0; i < vocab.size(); i++)
            if (vocab.get(i).length() > max) {
                max = vocab.get(i).length();
            }
        System.out.println(max);
        int[] hist = new int[max];
        for (i = 0; i < vocab.size(); i++)
            hist[vocab.get(i).length() - 1]++;

        for (i = 0; i < max; i++)
            System.out.printf("Букв: %d, слов: %d%n", i + 1, hist[i]);

        //Вывести слова-палиндромы
        for (String s1 : vocab) {
            StringBuilder sb = new StringBuilder(s1);
            String s2 = sb.reverse().toString();
            if (s2.equals(s1))
                System.out.println(s1);
        }

        //Слова - анаграммы "File > File Structure... > Libraries > From Maven > com.google.guava"
        Multimap<String, String> anagrams = ArrayListMultimap.create();
        for (String s1 : vocab) {
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);
            String s2 = new String(arr);
            anagrams.put(s2, s1);
        }
        //collision
        String key1 = "", key2 = "";
        Map.Entry<String, String> entry2 = null;
        for (Map.Entry<String, String> entry1 : anagrams.entries()) {
            key1 = entry1.getKey();
            if (key1.equals(key2))
                System.out.println(entry2.getValue() + " — " + entry1.getValue());
            key2 = key1;
            entry2 = entry1;
        }

        //Найти слова с тремя одинаковыми буквами
        for (String s1 : vocab) {
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);
            char c0 = ' '; int count0 = 0;
            for (char c : arr) {
                if (c == c0) count0++;
                else count0 = 1;
                if (count0 == 3) {
                    System.out.println(s1);
                    break;
                }
                c0 = c;
            }
        }
    }
}