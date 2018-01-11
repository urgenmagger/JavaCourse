package ru.job4j.tracker;

import org.junit.Test;

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
        assertThat(tracker.findAll()[0], is(item));
    }


    /**
     * Test.
     *
     * @Test update item.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
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
        Item[] expect = {delItem, delItem1};
        assertThat(tracker.findAll(), is(expect));
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
        Item delItem1 = new Item("test1", "testDescription", 123L);
        Item delItem2 = new Item("test3", "testDescription1", 123L);
        tracker.add(delItem);
        tracker.add(delItem1);
        tracker.add(delItem2);
        tracker.findByName(delItem1.getName());
        Item[] expect = {delItem, delItem1};
        assertThat(tracker.findByName(delItem1.getName()), is(expect));
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
        Item[] expect = {delItem, delItem1, delItem2};
        assertThat(tracker.findAll(), is(expect));

    }

}