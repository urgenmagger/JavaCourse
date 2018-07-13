package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask("Выбрать: "));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("incorrect number");
        }
    }

    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
