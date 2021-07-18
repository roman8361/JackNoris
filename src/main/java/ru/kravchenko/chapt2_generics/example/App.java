package ru.kravchenko.chapt2_generics.example;

public class App {

    public static void main(String[] args) {
        Schoolboy schoolboy1 = new Schoolboy("Ivan", 12);
        Schoolboy schoolboy2 = new Schoolboy("Mariya", 15);
        Schoolboy schoolboy3 = new Schoolboy("Dima", 13);
        Schoolboy schoolboy4 = new Schoolboy("Olya", 14);
        Student student1 = new Student("Nelly", 20);
        Student student2 = new Student("Vasya", 22);
        Employee employee1 = new Employee("Roman", 38);
        Employee employee2 = new Employee("Marina", 34);
        Team<Schoolboy> schoolTeam1 = new Team<>("Dragon");
        Team<Schoolboy> schoolTeam2 = new Team<>("Smart");
        Team<Student> studentTeam = new Team<>("Fast");
        Team<Employee> employeeTeam = new Team<>("Rabotygi");
        schoolTeam1.addNewParticipant(schoolboy1);
        schoolTeam1.addNewParticipant(schoolboy2);
        schoolTeam2.addNewParticipant(schoolboy3);
        schoolTeam2.addNewParticipant(schoolboy4);
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        schoolTeam1.playWith(schoolTeam2);
    }

}
