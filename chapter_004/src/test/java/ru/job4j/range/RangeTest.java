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
        List<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);
        expected.add(4.0);
        List<Double> result;
        result = range.diapason(1, 4, x -> x);
        assertThat(expected, is(result));
    }

    @Test
    public void quadraticTest() {
        Range range = new Range();
        List<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(4.0);
        expected.add(9.0);
        expected.add(16.0);
        List<Double> result;
        result = range.diapason(1, 4, x -> x * x);
        assertThat(expected, is(result));
    }

    @Test
    public void logarithmTest() {
        Range range = new Range();
        List<Double> expected = new ArrayList<>();
        expected.add(Math.log(1.0));
        expected.add(Math.log(2.0));
        expected.add(Math.log(3.0));
        expected.add(Math.log(4.0));
        List<Double> result;
        result = range.diapason(1, 4, Math::log);
        assertThat(expected, is(result));
    }
}
