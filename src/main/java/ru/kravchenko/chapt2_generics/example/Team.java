package ru.kravchenko.chapt2_generics.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> { // TODO <T> When creating an object, it will required to determine the type of List Participant

    private final String name;

    private final List<T> participantList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participantList.add(participant);
        System.out.println("To command " + name + " was add participant - " + (participant).getName());
    }

    public void playWith(Team<T> team) { // restriction play only type (schoolboy, student, employee)
        String winnerTeam;
        Random random = new Random();
        int i = random.nextInt(2);
        winnerTeam = i == 0 ? this.name : team.name;
        System.out.println("Team is " + winnerTeam + " winner!!!");
    }

}
