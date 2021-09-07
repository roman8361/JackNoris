package ru.kravchenko.chapt8_multythread.ex09_synchronized;

/**
 * synchronized
 */
public class Ex09 {

    static int counter = 0;

    static synchronized void increment() { // synchronized позволяет только одному потоку выполнить инкремент,
        // другие потоки ждут пока выйдет вошедший
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Ex09.increment();
        }
    }

}
