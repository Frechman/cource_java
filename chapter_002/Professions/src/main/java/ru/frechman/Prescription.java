package ru.frechman;

public class Prescription {
    private String recipeGood;
    private String recipeBad;

    public Prescription(Doctor doctor, Patient patient) {
        this.recipeGood = doctor.getName() + "wrote to " + patient.getName() + " recipe is GOOD";
        this.recipeBad = doctor.getName() + "wrote to " + patient.getName() + " recipe is BAD";
    }

    public String getRecipeGood() {
        return recipeGood;
    }

    public String getRecipeBad() {
        return recipeBad;
    }
}
