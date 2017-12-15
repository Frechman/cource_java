package ru.frechman;

public class Profession {
    private String name;
    private Diploma diploma;
    private int workExperience;

    public Profession(String name) {
        this.name = name;
        this.diploma = null;
        this.workExperience = 0;
    }

    public Profession(String name, Diploma diploma) {
        this.name = name;
        this.diploma = diploma;
        this.workExperience = 0;
    }

    public Profession(String name, Diploma diploma, int workExperience) {
        this.name = name;
        this.diploma = diploma;
        this.workExperience = workExperience;
    }

    public String getName() {
        return name;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public int getWorkExperience() {
        return workExperience;
    }
}