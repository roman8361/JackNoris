package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.Arrays;
import java.util.List;

/**
 * findFirst, min, max, limit, skip
 */

public class Test10FindFirstMinMax {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Nikilay", 'm', 28, 2, 6.4);
        Student student3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student student4 = new Student("Petr", 'm', 35, 4, 7);
        Student student5 = new Student("Mariya", 'f', 23, 3, 9.1);
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        example3SkipAndLimit(students);
    }

    private static void example3SkipAndLimit(List<Student> students) {
        students.stream().filter(e -> e.getAge()>20).forEach(System.out::println);
        System.out.println("------------------------------------------------------------");
        students.stream().filter(e -> e.getAge()>20).limit(2).forEach(System.out::println);
        System.out.println("------------------------------------------------------------");
        students.stream().filter(e -> e.getAge()>20).skip(2).forEach(System.out::println);
    }

    private static void example2MinMaxStudent(List<Student> students) {
        Student studentMin = students.stream().min((x, y) -> x.getAge() - y.getAge()).get();
        Student studentMax = students.stream().max((x, y) -> x.getAge() - y.getAge()).get();

//        Student studentMin = students.stream().min(Comparator.comparingInt(Student::getAge)).get(); equals
//        Student studentMax = students.stream().max(Comparator.comparingInt(Student::getAge)).get();

        System.out.println("studentMin : " + studentMin);
        System.out.println("studentMax : " + studentMax);
    }

    private static void example1FindFirst(List<Student> students) {
        Student student = students.stream()
                .map(e -> {
                    e.setName(e.getName().toUpperCase());
                    return e; })
                .filter(e -> e.getSex() == 'f')
                .sorted((x,y) -> x.getAge() - y.getAge())
                .findFirst().get();

//        Student student = students.stream() // TODO equals and min line code
//                .peek(e -> e.setName(e.getName().toUpperCase()))
//                .filter(e -> e.getSex() == 'f').min(Comparator.comparingInt(Student::getAge)).get();

        System.out.println(student);
    }

}
