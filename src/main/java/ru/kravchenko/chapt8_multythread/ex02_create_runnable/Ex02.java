package ru.kravchenko.chapt8_multythread.ex02_create_runnable;

/**
 * Create Thread with implements Runnable
 */

public class Ex02 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread01());
        Thread thread2 = new Thread(new MyThread02());
        thread1.start();
        thread2.start();
    }

}

class MyThread01 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }

}

class MyThread02 implements Runnable {

    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }

}