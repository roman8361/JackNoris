package ru.kravchenko.chapt8_multythread.ex01;

/**
 * Create Thread with extends Thread
 */
public class Ex01 {

    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        MyThread02 myThread02 = new MyThread02();

        myThread01.start();
        myThread02.start();
    }

}

class MyThread01 extends Thread{
    public void run(){
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread02 extends Thread{
    public void run(){
        for (int i = 1000; i >0; i--) {
            System.out.println(i);
        }
    }
}
