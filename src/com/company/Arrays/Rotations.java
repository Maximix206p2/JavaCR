package com.company;

public class Rotations {
    public static void main(String[] args) {
        String word = "abc";
        String[] rots = {"abc","bca", "cab"};
        //String word = "font";
        //String[] rots={"font","ontf","ntfo","tfon"};

        int length=word.length();
        String curr = word;
        int count =0; //Счетчик поворотов
        for (int i=0; i<length; i++){
            boolean found = false;
            for (int j=0; j<length; j++)
                if (rots[j].equals(curr)) //Через = не получается
                    found = true;
            if (found) count++;
            StringBuilder sb = new StringBuilder(curr);
            char c = curr.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            curr = sb.toString();
        }
        System.out.println(count);
        boolean result = count==length?true:false;
        System.out.printf("Answer: %b%n",result);
    }
}
