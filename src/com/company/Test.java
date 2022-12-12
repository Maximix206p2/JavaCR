package com.company;

import java.util.*;

/*
Студенты нескольких групп сдают экзамен по одному предмету, который оценивается по шкале от 1 до 10.
Вывести список студентов и их оценок для выбранной группы с сортировкой по фамилиям; по оценкам.
После списка группы вывести статистику (количество студентов, получивших 10 баллов, 9 баллов и т.д.;
среднюю успеваемость по выбранной группе).
https://www.geeksforgeeks.org/arraylist-size-method-in-java-with-examples/#:~:text=The%20size()%20method%20of,of%20elements%20in%20this%20list.&text=Returns%20Value%3A%20This%20method%20returns,of%20elements%20in%20this%20list.
 */
public class Test {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>(5);
        List<Integer> mark = new ArrayList<Integer>(5);
        name.add(1, "Алексей");
        name.add(2, "Иван");
        name.add(3, "Дмитрий");
        name.add(4, "Альберт");
        name.add(5, "Григорий");
        /*System.out.println(Collections.sort(name.get(i)));
        for (String s1 : name) {
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);
            System.out.println(arr);
        }*/

        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i) + " ");
            for (int j = 0; j < mark.size(); j++) {
                mark.add(i + 6);
                System.out.println(mark.get(i));
            }
        }

        /*static void sorting (String name, Integer mark){
            //sorting by name
            for (int i = 0; i < name.size(); i++) {
                System.out.println(Collections.sort(name.subList()));
            }
        }*/
    }
}