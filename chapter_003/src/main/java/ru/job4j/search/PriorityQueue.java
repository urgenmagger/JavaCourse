package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяет по полю приоритет.
     * Для вставок использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        if (tasks.isEmpty()) {
            tasks.add(0, task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    tasks.add(i, task);
                    return;
                }
            }
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
