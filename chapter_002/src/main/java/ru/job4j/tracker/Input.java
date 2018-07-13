package ru.job4j.tracker;

import java.util.List;

/**
 *
 */
public interface Input {
    /**
     * @param question - q.
     * @return string.
     */
    String ask(String question);

    int ask(String question, int[] range);

}
