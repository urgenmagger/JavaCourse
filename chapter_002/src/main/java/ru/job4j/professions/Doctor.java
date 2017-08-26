package ru.job4j.professions;

/**
 * Created by urgen on 10.08.17.
 */
public class Doctor extends Profession {

    /**
     * Constructor.
     *
     * @param specification - specific.
     * @param qualification -  qualification.
     * @param group         - for group.
     */


    public Doctor(String specification, String qualification, String group) {
        super(specification, qualification, group);
    }

    /**
     * Creating an object in a method for the Teacher.
     *@param children - children.
     * @return objects interaction.
     */
    public String heal(Clients children) {
        Profession doctor = new Doctor("pediatrician", "advanced", "children");
        return ("Doctor " + doctor.getSpec() + " level " + doctor.getQual() + " heal " + children.getGroup());
    }
}
