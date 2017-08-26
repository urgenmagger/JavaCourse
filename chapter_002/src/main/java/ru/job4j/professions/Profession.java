package ru.job4j.professions;

/**
 * Parent class professions.
 *
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Profession {
    /**
     * specification - specification.
     */
    private String profession;
    /**
     * specification - specification.
     */
    private String specification;
    /**
     * qualification - qualification.
     */
    private String qualification;
    /**
     * group - group.
     */
    private String group;

    /**
     * default constructor.
     */
    public Profession() {

    }

    /**
     * users constructor.
     *
     * @param specification - specification.
     * @param qualification - qualification.
     * @param group         - group.
     */
    public Profession(String specification, String qualification, String group) {
        this.specification = specification;
        this.qualification = qualification;
        this.group = group;

    }

    /**
     * @return specification.
     */
    public String getSpec() {
        return this.specification;
    }

    /**
     * @return qualification.
     */
    public String getQual() {
        return this.qualification;
    }

    /**
     * @return group.
     */
    public String getGroup() {
        return this.group;
    }

}
