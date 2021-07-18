package ru.kravchenko.chapt2_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1. Why we are using generics.
 */

public class Test1 {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("OK");
        list.add(11233);
        list.add(new Car());

        for (Object o : list){
            System.out.println(((String)o).length()); // this line throw ClassCastException,
            // if we use Generics in List<String> we are not have error
            // two advantages when using generics: type sage, reusable code
        }
    }

}

class Car {

}
