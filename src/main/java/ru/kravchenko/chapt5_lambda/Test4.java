package ru.kravchenko.chapt5_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Supplier, Consumer, ForEach example
 */

public class Test4 {

    public static void main(String[] args) {
        supplierTest();
        consumerTest();
        forEachTest();
    }

    private static void forEachTest() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 4, 5, 6, 7));
        integerList.forEach(
                num -> {
                    System.out.println("num " + num);
                    System.out.println("num x 2 = " + num * 2);
                });
    }

    private static void consumerTest() {
        Car car = new Car("Skoda", "gray", 1.6);
        System.out.println("car.hashCode() - " + car.hashCode() + " " + car);
        changeCar(car, c -> {
            c.setModel("BMW");
            c.setModel("X5");
            c.setEngine(3.0);
        });
        System.out.println("car.hashCode() - " + car.hashCode() + " " + car);
    }

    private static void supplierTest() {
        List<Car> carList = creatThreeCars(() -> new Car("Vaz", "green", 1.5));
        carList.forEach(System.out::println);
    }

    private static ArrayList<Car> creatThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arrayList.add(carSupplier.get());
        }
        return arrayList;
    }

    private static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

}

class Car {

    private String model;

    private String color;

    private double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
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
