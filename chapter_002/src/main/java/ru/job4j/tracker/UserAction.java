package ru.job4j.tracker;

public interface UserAction {
    //unique key
    int key();

    //action
    void execute(Input input, Tracker tracker);

    String info();
}
