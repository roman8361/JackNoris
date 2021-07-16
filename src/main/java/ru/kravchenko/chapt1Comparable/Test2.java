package ru.kravchenko.chapt1Comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Example Comparator
 */
public class Test2 {

    public static void main(String[] args) {
        Employee2 employee1 = new Employee2(10, "Ivan", "Petrov", 50000);
        Employee2 employee2 = new Employee2(20, "Roman", "Sidorov", 250000);
        Employee2 employee3 = new Employee2(30, "Aleksandr", "Illarioj", 150000);
        Employee2 employee4 = new Employee2(40, "Sergei", "Slavsky", 100000);
        List<Employee2> employees2 = Arrays.asList(employee1, employee2, employee3, employee4);
        employees2.forEach(System.out::println);
//        Collections.sort(employees2, new SalaryComparator());// line 20 and 21 equals
        employees2.sort(new SalaryComparator());
        System.out.println("***** AFTER SORT *****");
        employees2.forEach(System.out::println);
    }

}

class SalaryComparator implements Comparator<Employee2>{

    @Override
    public int compare(Employee2 emp1, Employee2 emp2) {
        //        TODO classic example
//        if (this.salary == employee.salary){
//            return 0;
//        } else if (this.salary < employee.salary) {
//            return -1;
//        } else {
//            return 1;
//        }
        // TODO inline
        return emp1.getSalary() - emp2.getSalary();
//         TODO inline
//        return emp1.getSalary().compareTo(emp2.getSalary());
    }

}

class Employee2  {

    private final Integer id;

    private final String name;

    private final String surname;

    private final Integer salary;

    public Employee2(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getSalary() {
        return salary;
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
