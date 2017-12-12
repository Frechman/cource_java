package ru.frechman.condition;


/**
 * Класс описывающий треугольник.
 *
 * @author Frechman.
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод должен вычислять расстояние между точками left и right.
     * √(xb - xa)^2 + (yb - ya)^2
     *
     * @param left  Точка слева
     * @param right Точка справа.
     * @return расстояние между точками left и right.
     */
    public double distance(Point left, Point right) {
        return left.distanceTo(right);
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b.
     * @param ac расстояние между точками a c.
     * @param bc расстояние между точками b c.
     * @return Периметр треугольника.
     */
    public double perimeter(double ab, double ac, double bc) {
        return ((ab + ac + bc) / 2);
    }

    /**
     * Метод должен вычислить прощадь треугольканива.
     * √ p *(p - ab) * (p - ac) * (p - bc)
     *
     * @return площадь, если треугольник существует или -1, если не существует.
     */
    public double area() {
        double result = -1.0;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.perimeter(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }

    /**
     * Метод проверяет можно ли построить треугольник с данными длинами сторон.
     *
     * @param ab длина между точками a b.
     * @param ac длина между точками a c.
     * @param bc длина между точками b c.
     * @return true or false exist the Triangle.
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab + ac > bc) && (ab + bc > ac) && (ac + bc > ab);
    }
}