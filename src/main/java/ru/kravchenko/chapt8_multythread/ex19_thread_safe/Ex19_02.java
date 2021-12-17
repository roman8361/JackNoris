package ru.kravchenko.chapt8_multythread.ex19_thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ex19_02 {

    public static void main(String[] args) throws InterruptedException {
//        List<Integer> list = new ArrayList<>(); // кидает ConcurrentModificationException
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        List<Integer> syncList = Collections.synchronizedList(list); // кидает ConcurrentModificationException

        Runnable runnable1 = () -> {
            synchronized (syncList) { // Только если добавить synchronized блок ошибки не будет
                Iterator<Integer> iterator = syncList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        Runnable runnable2 = () -> syncList.remove(10);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }

}
