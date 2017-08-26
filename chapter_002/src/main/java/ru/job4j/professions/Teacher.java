package ru.job4j.professions;

/**
 * class Teacher.
 *
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    /**
     * Constructor.
     *
     * @param specification - specific.
     * @param qualification -  qualification.
     * @param group         - for group.
     */

    public Teacher(String specification, String qualification, String group) {
        super(specification, qualification, group);
    }

    /**
     * Creating an object in a method for the Teacher.
     *@param students - students
     * @return objects interaction.
     */
    public String teaches(Clients students) {
        Profession teacher = new Teacher("foreign language", "advanced", "students");
        return ("Teacher " + teacher.getSpec() + " level " + teacher.getQual() + " teaches " + students.getGroup());
    }

}
