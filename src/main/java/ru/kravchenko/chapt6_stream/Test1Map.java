package ru.kravchenko.chapt6_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream map
 */

public class Test1Map {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("privet", "hi", "hello world", "lalala"));
        List<Integer> list1 = list.stream().map(element -> element.length()).collect(Collectors.toList());
//        List<Integer> list1 = list.stream().map(String::length).collect(Collectors.toList()); // equals
//        System.out.println(list1);

        int[] array = {2, 4, 3, 8, 9, 12, 222}; // if value from array / 3 change value to x/3   result [2, 4, 1, 8, 3, 4, 74]
        array = Arrays.stream(array).map(element -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();

        System.out.println(Arrays.toString(array));
    }

}
