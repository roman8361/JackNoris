package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * filter
 */

public class Test2Filter {

    private static List<Student> students = Arrays.asList(new Student("Ivan", 'm', 22, 3, 8.3),
            new Student("Nikolay", 'm', 28, 2, 6.4),
            new Student("Elena", 'f', 19, 1, 8.9),
            new Student("Petr", 'm', 35, 4, 7),
            new Student("Mariya", 'f', 23, 3, 9.1));

    public static void main(String[] args) {
        students.forEach(System.out::println);
        System.out.println("***************");
        List<Student> studentsFilter = students.stream().filter(s -> s.getAge() > 22 && s.getSex() == 'f').collect(Collectors.toList());
        studentsFilter.forEach(System.out::println);
    }

}
