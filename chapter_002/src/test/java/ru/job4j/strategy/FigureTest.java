package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FigureTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String lineSeparator = System.getProperty("line.separator");
        StringBuilder result = new StringBuilder();
        assertThat(square.draw(), is(result
                .append("++++")
                .append(lineSeparator)
                .append("+  +")
                .append(lineSeparator)
                .append("+  +")
                .append(lineSeparator)
                .append("++++")
                .toString()
        ));
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String lineSeparator = System.getProperty("line.separator");
        StringBuilder result = new StringBuilder();
        assertThat(triangle.draw(), is(result
                .append("  +  ")
                .append(lineSeparator)
                .append(" +++ ")
                .append(lineSeparator)
                .append("+++++")
                .toString()
        ));
    }
}
