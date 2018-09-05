package ru.frechman;

public class Doctor extends Profession {

    public Doctor(String name) {
        super(name);
    }

    public Doctor(String name, Diploma diploma) {
        super(name, diploma);
    }

    public Doctor(String name, Diploma diploma, int workExperience) {
        super(name, diploma, workExperience);
    }

    public Health heal(Patient patient) {
        return new Health(this.getName(), patient, this.writePrescription(patient));
    }

    public Health heal(Patient patient, Prescription prescription) {
        return new Health(this.getName(), patient, prescription);
    }

    Prescription writePrescription(Patient patient) {
        return new Prescription(this, patient);
    }

    public void putAnEnema(Patient patient) {
        System.out.println(this.getClass().getSimpleName() + this.getName()
                + " put the Enema " + patient.getName());
    }

}