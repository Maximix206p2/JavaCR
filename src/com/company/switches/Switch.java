package com.company.switches;

public class Switch {

    protected boolean turned;

    public boolean isTurned() {
        return turned;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "turned=" + turned +
                '}';
    }

    public void setTurned(boolean turned) {
        this.turned = turned;
    }

    public void runProgram(int number){

    }
}
