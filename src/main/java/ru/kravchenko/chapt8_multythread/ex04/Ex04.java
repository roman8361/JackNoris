package ru.kravchenko.chapt8_multythread.ex04;

/**
 * Use method from Thread class
 */
public class Ex04 {

    public static void main(String[] args) {
        MyThread04 myThread04 = new MyThread04();
        MyThread04 myThread05 = new MyThread04();
        System.out.println("Name of myThread04 = " + myThread04.getName() + " priority myThread04 = " + myThread04.getPriority());
        System.out.println("Name of myThread04 = " + myThread05.getName() + " priority myThread04 = " + myThread05.getPriority());

        MyThread04 myThread06 = new MyThread04();
        myThread06.setName("My THREAD±±±");
        myThread06.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of myThread04 = " + myThread06.getName() + " priority myThread04 = " + myThread06.getPriority());
    }
}

class MyThread04 extends Thread{
    public void run(){
        System.out.println("privete");
    }
}
