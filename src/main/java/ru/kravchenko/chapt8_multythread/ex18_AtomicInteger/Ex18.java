package ru.kravchenko.chapt8_multythread.ex18_AtomicInteger;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger это класс, который предоставляет возможность работать с целочисленными значениями int,
 * используя атомарные операции.
 */

public class Ex18 {

    //    static int counter = 0;
    static AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
//        counter.incrementAndGet();
        counter.addAndGet(5); //добавляет 5
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRun());
        Thread thread2 = new Thread(new MyRun());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }

}

class MyRun implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            Ex18.increment();
        }
    }

}
