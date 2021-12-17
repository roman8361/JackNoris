package ru.kravchenko.chapt8_multythread.ex21_CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList надо использовать тогда, когда необходимо добиться потокобезопасности, у вас НЕ большое количество
 * операций по изменению элементов и большое количество по их чтению
 */
public class Ex21 {

    public static void main(String[] args) throws InterruptedException {
//        List<String> list = Arrays.asList("Demon", "Pimen", "Ludovik", "Pisulka"); // кидает UnsupportedOperationException
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
        list2.add("Deml");
        list2.add("Pimen");
        list2.add("Ludovik");
        list2.add("Pisulka");
        list2.add("123");
        System.out.println(list2);
        Runnable runnable1 = () -> {
            Iterator<String> iterator = list2.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.remove(3);
            list2.add("Rurick");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list2);
    }

}
