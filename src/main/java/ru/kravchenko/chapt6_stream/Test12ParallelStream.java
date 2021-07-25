package ru.kravchenko.chapt6_stream;

import java.util.Arrays;
import java.util.List;

/**
 * ParallelStream
 */

public class Test12ParallelStream {

    public static void main(String[] args) {
        example2();
    }

    //TODO result not VALID!!!
    private static void example2() {
        List<Double> doubleList = Arrays.asList(10.0, 5.0, 1.0, 0.25);
        Double divisionResult = doubleList.parallelStream().reduce((accum, elem) -> accum / elem).get();
        System.out.println("result : " + divisionResult);
    }

    private static void example1() {
        List<Double> doubleList = Arrays.asList(10.0, 5.0, 1.0, 0.25);
        Double result = doubleList.parallelStream().reduce((accum, elem) -> accum + elem).get();
        System.out.println("result : " + result);
    }

}
