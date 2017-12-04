package ru.frechman.condition;

/**
 * Класс описывает точку в системе координат.
 */
public class Point {

    private int x;
    private int y;

    /**
     * Задаёт координаты точки.
     *
     * @param x координата по оси X (абсцисса).
     * @param y координата по оси Y (ордината).
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние между точками.
     *
     * @param that координаты второй точки.
     * @return расстояние между точками.
     */
    double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }
}
