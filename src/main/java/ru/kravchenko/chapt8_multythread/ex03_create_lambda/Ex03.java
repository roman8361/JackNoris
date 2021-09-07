package ru.kravchenko.chapt8_multythread.ex03_create_lambda;

/**
 * Create Thread with lambda (create two any thread)
 */
public class Ex03 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Iha");
            }
        }).start();
        new Thread(() -> System.out.println("trololo")).start();
    }

}
