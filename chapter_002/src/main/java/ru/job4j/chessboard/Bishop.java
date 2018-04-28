package ru.job4j.chessboard;


public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        int lengthWay = Math.abs(x1 - x2);
        Cell[] cells = new Cell[lengthWay + 1];
        int stepX = 1, stepY = 1;

        if (Math.abs(x1 - x2) != Math.abs(y1 - y2) || (x2 <= 0 || x2 > 8) || (y2 <= 0 || y2 > 8)) {
            new ImpossibleMoveException("impossible step");
        } else {
            for (int i = 0; i != lengthWay + 1; i++) {
                cells[i] = new Cell(x1, y1);
                if (x1 > x2 && y1 > y2) {
                    x1 -= stepX;
                    y1 -= stepY;
                }
                if (x1 > x2 && y1 < y2) {
                    x1 -= stepX;
                    y1 += stepY;
                }
                if (x1 < x2 && y1 > y2) {
                    x1 += stepX;
                    y1 -= stepY;
                }
                if (x1 < x2 && y1 < y2) {
                    x1 += stepX;
                    y1 += stepY;
                }
            }
        }

        return cells;
    }


    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
