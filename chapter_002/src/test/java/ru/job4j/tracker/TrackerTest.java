package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Megger.
 */
public class TrackerTest {
    /**
     * Test.
     *
     * @Test add new item.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }


    /**
     * Test.
     *
     * @Test update item.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        // Добавляем вторую заявку, чтобы проверить, что она не изменится.
        Item immutable = new Item("testImmutable", "immutable item", 123L);
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        tracker.add(immutable);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        List<Item> list = new ArrayList<>();
        list.add(immutable);
        list.add(next);

        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test.
     *
     * @Test findById.
     */
    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item find = new Item("test1", "testDescription", 123L);
        tracker.add(find);
        assertThat(tracker.findById(find.getId()).getName(), is("test1"));
    }

    /**
     * Test.
     *
     * @Test method delete.
     */
    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item delItem = new Item("test1", "testDescription", 123L);
        Item delItem1 = new Item("test2", "testDescription", 123L);
        Item delItem2 = new Item("test3", "testDescription", 123L);
        tracker.add(delItem);
        tracker.add(delItem1);
        tracker.add(delItem2);
        tracker.deleteItem(delItem2.getId());
        List<Item> list = new ArrayList<>();
        list.add(delItem);
        list.add(delItem1);
        assertThat(tracker.findAll(), is(list));
    }

    /**
     * Test.
     *
     * @Test method findByName.
     */
    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item delItem = new Item("test1", "testDescription", 123L);
        Item delItem1 = new Item("test1", "description", 123L);
        Item delItem2 = new Item("test3", "testDescription1", 123L);
        tracker.add(delItem);
        tracker.add(delItem1);
        tracker.add(delItem2);
        tracker.findByName(delItem1.getName());
        List<Item> list = new ArrayList<>();
        list.add(delItem);
        list.add(delItem1);
        assertThat(tracker.findByName(delItem1.getName()), is(list));
    }

    /**
     * Test.
     *
     * @Test method findAll.
     */
    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        Item delItem = new Item("test1", "testDescription", 123L);
        Item delItem1 = new Item("test1", "testDescription", 123L);
        Item delItem2 = new Item("test3", "testDescription1", 123L);
        tracker.add(delItem);
        tracker.add(delItem1);
        tracker.add(delItem2);
        List<Item> list = new ArrayList<>();
        list.add(delItem);
        list.add(delItem1);
        list.add(delItem2);
        assertThat(tracker.findAll(), is(list));

    }

}