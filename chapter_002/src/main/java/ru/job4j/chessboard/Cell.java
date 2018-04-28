package ru.job4j.chessboard;

public class Cell {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Cell{" + "x=" + x + ", y=" + y + '}';
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
