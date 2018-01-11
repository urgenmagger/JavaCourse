package ru.job4j.tracker;

public class StabInput implements Input {
    private String[] answers;
    private int position = 0;

    public StabInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }
}
