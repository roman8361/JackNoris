package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorted
 */

public class Test5Sorted {

    private static List<Student> students = Arrays.asList(new Student("Ivan", 'm', 22, 3, 8.3),
            new Student("Nikolay", 'm', 28, 2, 6.4),
            new Student("Elena", 'f', 19, 1, 8.9),
            new Student("Petr", 'm', 35, 4, 7),
            new Student("Mariya", 'f', 23, 3, 9.1));

    public static void main(String[] args) {
        example2();
//        example1();
    }

    //sorted by name
    private static void example2() {
        students = students.stream().sorted((x, y) ->
                x.getName().compareTo(y.getName())
                ).collect(Collectors.toList());
        System.out.println(students);
    }

    private static void example1() {
        int [] array = {1, 3, 3, 2, 4, 5, 777, 85, 3, 2, 45};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
    }

}
