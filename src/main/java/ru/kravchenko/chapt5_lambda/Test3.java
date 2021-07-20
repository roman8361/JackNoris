package ru.kravchenko.chapt5_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Example Predicate, lambda
 */

public class Test3 {

    private static final List<Student> students = Arrays.asList(new Student("Ivan", 'm', 22, 3, 8.3),
            new Student("Nikolay", 'm', 28, 2, 6.4),
            new Student("Elena", 'f', 19, 1, 8.9),
            new Student("Petr", 'm', 35, 4, 7),
            new Student("Mariya", 'f', 23, 3, 9.1));

    private static final List<String> names = new ArrayList<>(Arrays.asList("Roman", "Brant", "Botan", "Obeziay"));

    public static void main(String[] args) {
//        predicate1();
//        predicate2();
//        predicate3();
        predicate4();
        System.out.println("****************");
    }

    private static void predicate4() {
        Predicate<Student> p1 = s -> s.getSex() == 'm';
        Predicate<Student> p2 = s -> s.getCourse() == 2;
        filterMethodPredicate(students, p1.and(p2));
    }

    private static void predicate3() {
        Predicate<String> predicate = element -> element.contains("B"); // alternative variate Predicate
        names.removeIf(predicate);
        names.forEach(System.out::println);
    }

    private static void predicate2() {
        names.removeIf(n -> n.length() == 7); // remove by condition
        names.forEach(System.out::println);
    }

    private static void predicate1() {
        filterMethodPredicate(students, s -> s.getSex() == 'm');
    }

    private static void filterMethodPredicate(List<Student> studentList, Predicate<Student> predicate) {
        studentList.forEach((student) -> {
            if (predicate.test(student)) System.out.println(student);
        });
    }

}

