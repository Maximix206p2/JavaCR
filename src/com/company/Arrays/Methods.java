package com.company;

import java.sql.SQLOutput;

public class Methods {

    static int i;

    public static void main(String[] args) {
        hello();
        double s = calcArea(1.0);
        System.out.println(s);
        System.out.println(factorial(4));
        System.out.println(isOddNumber(3));
        System.out.println(sum(1,2_000_000_000L));
        System.out.println(sum("you",2,3,4,5,6,7));
        int[] arr= {1,2,3,4};
        System.out.println(sumArr(arr));
    }

    static void hello(){
        System.out.println("hello");
    }
    static void printName(String name){
        System.out.println(name);
    }
    static double calcArea (double r){
        return Math.PI*r*r;
    }
    static int factorial (int n){
        int result = 1;
        for (int i=2; i<=n; i++)
            result*=i;
        return result;
    }
    static String getDayOfWeek(int number){
        //switch
        return null;
    }
    static void getDayOfWeek(){

    }

    static boolean isOddNumber(int number){
        return number%2 == 1?true:false;
    }

    static boolean isFirstBigger(int a, int b){
        return false;
    }

    static int max(int a, int b){
        return 0;
    }

    static boolean isEmailCorrect(String email){
        return false;
    }
/*
    //Перегрузка методов (overloading)
    public static int sum(int a,int b){
        return a+b;
    }

    public static double sum(double a,double b){
        return a+b;
    }
        public static String sum(String s1,String s2){
        return s1+s2;
    }
*/
    public  static <T extends Number> double sum(T a, T b){
        return a.doubleValue()+b.doubleValue();
    }
    public static int sum(String s, double a, int... args) {
        int result = 0;
        for (int arg : args) {
            result+=arg;
        }
        return result;
    }
    public static int sumArr(int[] args) {
        int result = 0;
        for (int arg : args) {
            result+=arg;
        }
        return result;
    }
}