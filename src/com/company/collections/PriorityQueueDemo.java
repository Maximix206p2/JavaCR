package com.company.collections;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("c2", "a1", "1a"));
        List<String> list2 = new ArrayList<>(Arrays.asList("c2", "a11", "11a"));
        List<String> list3 = new ArrayList<>(Arrays.asList("c2", "ba1", "c1ad", "sdf"));

        Queue<ArrayListComparable> queue = new PriorityQueue<>();
        queue.add(new ArrayListComparable(list1));
        queue.add(new ArrayListComparable(list2));
        queue.add(new ArrayListComparable(list3));

        while (!queue.isEmpty()) {
            ArrayListComparable list = queue.poll();
            System.out.println(list.getList1());
        }
    }
}

class ArrayListComparable implements Comparable{
    private List<String> list1 = new ArrayList<>();

    public ArrayListComparable(List<String> list1) {
        this.list1 = list1;
    }

    public void setList1(List<String> list1) {
        this.list1 = list1;
    }

    public List<String> getList1() {
        return list1;
    }

    @Override
    public int compareTo(Object o) {
        //return ((ArrayListComparable)o).getList1().size()-list1.size();
        return -((ArrayListComparable)o).getList1().get(0).charAt(0)+list1.get(0).charAt(0);
    }
}