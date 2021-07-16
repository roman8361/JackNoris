package ru.kravchenko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Роман");
        list.add("Вартан");
        list.add("Юрик");
        list.add("Iorik");
        list.add("Жорик");
        list.add("Ивано");
        list.add("Яша");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

}
