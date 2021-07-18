package ru.kravchenko.chapt2_generics;

/**
 * Example 2. Parameterized class.
 */

public class Test2Parameterized {

    public static void main(String[] args) {
        Info<String> info1 = new Info<>("iha man!!");
        System.out.println(info1);
        Info<Double> info2 = new Info<>(3.14);
        System.out.println(info2);
    }

}

class Info<T> {

    private T value;

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " [{" + value + "}]";
    }

}
