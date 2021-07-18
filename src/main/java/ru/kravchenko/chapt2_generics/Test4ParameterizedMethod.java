package ru.kravchenko.chapt2_generics;

import java.util.Arrays;
import java.util.List;

/**
 * Example 4. Parameterized method.
 */

public class Test4ParameterizedMethod {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 67);
        List<String> list2 = Arrays.asList("iha", "troolo", "hi", "hello");
        System.out.println(GenMethod.getSecondElement(list1));
        System.out.println(GenMethod.getSecondElement(list2));
    }

}

class GenMethod {

    public static <T> T getSecondElement(List<T> list) {
        return list.get(1);
    }

}