package ru.kravchenko.chapt6_stream;

import java.util.stream.Stream;

/**
 * Concat, distinct(уникальный), count, peek
 */
public class Test7ConcatDistinctCountPeek {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3, 4);
        System.out.println(stream.distinct().peek(System.out::println).count()); //peek forEach intermediately method
    }

    private static void exampleCount() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println(stream1.count()); //how match element to stream print 6
    }

    private static void example2Distinct() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3, 4);
        stream.distinct().forEach(System.out::println); // print only 1, 2, 3, 4, 5 distinct element
    }

    private static void example1Concat() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream2 = Stream.of(7, 8, 9, 10, 11);
        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);
    }

}
