package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
