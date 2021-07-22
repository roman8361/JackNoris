package ru.kravchenko.chapt5_lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Test4 {

    public static void main(String[] args) {
    }

    private static ArrayList<Car> createCars (Supplier<Car> carSupplier){
        ArrayList<Car> arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arrayList.add(carSupplier.get());
        }

        return arrayList;
    }

}

class Car {

    private final String model;

    private final String color;

    private final double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }

}
