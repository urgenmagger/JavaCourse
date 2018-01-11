package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String FINDALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String REPLACEITEM = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETEITEM = "3";
    /**
     * Константа меню для нахождения заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FINDALL.equals(answer)) {
                this.showAllItems();
            } else if (REPLACEITEM.equals(answer)) {
                this.replaceItems();
            } else if (DELETEITEM.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdItems();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void showMenu() {
        System.out.println("<++++++++++++++>");
        System.out.println("Меню.");
        System.out.println("0. Добавить заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактирование");
        System.out.println("3. Удаление");
        System.out.println("4. Поиск по id");
        System.out.println("5. Поиск по названию");
        System.out.println("6. Выход:");
        System.out.println("Выбрать: ");
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String description = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует показ всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Все заявки--------------");
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println("Имя заявки: " + tracker.findAll()[i].getName());
            System.out.println("Описание заявки: " + tracker.findAll()[i].getDescription());
        }
    }

    /**
     * Метод редактирует заявки.
     */
    private void replaceItems() {
        System.out.println("------------ Редактирование заявки--------------");
        String newId = this.input.ask("Введите id заявки: ");
        String newName = this.input.ask("Введите новое имя заявки: ");
        String newDescription = this.input.ask("Введите новое описание заявки: ");
        Item next = new Item(newName, newDescription);
        next.setId(newId);
        this.tracker.replace(newId, next);
        System.out.println("------------ Заявка с id " + newId + " отредактирована");
    }

    /**
     * Метод удаляет заявку.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки--------------");
        String delId = this.input.ask("Введите id заявки: ");
        this.tracker.deleteItem(delId);
        System.out.println("------Заявка с id " + delId + " удалена");
    }

    /**
     * Метод поиска заявки по id.
     */
    private void findByIdItems() {
        System.out.println("------------ Поиск заявки по id--------------");
        String findId = this.input.ask("Введите id заявки: ");
        System.out.println("Имя заявки: " + this.tracker.findById(findId).getName());
        System.out.println("Описание заявки: " + this.tracker.findById(findId).getDescription());
    }

    /**
     * Метод поиска заявки по имени.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String findName = this.input.ask("Введите имя заявки: ");
        Item[] result = this.tracker.findByName(findName);
        for (Item item : result) {
            System.out.println("обнаруженные совпадения по имени: " + item.getName());
            System.out.println("описание заявки: " + item.getDescription());
            System.out.println("id заявки: " + item.getId());
            System.out.println("-----------");
        }
    }


    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
