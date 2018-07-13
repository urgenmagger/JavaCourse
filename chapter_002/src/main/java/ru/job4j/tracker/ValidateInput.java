package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;

            } catch (MenuOutException e) {
                System.out.println("Это некорректное число, введите число из списа меню");
            } catch (NumberFormatException e) {
                System.out.println("Это не число, введите число");

            }
        } while (invalid);

        return value;
    }
}
