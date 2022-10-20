package com.company.nested;

public class For26 {
    public static void main(String[] args) {
        int n = 3, k = 2;
        double sum = 0;
        for (int i=1; i<=n; i++){
            double pow = 1;
            for (int j=0; j<k; j++)
                pow*=i;
            sum+=pow;
        }
        System.out.println(sum);
    }
}
