package com.company.switches;

public class Remote {
    private Switch switch1;

    public void setSwitch1(Switch switch1) {
        this.switch1 = switch1;
    }

    public void turnOn(Switch switch1){
        switch1.setTurned(true);
    }

    public void turnOff(Switch switch2){
        switch2.setTurned(false);
    }
}
