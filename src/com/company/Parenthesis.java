package com.company;

import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        String s = "{[s+(a+b)+1]+2}";
        //String s = "{[s+(a+b+1]+2}";
        //String s = "{[s+(a+b+1])+2}";
        String parentesis="()[]{}";
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i=0; i<s.length(); i++){ //for (char c:s.toCharArray())
            char c = s.charAt(i); //{
            int index = parentesis.indexOf(c); //4
            if (index != -1) { //-1, если не найдено
                if (index%2 ==0)
                    stack.push(c);
                else {
                    //Пуст ли стек
                    if (stack.isEmpty()){
                        System.out.println("Ошибка в позиции " + i);
                        flag = false;
                        break;
                    }
                    char c2 = stack.peek(); //в других языках "top" вместо "peek"
                    int index2 = parentesis.indexOf(c2);
                    if (index-index2==1)
                        stack.pop(); //извлечь
                    else {
                        System.out.println("Ошибка в позиции " + i); //Непарность скобок
                        flag = false;
                        break;
                    }
                }
            }
        }
        //Пуст ли стек
        if (!stack.isEmpty()) {
            System.out.println("Ошибка в позиции " + (s.length() - 1));
            flag = false;
        }
        if (flag) System.out.println("Всё верно!");
    }
}