package ru.frechman.start;

public class ValidateInput implements Input {

    private Input input;

    ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, enter item from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
