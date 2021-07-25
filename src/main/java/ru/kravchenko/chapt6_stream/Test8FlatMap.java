package ru.kravchenko.chapt6_stream;

import ru.kravchenko.chapt5_lambda.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * FlatMap
 */

public class Test8FlatMap {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Nikilay", 'm', 28, 2, 6.4);
        Student student3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student student4 = new Student("Petr", 'm', 35, 4, 7);
        Student student5 = new Student("Mariya", 'f', 23, 3, 9.1);

        Faculty facultyEconomic = new Faculty("Economic");
        Faculty facultyMathematics = new Faculty("Mathematics");

        facultyEconomic.addStudent(student1);
        facultyEconomic.addStudent(student2);
        facultyEconomic.addStudent(student3);
        facultyMathematics.addStudent(student4);
        facultyMathematics.addStudent(student5);

        List<Faculty> faculties = new ArrayList<>();

        faculties.add(facultyEconomic);
        faculties.add(facultyMathematics);
        faculties.stream().flatMap(faculty -> faculty.getStudentOnFaculty().stream())
                .forEach(student -> System.out.println(student.getName()));
    }

}

class Faculty {

    private final String facultyName;

    private final List<Student> studentList;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
        studentList = new ArrayList<>();
    }

    void addStudent(Student student) {
        this.studentList.add(student);
    }

    List<Student> getStudentOnFaculty() {
        return this.studentList;
    }

}
