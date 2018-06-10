package ru.job4j.chessboard;

public class Board {
    Figure[] figures = new Figure[32];
    private int figuresCounter = 0;


    public void add(Figure figure) {
        this.figures[figuresCounter++] = figure;
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean result = false;
        for (Figure figure : figures) {
            if (!isOccupiedBy(source)) {
                throw new FigureNotFoundException("figure is missing");
            }
            Cell[] way = figure.way(source, dest);
            for (Cell cell : way) {
                if (cell != null && isOccupiedBy(cell)) {
                    throw new OccupiedWayException("path is occupied");
                }
            }
            result = true;
            figure.copy(dest);
            break;
        }
        return result;
    }


    public boolean isOccupiedBy(Cell cell) {
        boolean result = false;
        for (Figure figure : figures) {
            if (figure != null && figure.position.getX() == cell.getX() && figure.position.getY() == cell.getY()) {
                result = true;
                break;
            }
        }
        return result;
    }


    public Figure[] getFigures() {
        return figures;
    }
}
