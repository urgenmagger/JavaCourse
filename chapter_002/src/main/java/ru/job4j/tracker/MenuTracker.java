package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
    private final Consumer output;
    private List<UserAction> actions = new ArrayList<>(7);

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
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
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String description = input.ask("Введите описание заявки: ");
            Item item = new Item(name, description);
            tracker.add(item);
            output.accept("------------ Новая заявка с id : " + item.getId() + "-----------");
        }

    }

    private class DeleteItem extends BaseActions {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки--------------");
            String id = input.ask("Введите id заявки: ");
            tracker.deleteItem(id);
            output.accept("------Заявка с id " + id + " удалена");
        }

    }

    private class FindIdItem extends BaseActions {
        public FindIdItem(int key, String name) {
            super(key, name);
        }


        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по id--------------");
            String findId = input.ask("Введите id заявки: ");
            output.accept("Имя заявки: " + tracker.findById(findId).getName());
            output.accept("Описание заявки: " + tracker.findById(findId).getDescription());
        }

    }

    private class FindNameItem extends BaseActions {

        public FindNameItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявки по имени --------------");
            String findName = input.ask("Введите имя заявки: ");
            List<Item> result = tracker.findByName(findName);
            for (Item item : result) {
                output.accept("обнаруженные совпадения по имени: " + item.getName());
                output.accept("описание заявки: " + item.getDescription());
                output.accept("id заявки: " + item.getId());
                output.accept("-----------");
            }
        }

    }


    /**
     * inner static class
     */
    private class ShowAllItems extends BaseActions {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Все заявки--------------");
            for (Item item : tracker.findAll()) {
                output.accept(String.format("Имя заявки: %s", item.getName()));
                output.accept(String.format("Описание заявки: %s", item.getDescription()));
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
            output.accept("------------  Заявка с id : " + item.getId() + " отредатирована");

        }
    }
}