package ru.kravchenko.chapt8_multythread.ex06_any_method;

import lombok.SneakyThrows;

public class Ex06 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState()); // NEW
        thread.start();
//        thread.join(1500); // Поток маин будет ждать 1.5 секунды и продолжит свою работу) не дождавшись конца работы Worker,
        // но если Worker закончит свою работу раньше ожидания (1,5 сек), то маин сразу же продолжить работать.
        System.out.println(thread.getState()); // RUNNABLE
        thread.join();
        System.out.println(thread.getState()); // TERMINATED
        System.out.println("Method main is ends");
    }
}


class Worker implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Work begins");
        Thread.sleep(2500);
        System.out.println("Work ends");
    }

}