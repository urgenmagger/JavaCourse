package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    String lineSeparator = System.getProperty("line.separator");

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    private final String showMenu = new StringBuilder()
            .append("Меню")
            .append(lineSeparator)
            .append("0.Добавить заявку")
            .append(lineSeparator)
            .append("1.Показать все заявки")
            .append(lineSeparator)
            .append("2.Редактирование")
            .append(lineSeparator)
            .append("3.Удаление")
            .append(lineSeparator)
            .append("4.Поиск по id")
            .append(lineSeparator)
            .append("5.Поиск по названию")
            .append(lineSeparator)
            .append("6.Выход из программы")
            .append(lineSeparator)
            .toString();


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "description"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "newTest name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("newTest name"));
    }

    @Test
    public void deleteItemTest() {
        Tracker tracker = new Tracker();
        Item itemTestTwo = tracker.add(new Item("testTwo name", "description"));
        Item itemTestOne = tracker.add(new Item("testOne name", "description"));
        Input input = new StubInput(new String[]{"3", itemTestTwo.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] except = {itemTestOne};
        assertThat(tracker.findAll(), is(except));
    }

    @Test
    public void showAllItemTest() {
        Tracker tracker = new Tracker();
        Item itemTestTwo = tracker.add(new Item("testTwo name", "description"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String result = new String(out.toByteArray());
        String except = new StringBuilder()
                .append(this.showMenu)
                .append("------------ Все заявки--------------")
                .append(lineSeparator)
                .append("Имя заявки: ")
                .append(itemTestTwo.getName())
                .append(lineSeparator)
                .append("Описание заявки: ")
                .append(itemTestTwo.getDescription())
                .append(lineSeparator)
                .append(this.showMenu)
                .toString();
        assertThat(except, is(result));
    }

    @Test
    public void findByIdItemTest() {
        Tracker tracker = new Tracker();
        Item itemTestOne = tracker.add(new Item("testOne name", "description"));
        Input input = new StubInput(new String[]{"4", itemTestOne.getId(), "6"});
        new StartUI(input, tracker).init();
        String result = new String(out.toByteArray());
        String except = new StringBuilder()
                .append(this.showMenu)
                .append("------------ Поиск заявки по id--------------")
                .append(lineSeparator)
                .append("Имя заявки: ")
                .append(itemTestOne.getName())
                .append(lineSeparator)
                .append("Описание заявки: ")
                .append(itemTestOne.getDescription())
                .append(lineSeparator)
                .append(this.showMenu)
                .toString();
        assertThat(except, is(result));
    }

    @Test
    public void findByNameItemTest() {
        Tracker tracker = new Tracker();
        Item itemTestTwo = tracker.add(new Item("testTwo name", "description"));
        Item itemTestOne = tracker.add(new Item("testOne name", "description"));
        Input input = new StubInput(new String[]{"5", itemTestOne.getName(), "6"});
        new StartUI(input, tracker).init();
        String result = new String(out.toByteArray());
        String except = new StringBuilder()
                .append(this.showMenu)
                .append("------------ Поиск заявки по имени --------------")
                .append(lineSeparator)
                .append("обнаруженные совпадения по имени: ")
                .append(itemTestOne.getName())
                .append(lineSeparator)
                .append("описание заявки: ")
                .append(itemTestOne.getDescription())
                .append(lineSeparator)
                .append("id заявки: ")
                .append(itemTestOne.getId())
                .append(lineSeparator)
                .append("-----------")
                .append(lineSeparator)
                .append(this.showMenu)
                .toString();
        assertThat(except, is(result));
    }
}
