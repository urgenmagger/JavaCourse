package ru.job4j.tracker;


/**
 * outer class
 */
class Exit implements UserAction {
    private final Stop input;

    Exit(Stop exit) {
        this.input = exit;
    }

    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        this.input.stop();
    }

    public String info() {
        return String.format("%s.%s", this.key(), "Выход из программы");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[this.position++] = this.new AddItem();
        this.actions[this.position++] = new MenuTracker.ShowAllItems();
        this.actions[this.position++] = this.new EditItem();
        this.actions[this.position++] = this.new DeleteItem();
        this.actions[this.position++] = this.new FindIdItem();
        this.actions[this.position++] = this.new FindNameItem();
    }

    public int[] rangeActions() {
        int[] result = new int[actions.length];
        for (int i = 1; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    public void add(UserAction action) {
        this.actions[this.position++] = action;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }


    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String description = input.ask("Введите описание заявки: ");
            Item item = new Item(name, description);
            tracker.add(item);
            System.out.println("------------ Новая заявка с id : " + item.getId() + "-----------");
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Добавить заявку");
        }
    }

    private class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки--------------");
            String id = input.ask("Введите id заявки: ");
            tracker.deleteItem(id);
            System.out.println("------Заявка с id " + id + " удалена");
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Удаление");
        }
    }

    private class FindIdItem implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id--------------");
            String findId = input.ask("Введите id заявки: ");
            System.out.println("Имя заявки: " + tracker.findById(findId).getName());
            System.out.println("Описание заявки: " + tracker.findById(findId).getDescription());
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Поиск по id");
        }
    }

    private class FindNameItem implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String findName = input.ask("Введите имя заявки: ");
            Item[] result = tracker.findByName(findName);
            for (Item item : result) {
                System.out.println("обнаруженные совпадения по имени: " + item.getName());
                System.out.println("описание заявки: " + item.getDescription());
                System.out.println("id заявки: " + item.getId());
                System.out.println("-----------");
            }
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Поиск по названию");
        }
    }


    /**
     * inner static class
     */
    private static class ShowAllItems implements UserAction {


        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки--------------");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("Имя заявки: %s", item.getName()));
                System.out.println(String.format("Описание заявки: %s", item.getDescription()));
            }
        }

        public String info() {
            return String.format("%s.%s", this.key(), "Показать все заявки");
        }
    }

    /**
     * inner class
     */
    private class EditItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id: ");
            String name = input.ask("Введите имя заявки: ");
            String description = input.ask("Введите описание заявки: ");
            Item item = new Item(name, description);
            item.setId(id);
            tracker.replace(id, item);
            System.out.println("------------  Заявка с id : " + item.getId() + " отредатирована");

        }

        public String info() {
            return String.format("%s.%s", this.key(), "Редактирование");
        }
    }
}
