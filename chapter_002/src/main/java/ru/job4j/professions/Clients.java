package ru.job4j.professions;

/**
 * Common class for clients.
 */
public class Clients extends Profession {
    /**
     * Constructor.
     *
     * @param specification - specific.
     * @param qualification -  qualification.
     * @param group         - for group.
     */
    public Clients(String specification, String qualification, String group) {
        super(specification, qualification, group);
        Profession children = new Clients("foreign language", "advanced", "children");
        Profession boss = new Clients("foreign language", "advanced", "boss");
        Profession students = new Clients("foreign language", "advanced", "students");

    }
}
