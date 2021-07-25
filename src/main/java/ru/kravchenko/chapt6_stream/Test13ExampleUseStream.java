package ru.kravchenko.chapt6_stream;

import java.util.Random;
import java.util.stream.Stream;

public class Test13ExampleUseStream {

    public static void main(String[] args) {

    }

    private static void ex06GetAverageFromStream() {
        System.out.println(Stream.of(100, 200, 300, -100).mapToInt(e -> e).average().getAsDouble());
    }

    private static void ex05GetSumFromStream() {
        System.out.println(Stream.of(100, 200, 300, -100).mapToInt(e -> e).sum());
    }

    private static void ex04MaxNumber() {
        System.out.println(Stream.of(1, 2, 22, -100, 22, 999).mapToInt(e -> e).max().getAsInt());
    }

    private static void ex03RandomTenNumberBySort() {
        new Random().ints().limit(10).sorted().forEach(System.out::println);
    }

    //unique square number
    private static void ex02DistinctSquareNumber() {
        Stream.of(1, 2, 3, 2, 1).map(e -> e * e).distinct().forEach(System.out::println);

//        Stream.of(1, 2, 3, 2, 1).map(e -> {   //TODO equals
//                    e = e * e;
//                    return e;
//                }
//        ).distinct().forEach(System.out::println);

    }

    private static void ex01TenRandomNumbers() {
        new Random().ints().limit(10).forEach(System.out::println);
    }

}
