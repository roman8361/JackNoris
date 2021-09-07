package ru.kravchenko.chapt8_multythread.ex14_thread_pool_executor_service;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPool ExecutorService
 * ThreadPool - это множество потоков, каждый из которых предназначен для выполнения той или иной задачи.
 * ThreadPool удобноее всего работать посредоством ExecutorService
 * <p>
 * Метод execute передаёт наше задание (task) в thread pool, где оно выполняется одним из потоков.
 * После выполнения метода .shutdown() ExecutorService понимает, что новых заданий больше не будет и выполнив
 * последнее задание прекращает работу.
 */

public class Ex14 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5); // создаст ThreadPool с 5 потоками.
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // создаст ThreadPool с 1 потокам.
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl());
        }
        executorService.shutdown(); // shutdown понимает, что новых заданий больше не будет и выполнив
// последнее задание прекращает работу.
        executorService.awaitTermination(5, TimeUnit.SECONDS); // подобен join метод маин будет ждать пока не
        // отработает executorService или пройдёт 5 сек
        System.out.println("Main end");
    }

}

class RunnableImpl implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(Thread.currentThread().getName() + " поток начал работу!");
        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName() + " поток закончил работу!");
    }

}