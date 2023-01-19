package com.company.runners;

//Потоки выполняются определённое время
public class RunnersClock {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runner("1"));
        thread1.setPriority(1);
        thread1.start();
        Thread thread2 = new Thread(new Runner("2"));
        thread2.setPriority(1);
        thread2.start();
    }
}
class Runner implements Runnable{
    String name;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        int i = 1;
        while (System.currentTimeMillis()<start+1050){
            System.out.printf("Runner %s is running, step: %d%n",name, i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}