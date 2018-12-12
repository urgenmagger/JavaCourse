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
        List<Double> result = new ArrayList<>();
        result.add(1.0);
        result.add(2.0);
        result.add(3.0);
        result.add(4.0);
        List<Double> expected;
        expected = range.linear(1, 4);
        assertThat(result, is(expected));
    }

    @Test
    public void quadraticTest() {
        Range range = new Range();
        List<Double> result = new ArrayList<>();
        result.add(1.0);
        result.add(4.0);
        result.add(9.0);
        result.add(16.0);
        List<Double> expected;
        expected = range.quadratic(1, 4);
        assertThat(result, is(expected));
    }

    @Test
    public void logarithmTest() {
        Range range = new Range();
        List<Double> result = new ArrayList<>();
        result.add(Math.log(1.0));
        result.add(Math.log(2.0));
        result.add(Math.log(3.0));
        result.add(Math.log(4.0));
        List<Double> expected;
        expected = range.logarithm(1, 4);
        assertThat(result, is(expected));
    }

}
