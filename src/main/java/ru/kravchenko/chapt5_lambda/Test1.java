package ru.kravchenko.chapt5_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Nikilay", 'm', 28, 2, 6.4);
        Student student3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student student4 = new Student("Petr", 'm', 35, 4, 7);
        Student student5 = new Student("Mariya", 'f', 23, 3, 9.1);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
//        testStudent(students, new CheckOverGrade());
//        printStudentOverGrade(students, 8);
        System.out.println("********************");
//        printStudentUnderAge(students, 30);
        Collections.sort(students, (stud1, stud2) -> stud1.getCourse() - stud2.getCourse()); // example sort by course with lambda
        students.forEach(System.out::println);
        testStudent(students, new StudentChecks() {
            @Override
            public boolean check(Student student) {
                return student.getAge() > 30;
            }
        });
        System.out.println("********************");
        testStudent(students, s -> s.getAvgGrade() > 8);
        System.out.println("********************");
        testStudent(students,(Student s) -> {return s.getAge() > 30;});
        System.out.println("********************");
        testStudent(students, s -> s.getSex() == 'f' && s.getAge() >= 23);
//        printStudentMixCondition(students, 20, 9.5, 'f');
    }

    private static void testStudent(List<Student> studentList, StudentChecks studentChecks ) {
        for (Student s: studentList) {
            if (studentChecks.check(s)) System.out.println(s);
        }
    }

//    private static void printStudentOverGrade(List<Student> studentList, double grade) {
//        for (Student s : studentList) {
//            if (s.getAvgGrade() > grade) System.out.println(s);
//        }
//    }
//
//    private static void printStudentUnderAge(List<Student> studentList, int age) {
//        for (Student s : studentList) {
//            if (s.getAge() < age) System.out.println(s);
//        }
//    }
//
//    private static void printStudentMixCondition(List<Student> studentList, int age, double grade, char sex) {
//        for (Student s : studentList) {
//            if (s.getAge() > age && s.getAvgGrade() < grade && s.getSex() == sex) System.out.println(s);
//        }
//    }

}

interface StudentChecks{
    boolean check(Student student);
}

//class CheckOverGrade implements StudentChecks {
//
//    @Override
//    public boolean check(Student student) {
//        return student.getAvgGrade() > 8;
//    }
//
//}
