package com.company.runflag;

//Пока судья не выбросит флаг
public class RunnersFlag {
    public static void main(String[] args) {
        Runner runner1 = new Runner("1");
        Thread thread1 = new Thread(runner1);
        thread1.setPriority(1);
        thread1.start();
        Runner runner2 = new Runner("2");
        Thread thread2 = new Thread(runner2);
        thread2.setPriority(1);
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runner1.flag = true;
        runner2.flag = true;

        /*
        thread1.interrupt();
        thread2.interrupt();
         */
    }
}

class Runner implements Runnable{
    String name;
    boolean flag = false;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        int i = 1;
        while (!flag){
            System.out.printf("Runner %s is running, step: %d%n",name, i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //return;
            }
        }
    }
}