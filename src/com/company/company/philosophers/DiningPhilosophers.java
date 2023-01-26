package com.company.philosophers;

import java.util.concurrent.locks.ReentrantLock;

/*
Использование mutex:
Перед тем, как один из философов хочет взять вилки, он блокирует mutex.
Тогда никто другой не может прикасаться к вилкам, пока он не получит две.
 */
public class DiningPhilosophers {
    private static ReentrantLock mutex = new ReentrantLock();

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[3];
        Object[] forks = new Object[philosophers.length];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosopher(mutex,leftFork, rightFork);
            Thread t= new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}


class Philosopher implements Runnable {
    ReentrantLock mutex;
    // The forks on either side of this Philosopher
    private Object leftFork;
    private Object rightFork;

    public Philosopher(ReentrantLock mutex, Object leftFork, Object rightFork) {
        this.mutex = mutex;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (true) {                // thinking
                doAction(": Thinking");
                mutex.lock();
                synchronized (leftFork) {
                    doAction(": Picked up left fork");
                    synchronized (rightFork) {
                        // eating
                        doAction(": Picked up right fork - eating");
                        mutex.unlock();
                        doAction(": Put down right fork");
                    }
                    // Back to thinking
                    doAction(": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
//С днюхой, Димон!
//Хах! Что, думал, что это всё моё поздравление?) А вот и нет!
/*
Дмитрий, сегодня вам исполнилось N-ное количество лет.
Сегодня тебя будут поздравлять близкие люди(родственники и друзья), будут желать счастья,
здоровья, удачи, успехов в любых начинаниях, любви, благополучия, денег
и ещё много подобных ожидаемых, и поэтому, как по мне, скучных слов, хотя и сказанных исключительно
из огромной любви к тебе. Я же постараюсь расширить посредственные устои и сказать начистоту,
как я это всегда и делаю.
 */