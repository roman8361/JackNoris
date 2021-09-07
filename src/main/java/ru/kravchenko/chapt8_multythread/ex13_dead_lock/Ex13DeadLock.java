package ru.kravchenko.chapt8_multythread.ex13_dead_lock;

/**
 * Deadlock - ситуация, когда 2 или более потоков залочены навсегда, ожидают друг друга и нечего не могут делать.
 */
public class Ex13DeadLock {

    public static final Object lock1 = new Object();

    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }

}

class Thread10 extends Thread {

    public void run() {
        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (Ex13DeadLock.lock1) {
            System.out.println("Thread10: Монитор объекта lock1 захвачен");
            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
            synchronized (Ex13DeadLock.lock2) {
                System.out.println("Thread10: Мониторы объектов lock1 lock2 захвачены");
            }
        }
    }

}

class Thread20 extends Thread {

    public void run() {
        System.out.println("Thread20: Попытка захватить монитор объекта lock2");
        synchronized (Ex13DeadLock.lock2) {
            System.out.println("Thread20: Монитор объекта lock2 захвачен");
            System.out.println("Thread20: Попытка захватить монитор объекта lock2");
            synchronized (Ex13DeadLock.lock1) {
                System.out.println("Thread20: Мониторы объектов lock1 lock2 захвачены");
            }
        }
    }

}