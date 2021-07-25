package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Method chaining
 */
public class Test6MethodChaining {

    private static List<Student> students = Arrays.asList(new Student("Ivan", 'm', 22, 3, 8.3),
            new Student("Nikolay", 'm', 28, 2, 6.4),
            new Student("Elena", 'f', 19, 1, 8.9),
            new Student("Petr", 'm', 35, 4, 7),
            new Student("Mariya", 'f', 23, 3, 9.1));

    public static void main(String[] args) {
        example2();
//        example1();
    }

    private static void example2() {
        List<Student> result = students.stream()
                .map(e -> { e.setName(e.getName().toUpperCase()); return e; })
                .filter(e -> e.getSex() == 'f')
//                .sorted(Comparator.comparingInt(Student::getAge)) // equals
                .sorted((x, y) -> x.getAge() - y.getAge()) //equals
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void example1() {
        int[] array = {1, 3, 3, 2, 4, 5, 777, 85, 3, 2, 45, 1, 22, 4, 764, 12, 22, 44, 56};
        int result = Arrays.stream(array)
                .filter(e -> e % 2 == 1)
                .map(e -> { if (e % 3 == 0) { e = e / 3; } return e; })
                .reduce((a, e) -> a + e).getAsInt();
        System.out.println(result);
    }

}
