package ru.job4j.chessboard;

public class Board {
    Figure[] figures = new Figure[32];
    static int figuresCounter = 0;


    public void add(Figure figure) {
        this.figures[figuresCounter++] = figure;
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean result = false;
        for (Figure figure : figures) {
            if (isOccupiedBy(source)) {
                Cell[] way = figure.way(source, dest);
                try {
                    figure.way(source, dest);
                } catch (ImpossibleMoveException e) {
                    throw new ImpossibleMoveException(" так ходить нельзя");
                }
                for (Cell cell : way) {
                    if (cell != null && !isOccupiedBy(cell)) {
                        throw new OccupiedWayException("занято");
                    }
                }
            } else {
                throw new FigureNotFoundException("клетка пустая");
            }
            figure.copy(dest);
            return true;
        }
        return result;

    }

    public boolean isOccupiedBy(Cell cell) {
        boolean result = false;
        for (Figure figure : figures) {
            if (figure != null && figure.position.equals(cell)) {
                return true;
            }
        }
        return result;
    }

    public Figure[] getFigures() {
        return figures;
    }
}
