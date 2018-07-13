package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

/**
 * outer class
 */
class Exit extends BaseActions {
    private final Stop stop;

    public Exit(int key, String name, Stop stop) {
        super(key, name);
        this.stop = stop;
    }

    Exit(Stop exit) {
        super(6, "Выход из программы");
        this.stop = exit;
    }

    public void execute(Input input, Tracker tracker) {
        this.stop.stop();
    }


}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>(7);

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    public void fillActions() {
        this.actions.add(this.new AddItem(0, "Добавить заявку"));
        this.actions.add(new MenuTracker.ShowAllItems(1, "Показать все заявки"));
        this.actions.add(this.new EditItem(2, "Редактирование"));
        this.actions.add(this.new DeleteItem(3, "Удаление"));
        this.actions.add(this.new FindIdItem(4, "Поиск по id"));
        this.actions.add(this.new FindNameItem(5, "Поиск по названию"));
    }

    public int[] rangeActions() {
        int[] result = new int[actions.size()];
        for (int i = 1; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }


    public void add(UserAction action) {
        this.actions.add(action);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }


    private class AddItem extends BaseActions {
        public AddItem(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String description = input.ask("Введите описание заявки: ");
            Item item = new Item(name, description);
            tracker.add(item);
            System.out.println("------------ Новая заявка с id : " + item.getId() + "-----------");
        }

    }

    private class DeleteItem extends BaseActions {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки--------------");
            String id = input.ask("Введите id заявки: ");
            tracker.deleteItem(id);
            System.out.println("------Заявка с id " + id + " удалена");
        }

    }

    private class FindIdItem extends BaseActions {
        public FindIdItem(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id--------------");
            String findId = input.ask("Введите id заявки: ");
            System.out.println("Имя заявки: " + tracker.findById(findId).getName());
            System.out.println("Описание заявки: " + tracker.findById(findId).getDescription());
        }

    }

    private class FindNameItem extends BaseActions {

        public FindNameItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String findName = input.ask("Введите имя заявки: ");
            List<Item> result = tracker.findByName(findName);
            for (Item item : result) {
                System.out.println("обнаруженные совпадения по имени: " + item.getName());
                System.out.println("описание заявки: " + item.getDescription());
                System.out.println("id заявки: " + item.getId());
                System.out.println("-----------");
            }
        }

    }


    /**
     * inner static class
     */
    private static class ShowAllItems extends BaseActions {


        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки--------------");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("Имя заявки: %s", item.getName()));
                System.out.println(String.format("Описание заявки: %s", item.getDescription()));
            }
        }
    }

    /**
     * inner class
     */
    private class EditItem extends BaseActions {
        public EditItem(int key, String name) {
            super(key, name);
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
    }
}