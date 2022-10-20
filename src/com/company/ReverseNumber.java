package com.company;

public class ReverseNumber {
    public static void main(String[] args) {
        //1
        int n = 1234567;
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb);

        //2
        while (n>0){
            int dig = n%10;
            System.out.print(dig);
            n/=10;
        }
        System.out.println();
        //3
        for(int i=s.length() - 1; i>= 0; i--){
            System.out.print(s.charAt(i));
        }
    }
}
