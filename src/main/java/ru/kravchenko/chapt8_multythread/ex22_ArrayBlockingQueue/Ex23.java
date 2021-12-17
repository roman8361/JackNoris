package ru.kravchenko.chapt8_multythread.ex22_ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue
 */
public class Ex23 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
    }

}
