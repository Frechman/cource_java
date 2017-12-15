package ru.frechman;

public class Patient {

    private String name;
    private Health health;

    public Patient(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
