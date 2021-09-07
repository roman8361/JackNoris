package ru.kravchenko.chapt8_multythread.ex15_thread_pool_executor_service;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService используем тогда, когда хотим установить расписание на запуск потоков из пула.
 */

public class Ex15 {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(new RunnableImpl());
//        }
        System.out.println("Программа началась");
//        scheduledExecutorService.schedule(new RunnableImpl(), 3, TimeUnit.SECONDS); // выполни это задание через 3 секунды
//        scheduledExecutorService.shutdown();
//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl(), 3,1, TimeUnit.SECONDS); // задача выполниться через
        // одну секунду с одним периодом
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl(), 3, 1, TimeUnit.SECONDS); // задача выполниться через
        // 3 одну секунды после начала, потом 3 секунды отработает сам поток, далее ждём 1 секунду (delay) и запускаем опять поток
        scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

}

class RunnableImpl implements Runnable {

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(Thread.currentThread().getName() + " поток начал работу!");
        Thread.sleep(1500);
        System.out.println(Thread.currentThread().getName() + " поток закончил работу!");
    }

}