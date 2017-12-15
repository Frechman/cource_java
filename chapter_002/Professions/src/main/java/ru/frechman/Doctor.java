package ru.frechman;

public class Doctor extends Profession {

    public Doctor(String name) {
        super(name);
    }

    public Doctor(String name, Diploma diploma) {
        super(name, diploma);
    }

    public Doctor(String name, Diploma diploma, int workExpience) {
        super(name, diploma, workExpience);
    }

    public Health heal(Patient patient) {
        Health health = new Health(this.getName(), patient, this.writePrescription(patient));
        return health;
    }

    public Health heal(Patient patient, Prescription prescription) {
        Health health = new Health(this.getName(), patient, prescription);
        return health;
    }

    Prescription writePrescription(Patient patient) {
        return new Prescription(this, patient);
    }

    public void putAnEnema(Patient patient) {
        System.out.println(this.getClass().getSimpleName() + this.getName()
                + " put the Enema " + patient.getName());
    }

}