package ru.job4j.range;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RangeTest {
    @Test
    public void linearTest() {
        Range range = new Range();
        List<Double> actual = new ArrayList<>();
        actual.add(5.0);
        actual.add(7.0);
        actual.add(9.0);
        actual.add(11.0);
        List<Double> expected;
        expected = range.linear(1, 4, 2, 3);
        assertThat(actual, is(expected));
    }
    @Test
    public void quadraticTest() {
        Range range = new Range();
        List<Double> actual = new ArrayList<>();
        actual.add(7.0);
        actual.add(15.0);
        actual.add(27.0);
        actual.add(43.0);
        List<Double> expected;
        expected = range.quadratic(1, 4, 2, 2, 3);
        assertThat(actual, is(expected));
    }
    @Test
    public void logarithmTest() {
        Range range = new Range();
        List<Double> actual = new ArrayList<>();
        actual.add(Math.log(1.0));
        actual.add(Math.log(2.0));
        actual.add(Math.log(3.0));
        actual.add(Math.log(4.0));
        List<Double> expected;
        expected = range.logarithm(1, 4);
        assertThat(actual, is(expected));
    }

}
