package com.company;

import java.util.Arrays;

public class TreeTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addRoot('A'); //0 0*2+1, 0*2+2
        tree.addLeft(0, 'B'); //1
        tree.addRight(0, 'C'); //2: 2*2+1, 2*2+2
        tree.addLeft(2, 'D'); //5
        tree.addRight(2, 'E'); //6

        tree.print();
        //tree.preOrder('A');
        tree.inOrder('A');
        //tree.postOrder('A');
    }
}

class Tree{
    static int root = 0;
    static char[] arr = new char[10];

    public void addRoot(char c){
        arr[0] = c;
    }

    public void addLeft(int parent, char c){
        int left = parent*2+1;
        if (arr[parent] == 0)
            return;
        else  arr[left] = c;
    }

    public void addRight(int parent, char c){
        int right = parent*2+2;
        if (arr[parent] == 0)
            return;
        else arr[right] = c;
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }

    public int findNode(char key){
        if (key==0) return -1;
        int index = -1;
        for (int i = 0; i<arr.length; i++)
            if (arr[i] == key) index = i;
        return index; //?
    }

    public char getLeftChild(char key){
        int node = findNode(key);
        if (key==-1) return 0;
        if (node*2+1<arr.length)
            return arr[node*2+1];
        else return 0;
    }

    public char getRightChild(char key){
        int node = findNode(key);
        if (key==-1) return 0;
        if (node*2+2<arr.length)
            return arr[node*2+2];
        else return 0;
    }

    //Preorder traversal ABCDE
    public void preOrder(char key){
        if (key==0) return;
        System.out.print(key+" ");
        preOrder(getLeftChild(key));
        preOrder(getRightChild(key));
    }
    //InOrder traversal BDECA
    public void inOrder(char key){
        if (key==0) return;
        inOrder(getLeftChild(key));
        System.out.print(key+" ");
        inOrder(getRightChild(key));
    }
    //PostOrder traversal BADCE
    public void postOrder(char key){
        if (key==0) return;
        postOrder(getLeftChild(key));
        postOrder(getRightChild(key));
        System.out.print(key+" ");
    }
}