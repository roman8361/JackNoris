package ru.kravchenko.chapt8_multythread.ex19_thread_safe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections.synchronizedList
 */

public class Ex19 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> sours = Arrays.asList(1, 2, 3, 4, 5);
//        ArrayList<Integer> target = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>()); //Только один поток может сейчас
        // заходить в эту коллекцию и работать с данными
        Runnable runnable = () -> {
            syncList.addAll(sours);
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(syncList);
    }

}
