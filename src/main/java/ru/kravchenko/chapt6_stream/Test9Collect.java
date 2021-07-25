package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors: groupingBy, partitioningBy
 */

public class Test9Collect {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Nikilay", 'm', 28, 2, 6.4);
        Student student3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student student4 = new Student("Petr", 'm', 35, 4, 7);
        Student student5 = new Student("Mariya", 'f', 23, 3, 9.1);
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        example1GroupingByCourse(students);
        example2PartitionByAvgGrade(students);
    }

    private static void example2PartitionByAvgGrade(List<Student> students) {
        //Stream return Map key -> true/false, value List<Student> working method resultPartitionBy
        Map<Boolean, List<Student>> resultPartitionBy = students.stream().collect(Collectors.partitioningBy(e1 -> e1.getAvgGrade() > 7 ));
        for (Map.Entry<Boolean, List<Student>> entry : resultPartitionBy.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

    private static void example1GroupingByCourse(List<Student> students) {
        //Stream return Map key -> course (1, 2, 3, 4), value List<Student> working method groupingBy
        Map<Integer, List<Student>> resultGroupingByCourse = students.stream()
                .map(student -> {
            student.setName(student.getName().toUpperCase());
            return student; })
                .collect(Collectors.groupingBy(e1 -> e1.getCourse()));
//        Map<Integer, List<Student>> resultGroupingByCourse = students.stream()  TODO this equals stream
//                .peek(student -> student.setName(student.getName().toUpperCase()))
//                .collect(Collectors.groupingBy(Student::getCourse));
        for (Map.Entry<Integer, List<Student>> entry : resultGroupingByCourse.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

}
