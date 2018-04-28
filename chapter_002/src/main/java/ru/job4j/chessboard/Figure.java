package ru.job4j.chessboard;

public abstract class Figure {

    /**
     * current position cell.
     */
    final Cell position;

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);


    public Figure(Cell position) {
        this.position = position;
    }
}
