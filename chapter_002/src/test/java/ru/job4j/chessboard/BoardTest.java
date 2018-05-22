package ru.job4j.chessboard;


import org.junit.Test;

public class BoardTest {
    @Test(expected = FigureNotFoundException.class)
    public void whenNotFigureInThisCell() {
        Board board = new Board();
        Board.figuresCounter = 0;
        Cell source = new Cell(2, 2);
        Cell dest = new Cell(2, 1);
        Cell sourceEmpty = new Cell(2, 1);
        Figure bishop = new Bishop(source);
        board.add(bishop);
        board.move(sourceEmpty, dest);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenAtAllFigure() {
        Board board = new Board();
        Cell source = new Cell(2, 2);
        Cell dest = new Cell(2, 1);
        board.move(source, dest);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedMiddleCell() {
        Board board = new Board();
        Board.figuresCounter = 0;
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(7, 7);
        Cell sourceOne = new Cell(5, 5);
        Figure bishop = new Bishop(source);
        Figure bishopOne = new Bishop(sourceOne);
        board.add(bishop);
        board.add(bishopOne);
        board.move(source, dest);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedDestCell() {
        Board board = new Board();
        Board.figuresCounter = 0;
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(7, 7);
        Cell sourceOne = new Cell(7, 7);
        Figure bishop = new Bishop(source);
        Figure bishopOne = new Bishop(sourceOne);
        board.add(bishop);
        board.add(bishopOne);
        board.move(source, dest);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImpossible() {
        Board board = new Board();
        Board.figuresCounter = 0;
        Cell source = new Cell(2, 2);
        Cell dest = new Cell(2, 1);
        Figure bishop = new Bishop(source);
        board.add(bishop);
        board.move(bishop.position, dest);
    }
}
