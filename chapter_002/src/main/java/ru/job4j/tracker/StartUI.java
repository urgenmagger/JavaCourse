package ru.job4j.tracker;

public class StartUI implements Stop {

    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * поле для выхода из программы
     */
    private boolean exit = true;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        menu.add(new Exit(this));
        do {
            System.out.println("Меню");
            menu.show();
            menu.select(input.ask("Выбрать: ", menu.rangeActions()));
        } while (this.exit);
    }

    public void stop() {
        this.exit = false;
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
