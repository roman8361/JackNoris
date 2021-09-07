package ru.kravchenko.chapt8_multythread.ex11_synchronized_example;

/**
 * Пример использования блоков синхронизации по общему монитору, вывод будет линейный
 * Mobile call was start
 * Mobile call was start
 * What app call was start
 * What app call was start
 * Skype call was start
 * Skype call was start
 */

public class Ex11 {

    private static final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call was start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call was start");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("Skype call was start");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call was start");
        }
    }

    void whatsappCall() {
        synchronized (lock) {
            System.out.println("What app call was start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("What app call was start");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRun1());
        Thread thread2 = new Thread(new MyRun2());
        Thread thread3 = new Thread(new MyRun3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class MyRun1 implements Runnable {

    @Override
    public void run() {
        new Ex11().mobileCall();
    }

}

class MyRun2 implements Runnable {

    @Override
    public void run() {
        new Ex11().skypeCall();
    }

}

class MyRun3 implements Runnable {

    @Override
    public void run() {
        new Ex11().whatsappCall();
    }

}
