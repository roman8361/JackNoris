package ru.kravchenko.chapt8_multythread.ex12_wait_notify;

/**
 * wait - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
 * пока другой поток не вызовет метод notify()
 * <p>
 * notify - не освобождает монитор и будит поток, у которого ранее был вызван метод wait()
 * <p>
 * notifyAll - не освобождает монитор и будит все потоки, у которых ранее был вызван метод wait()
 * wait() и notify() могут вызываться только из синхронизированного контексте
 * (метода или синхронизированного контекста)
 */

public class Ex12 {

    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }

}

class Market {

    private int breadCount = 0;

    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Покупатель купил 1 хлеб");
        System.out.println("Количество хлеба: " + breadCount);
        notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Количество хлеба: " + breadCount);
        notify();
    }

}

class Producer implements Runnable {

    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }

}

class Consumer implements Runnable {

    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }

}