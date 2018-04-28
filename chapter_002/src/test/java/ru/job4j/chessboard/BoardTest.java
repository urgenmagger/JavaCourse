package ru.job4j.chessboard;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chessboard.FigureNotFoundException;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenBishopMove() throws OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        Board board = new Board();
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(0, 4);
        Figure bishop = new Bishop(source);
        board.add(bishop);
        boolean result = board.move(source, dest);
        assertThat(true, is(result));

    }
}
