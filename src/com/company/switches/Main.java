package com.company.switches;

public class Main {
    public static void main(String[] args) {
        Switch switch1 = new SwitchRemote();
        switch1.setTurned(true);
        System.out.println(switch1.toString());
        switch1.runProgram(1);

        Switch switch2 = new SwitchRemote();

        Remote remote = new Remote();
        remote.turnOn(switch2);

        System.out.println(switch2.toString());

        Remote remote2 = new Remote();
    }
}
