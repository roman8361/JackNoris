package ru.kravchenko.chapt1_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Example Comparable
 */
public class Test1 {

    public static void main(String[] args) {
        Employee employee1 = new Employee(10, "Ivan", "Petrov", 50000);
        Employee employee2 = new Employee(20, "Roman", "Sidorov", 250000);
        Employee employee3 = new Employee(30, "Aleksandr", "Illarioj", 150000);
        Employee employee4 = new Employee(40, "Sergei", "Slavsky", 100000);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4);
        employees.forEach(System.out::println);
        Collections.sort(employees);
        System.out.println("***** AFTER SORT *****");
        employees.forEach(System.out::println);
    }

}

class Employee implements Comparable<Employee> {

    private final Integer id;

    private final String name;

    private final String surname;

    private final Integer salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
//        TODO classic example
//        if (this.salary == employee.salary){
//            return 0;
//        } else if (this.salary < employee.salary) {
//            return -1;
//        } else {
//            return 1;
//        }
        // TODO inline
//        return this.salary - employee.salary;
        // TODO inline
        return this.salary.compareTo(employee.salary); // sort by salary
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

}
