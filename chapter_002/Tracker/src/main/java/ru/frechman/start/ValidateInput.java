package ru.frechman.start;

public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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