package ru.job4j.professions;

/**
 * Created by urgen on 10.08.17.
 */
public class Engineer extends Profession {
    /**
     * Constructor.
     *
     * @param specification - specific.
     * @param qualification -  qualification.
     * @param group         - for group.
     */


    public Engineer(String specification, String qualification, String group) {
        super(specification, qualification, group);
    }

    /**
     * Creating an object in a method for the Engineer.
     *@param boss - boss.
     * @return objects interaction.
     */

    public String creates(Clients boss) {
        Profession engineer = new Engineer("software", "senior", "boss");
        return ("Engineer " + engineer.getSpec() + " level " + engineer.getQual() + "creating projects for " + boss.getGroup());
    }

}

