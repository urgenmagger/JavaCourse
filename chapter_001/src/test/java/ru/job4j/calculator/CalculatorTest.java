package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Calculator test.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     *Test.
     *@test Plus.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     *Test.
     *@test minus.
     */
    @Test
    public void whenAddOneMinusOneThenTwo() {
        Calculator cal = new Calculator();
        cal.substruct(1D, 1D);
        double result = cal.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }
    /**
     *Test.
     *@test div.
     */
    @Test
    public void whenAddOneDivOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     *Test.
     *@test multiple.
     */
    @Test
    public void whenAddOneMultipleOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
