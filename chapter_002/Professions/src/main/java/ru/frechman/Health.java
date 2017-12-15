package ru.frechman;

public class Health {
    private String nameDoctor;
    private Patient patient;
    private Prescription prescription;

    public Health(String nameDoctor, Patient patient, Prescription prescription) {
        this.nameDoctor = nameDoctor;
        this.patient = patient;
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return nameDoctor + " is healing " + this.patient.getName() + " c diagnoses " + prescription.getRecipeGood();
    }
}
