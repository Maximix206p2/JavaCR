package com.company;

public class Scrabmle {
    public static void main(String[] args) {
        String fst = "rkqooodlw", snd = "world";
        StringBuilder sb = new StringBuilder(fst);
        boolean flag = true;
        for (int i=0;i<snd.length();i++){
            int index = sb.toString().indexOf(snd.charAt(i));
            if (index == -1) flag = false;
            //else sb.delete(index, index+1);
            else sb.setCharAt(index, ((Character)snd.charAt(i)).toString().toUpperCase().charAt(0));
        }
        System.out.println(flag);
        System.out.println(sb);
    }
}
