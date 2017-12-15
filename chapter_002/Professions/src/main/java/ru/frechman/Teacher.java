package ru.frechman;

public class Teacher extends Profession {

    public Teacher(String name) {
        super(name);
    }

    public Teacher(String name, Diploma diploma) {
        super(name, diploma);
    }

    public Teacher(String name, Diploma diploma, int workExpience) {
        super(name, diploma, workExpience);
    }

    public Knoledge teach(Student student) {
        return null;
    }

    public Grade assessmentOf(Student student) {

        return Grade.valueOf("5");
    }

    public void task(Student student, Task task) {

    }

    public void question(Student student, String question) {

    }
}