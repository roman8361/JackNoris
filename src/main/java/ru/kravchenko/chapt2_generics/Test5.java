package ru.kravchenko.chapt2_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 5. Wildcard.
 */

public class Test5 {

    public static void main(String[] args) {
//        List<Number> list = new ArrayList<Integer>(); // error compiler
//        List<Object> list2 = new ArrayList<Integer>(); // error compiler
        List<?> list3 = new ArrayList<Integer>(); // permissible value
        List<Double> doubleList = Arrays.asList(12.2, 3.14, 333.444);
        List<String> stringList = Arrays.asList("test", "any body", "iha man");
        showListInfo(doubleList);
        showListInfo(stringList);
        List<Double> doubleList1 = Arrays.asList(12.3, 11.2, 222.3);
        List<Integer> integers = Arrays.asList(12, 11, 222);
        List<Float> floatList = Arrays.asList(1211f, 112f, 22002f);
        System.out.println(sum(doubleList1));
        System.out.println(sum(integers));
        System.out.println(sum(floatList));
    }

    static void showListInfo(List<?> list) {
        System.out.println("This is list element: " + list);
    }

    static Double sum(List<? extends Number> list) {
        double result = 0.0;
        for (Number n : list) {
            result += n.doubleValue();
        }
        return result;
    }

}
