package ru.kravchenko.chapt5_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Function example
 */

public class Test5 {

    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student("Ivan", 'm', 22, 3, 8.3));
        studentList.add(new Student("Nikilay", 'm', 28, 2, 6.4));
        studentList.add(new Student("Elena", 'f', 19, 1, 8.9));
        studentList.add(new Student("Petr", 'm', 35, 4, 7));
        studentList.add(new Student("Mariya", 'f', 23, 3, 9.1));
    }

    public static void main(String[] args) {
        Function<Student, Double> avgFunction = student -> student.getAvgGrade();
        System.out.println(getAverageSomething(studentList, avgFunction));  // equals line
        System.out.println(getAverageSomething(studentList, student -> student.getAvgGrade())); // equals line
        System.out.println(getAverageSomething(studentList, Student::getAvgGrade)); // equals line
    }

    private static Double getAverageSomething(List<Student> list, Function<Student, Double> function) {
        Double result = 0.;
        for (Student student : list) {
            result += function.apply(student);
        }
        return result / list.size();
    }

}
