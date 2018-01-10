package ru.frechman;

public class Cell {

    private int x;

    private int y;

    private Cell(int x, int y) {
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
