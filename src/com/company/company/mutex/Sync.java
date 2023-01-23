package com.company.mutex;

/*
В основном потоке создаются два дочерних, каждый из которых выполняет 4 шага
Первый дочерний должен выполнить шаги 1..2 до того, как второй выполнит их.
Очередность выполнения остальных шагов несущественна.
 */
public class Sync {
    static Object mutex = new Object();

    public static void main(String[] args) {
        Runnable runnable = ()->{
            for(int i=1; i<=4; i++) {
                synchronized (mutex){
                    if (Thread.currentThread().getName().equals("Thread-1") && i==1)
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    if (Thread.currentThread().getName().equals("Thread-0") && i==3)
                        mutex.notify();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);

            }
        };

        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
