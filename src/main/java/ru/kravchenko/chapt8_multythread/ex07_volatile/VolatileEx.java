package ru.kravchenko.chapt8_multythread.ex07_volatile;

/**
 * Volatile
 */
public class VolatileEx extends Thread {

    volatile boolean b = true; // volatile переменная будет храниться только в основной памяти main memory
    // для синхронизации значения переменной между потоками ключевое слово volatile используется тогда,
    // когда только один потом может изменять значение этой переменной, а остальные потоки могут его только читать

    public void run(){
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished. counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread = new VolatileEx();
        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 second it is time to wake up");
        thread.b = false;
        thread.join();
        System.out.println("Programm end");
    }
}
