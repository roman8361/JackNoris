package ru.kravchenko.chapt6_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Reduce (уменьшать). Return one value
 */

public class Test4Reduce {

    public static void main(String[] args) {
//        example1();
//        example2();
//        example3();
        example4();
    }

    private static void example2(){
        List<Integer> integerList = new ArrayList<>();
        Optional<Integer> result = integerList.stream().reduce((accumulator, element) -> accumulator * element); // result.get() - method return value from Optional
        if (result.isPresent()) {
            System.out.println(result);
        } else {
            System.out.println("Not present");
        }

    }

    private static void example1() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int result = integerList.stream().reduce((accumulator, element) -> accumulator * element).get(); //factorial
        System.out.println(result);
    }

    private static void example3() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int result = integerList.stream().reduce(3, (accumulator, element) -> accumulator * element); //"3" add in first element to accumulator
        System.out.println(result);
    }

    private static void example4(){
        List<String> strings = Arrays.asList("Iha", "Miha", "Tiha", "Griha");
        String result = strings.stream().reduce((ac, el) -> ac + " " + el).get();
        System.out.println(result);
    }

}
