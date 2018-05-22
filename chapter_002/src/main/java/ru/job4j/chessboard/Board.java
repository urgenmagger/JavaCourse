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
                for (Cell cell : way) {
                    if (cell != null && isOccupiedBy(cell)) {
                        throw new OccupiedWayException("path is occupied");
                    }
                }
                result = true;
                figure.copy(dest);
                break;
            } else {
                throw new FigureNotFoundException("do not figure");
            }
        }
        return result;
    }


    public boolean isOccupiedBy(Cell cell) {
        boolean result = false;
        for (Figure figure : figures) {
            if (figure != null && figure.position.getX() == cell.getX() && figure.position.getY() == cell.getY()) {
                return true;
            }
        }
        return result;
    }

    public Figure[] getFigures() {
        return figures;
    }
}
