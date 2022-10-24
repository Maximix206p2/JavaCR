package com.company;

public class MexicanWave {
    public static void main(String[] args) throws InterruptedException {
        String s = "hello";
        while (true)
        for (int i=0;i<s.length(); i++) {
            System.out.print("\b\b\b\b\b");
            Character c = s.charAt(i);
            StringBuilder sb = new StringBuilder(s);
            Character c2 = c.toString().toUpperCase().charAt(0);
            sb.setCharAt(i, c2);
            System.out.print(sb);
            Thread.sleep(260);
        }
    }
}
