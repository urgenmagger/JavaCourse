package ru.job4j.chessboard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {
    @Override
    public String toString() {
        return super.toString();
    }
// test moving left -> up for 3 cell;
    @Test
    public void bishopWayTestLeft() {
        Cell source = new Cell(5, 5);
        Cell dist = new Cell(3, 3);
        Figure figure = new Bishop(source);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell(5, 5);
        expected[1] = new Cell(4, 4);
        expected[2] = new Cell(3, 3);
        Cell[] result = figure.way(source, dist);
        assertThat(Arrays.toString(result), is(Arrays.toString(expected)));


    }
    // test moving right -> up for 3 cell;
    @Test
    public void bishopWayTestRight() {
        Cell source = new Cell(3, 7);
        Cell dist = new Cell(8, 2);
        Figure figure = new Bishop(source);
        Cell[] expected = new Cell[6];
        expected[0] = new Cell(3, 7);
        expected[1] = new Cell(4, 6);
        expected[2] = new Cell(5, 5);
        expected[3] = new Cell(6, 4);
        expected[4] = new Cell(7, 3);
        expected[5] = new Cell(8, 2);
        Cell[] result = figure.way(source, dist);
        assertThat(Arrays.toString(result), is(Arrays.toString(expected)));
    }
    // test moving left -> down for 3 cell;
    @Test
    public void bishopWayTestLeftDown() {
        Cell source = new Cell(3, 3);
        Cell dist = new Cell(1, 5);
        Figure figure = new Bishop(source);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell(3, 3);
        expected[1] = new Cell(2, 4);
        expected[2] = new Cell(1, 5);
        Cell[] result = figure.way(source, dist);
        assertThat(Arrays.toString(result), is(Arrays.toString(expected)));
    }
    // test moving right -> down for 3 cell;
    @Test
    public void bishopWayTestRightDown() {
        Cell source = new Cell(5, 5);
        Cell dist = new Cell(7, 7);
        Figure figure = new Bishop(source);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell(5, 5);
        expected[1] = new Cell(6, 6);
        expected[2] = new Cell(7, 7);
        Cell[] result = figure.way(source, dist);
        assertThat(Arrays.toString(result), is(Arrays.toString(expected)));
    }


}
