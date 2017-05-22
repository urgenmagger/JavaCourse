package ru.job4j.calculator;
/**
 * Calculator elementary.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     *private.
     * @param result - result.
     */
    private double result;
    /**
     * add.
     * @param first - first.
     * @param second - second.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * substruct.
     * @param first - first.
     * @param second - second.
     */
    public void substruct(double first, double second) {
        this.result = first - second;
    }
    /**
     *div.
     * @param first - first.
     * @param second - second.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     *multiple.
     * @param first - first.
     * @param second - second.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     *getResult.
     *@return result.
     */
    public double getResult() {
        return this.result;
    }
}
