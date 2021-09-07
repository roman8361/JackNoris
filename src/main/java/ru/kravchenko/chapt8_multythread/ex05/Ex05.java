package ru.kravchenko.chapt8_multythread.ex05;

import lombok.SneakyThrows;

/**
 * Use join() method from Thread class
 */
public class Ex05 extends Thread {

    @SneakyThrows
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Ex05 thread2 = new Ex05();
        thread1.start();
        thread2.start();
        thread1.join(); // поток main будет ожидать окончание работы потока thread1
        thread2.join(); // поток main будет ожидать окончание работы потока thread2
        System.out.println("End!");
    }

}

class MyRunnable1 implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}