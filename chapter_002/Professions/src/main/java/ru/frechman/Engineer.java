package ru.frechman;

public class Engineer extends Profession {


    public Engineer(String name) {
        super(name);
    }

    public Engineer(String name, Diploma diploma) {
        super(name, diploma);
    }

    public Engineer(String name, Diploma diploma, int workExperience) {
        super(name, diploma, workExperience);
    }

    public void repair(Client client, Subject subject) {
        System.out.println(this.getClass().getSimpleName() + this.getName()
                + " repaired Object" + client.getName());
    }
}
