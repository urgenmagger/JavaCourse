package ru.job4j.tracker;

/**
 * Item class tracker.
 *
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Item {
    /**
     * id - id.
     */
    private String id;
    /**
     * description - description.
     */
    private String description;
    /**
     * name - name.
     */
    private String name;
    /**
     * created - created.
     */
    private Long created;

    /**
     * users constructor.
     *
     * @param description - description.
     * @param name        - qualification.
     * @param created     - group.
     */
    public Item(String name, String description, Long created) {
        this.name = name;
        this.created = created;
        this.description = description;
    }

    /**
     * @return description.
     */

    public String getDescription() {
        return description;
    }

    /**
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return getName.
     */
    public String getName() {
        return name;
    }

    /**
     * @return getCreated.
     */
    public Long getCreated() {
        return created;
    }
}