package ru.kravchenko.chapt9_file;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Employee {

    private String firstName;

    private String lastName;

    private String email;

    private String dataOfBirth;

    private String hash;

    public List<String> getAllData(){
        return List.of(firstName, lastName, email, dataOfBirth);
    }

}
