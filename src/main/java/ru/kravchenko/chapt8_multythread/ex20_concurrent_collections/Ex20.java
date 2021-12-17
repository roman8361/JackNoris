package ru.kravchenko.chapt8_multythread.ex20_concurrent_collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * В ConcurrentHashMap любое количество потоков может читать элементы не блокируя его,
 * благодаря сегментированию, при изменении какого-либо элемента блокируется только bucket
 * в котором он находится остальные доступны для изменения.
 * ни key ни value не могут быть null
 */

public class Ex20 {

    public static void main(String[] args) throws InterruptedException {
//        Map<Integer, String> map = new HashMap<>(); // кидает ConcurrentModificationException
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ROman");
        map.put(2, "Marina");
        map.put(3, "Sergey");
        map.put(4, "Ivan");
        map.put(5, "Botan");
        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer integer = iterator.next();
                System.out.println(integer + ":" + map.get(integer));
            }
        };

        Runnable runnable2 = () ->{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Masya");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }

}
