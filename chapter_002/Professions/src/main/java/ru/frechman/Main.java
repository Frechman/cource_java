package ru.frechman;

public class Main {

    public static void main(String[] args) {

        Doctor doctor = new Doctor("Serg", new Diploma("Height"), 5);

        Patient patient = new Patient("Alex");

        Health healthAlex = doctor.heal(patient);

        doctor.putAnEnema(patient);

        doctor.putAnEnema(new Patient("Mike"));

        Prescription olegPres = doctor.writePrescription(new Patient("Oleg"));
        String s1 = doctor.heal(new Patient("1")).toString();
        String s2 = doctor.heal(new Patient("1"), olegPres).toString();
        doctor.putAnEnema(new Patient("2"));
        System.out.println(doctor.heal(patient).toString());

        System.out.println(s1);
        System.out.println(s2);

    }
}
