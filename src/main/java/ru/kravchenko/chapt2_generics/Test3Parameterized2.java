package ru.kravchenko.chapt2_generics;

/**
 * Example 3. Pair class this generics
 */

class Test2Parameterized2 {

    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Demon2", 18);
        System.out.println("value1: " + pair1.getValue1() + "\n" + "value2: " + pair1.getValue2());
        Pair<Double, String> pair2 = new Pair<>(3.14, "Pi");
        System.out.println("value1: " + pair2.getValue1() + "\n" + "value2: " + pair2.getValue2());
    }

}

class Pair<V1, V2> {

    private final V1 value1;

    private final V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }

}
