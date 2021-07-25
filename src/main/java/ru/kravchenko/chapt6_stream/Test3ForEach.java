package ru.kravchenko.chapt6_stream;

import java.util.Arrays;

/**
 * ForEach
 */

public class Test3ForEach {

    private static int[] array = {3, 4, 5, 6, 7, 8, 11, 22};

    public static void main(String[] args) {
//        test1();
        Arrays.stream(array).forEach(System.out::print);
        Arrays.stream(array).forEach(Utils::myMethod); //equals
//        Arrays.stream(array).forEach(e -> Utils.myMethod(e)); //equals
    }

    private static void test1() {
        Arrays.stream(array).forEach(e -> {
            e *= 2;
            System.out.println(e);
        });
    }

}

class Utils {

    public static void myMethod(int a) {
        a = a + 5;
        System.out.println("Element = " + a);
    }

}
