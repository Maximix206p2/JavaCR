package com.company.switches;

public class SwitchRemote extends Switch{

    @Override
    public String toString() {
        String s = super.toString();
        return s+" remote";
    }

    public void runProgram(int number){
        switch (number){
            case 0:
                System.out.println("off");
                break;
            case 1:
                System.out.println("program 1");
                break;
        }
    }
}