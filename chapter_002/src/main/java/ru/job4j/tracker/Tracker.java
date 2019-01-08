package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Tracker class.
 *
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * id - id.
     */
    private List<Item> items = new ArrayList<>(100);
    /**
     * RN - generate random number.
     */
    private static final Random RN = new Random();

    /**
     * id - id.
     */
    private int position = 0;


    /**
     * @param items - items.
     * @return add bid.
     */

    public Item add(Item items) {
        items.setId(generateId());
        this.items.add(items);
        position++;
        return items;
    }

    /**
     * method replace items.
     * 02.08.2018 рефакторинг, добавление метода int indexOf(Object obj), без него метод
     * replace не работал нa нескольких заявках при запуске tracker.jar.
     *
     * @param item - items.
     * @param id   - id.
     */
    public void replace(String id, Item item) {
        for (Item task : items) {
            if (task != null && task.getId().equals(id)) {
                //возвращаю первое вхождение методом int indexOf(Object obj);
                this.items.set(this.items.indexOf(task), item);
                break;
            }
        }
    }

    /**
     * method delete items.
     *
     * @param id - id.
     */
    public void deleteItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                this.items.remove(items.get(i));
                break;
            }
        }
    }

    /**
     * @param key - key.
     * @return coincidence words.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>(this.position);
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * @return unique key.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }


    /**
     * method findById.
     *
     * @param id - id.
     * @return found with id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * @return copy array items without null.
     */

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>(position);
        ((ArrayList<Item>) result).trimToSize();
        for (Item i : items) {
            result.add(i);
        }
        return result;
    }
}