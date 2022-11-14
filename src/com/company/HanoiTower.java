package com.company;

public class HanoiTower {
    private static int count = 32;
    private static int[][] discs = new int[count][3]; //для хранения количества дисков
    private static int[] counts = new int[3];

    public static void main(String[] args) {
        fill();
        //moveOne(0, 1);
        move(count, 0, 1, 2);
        System.out.println(toStringAligned());
    }

    public static void moveOne(int from, int to) {
        //Не пустой ли стержень from
        if (counts[from] != 0) {
            discs[counts[to]++][to] = discs[--counts[from]][from];
            discs[counts[from]][from] = 0;
        }
    }

    public static void move(int count, int from, int aux, int to) {
        if (count == -1) {
            moveOne(from, to);
            return;
        } else {
            move(count - 1, from, to, aux);
            moveOne(from, to);
            move(count - 1, aux, from, to);
        }
    }

    public static void fill() {
        for (int i = 0; i < count; i++)
            discs[i][0] = count - i;
        counts[0] = count;
    }

    //Преобразовать в строку с выравниванием
    public static String toStringAligned() {
        StringBuilder result = new StringBuilder();
        String pad = "     ";
        for (int i = count - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                String sNumber = Integer.toString(discs[i][j]);
                String sPadded = pad.substring(sNumber.length()) + sNumber;
                if (j == 0) result.append(sNumber);
                else
                    result.append(sPadded);
            }
            result.append("\n");
        }
        result.append("___________\n");
        return result.toString();
    }
}
