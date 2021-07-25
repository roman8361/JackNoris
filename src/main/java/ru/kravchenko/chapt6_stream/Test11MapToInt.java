package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test11MapToInt {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Nikilay", 'm', 28, 2, 6.4);
        Student student3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student student4 = new Student("Petr", 'm', 35, 4, 7);
        Student student5 = new Student("Mariya", 'f', 23, 3, 9.1);
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        example2MinSumAverage(students);
    }

    private static void example2MinSumAverage(List<Student> students) {
        int sum = students.stream().mapToInt(value -> value.getCourse()).sum();
//        int sum = students.stream().mapToInt(Student::getCourse).sum(); equals
        double average = students.stream().mapToDouble(value -> value.getAvgGrade()).average().getAsDouble();
        int min = students.stream().mapToInt(value -> value.getAge()).min().getAsInt();
    }

    private static void example1(List<Student> students) {
        List<Integer> courseList = students.stream()
                .mapToInt(e1 -> e1.getCourse())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(courseList);
    }

}
