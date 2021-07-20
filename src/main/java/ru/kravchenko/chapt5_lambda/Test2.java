package ru.kravchenko.chapt5_lambda;

public class Test2 {

    static void def(I i) {
        System.out.println(i.abc("hello"));
    }

    public static void main(String[] args) {
        int i = 10;
        def((String str) -> {
            System.out.println("any string $) " + i);
            return str.length() + i;
        });

//        def(String::length); //in line string length
    }

}

interface I {

    int abc(String s);

}
