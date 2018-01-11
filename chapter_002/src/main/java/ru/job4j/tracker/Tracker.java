package ru.job4j.tracker;

import java.util.Arrays;
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
    private Item[] items = new Item[100];
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
        this.items[position++] = items;
        return items;
    }

    /**
     * method replace items.
     *
     * @param item - items.
     * @param id   - id.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (item != null && item.getId().equals(id)) {
                items[i] = item;
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
        for (int i = 0; i <= this.position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                this.items[i] = null;
                System.arraycopy(this.items, i + 1, this.items, i, this.position - 1);
                this.position--;

            }
        }
    }

    /**
     * @param key - key.
     * @return coincidence words.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int counter = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[counter++] = items[i];
            }
        }
        return Arrays.copyOf(result, counter);
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

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
}