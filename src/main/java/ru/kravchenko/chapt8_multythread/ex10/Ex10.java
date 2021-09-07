package ru.kravchenko.chapt8_multythread.ex10;

/**
 * Класс пример использования synchronized блока.
 * Монитор - это сущность/механизм благодаря которому достигается корректная работа при
 * синхронизации работы с ресурсом. В Java у каждого класса и объекта привязанный есть привязанный к нему монитор.
 */

public class Ex10 {

    public static void main(String[] args) throws InterruptedException {
//        MyRunClass myRunClass = new MyRunClass();
        Thread thread1 = new Thread(new MyRunClass());
        Thread thread2 = new Thread(new MyRunClass());
        Thread thread3 = new Thread(new MyRunClass());

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Program was stop!");
    }

}

class Counter {
    static int count = 0;
}

class MyRunClass implements Runnable {

    private void anyPrint(){
        System.out.println("TROLOLO");
    }

    private void doWork() {
        anyPrint();
//        synchronized (this) {  // блок синхронизированного когда с монитором на этот объект
        synchronized (Counter.class) {  // блок синхронизированного когда с монитором на Counter.class
            Counter.count++;
            System.out.println(Counter.count + " ");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork();
        }
    }

}
