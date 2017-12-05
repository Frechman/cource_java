package ru.frechman.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 *Класс описывающий треугольник.
 *
 */
public class TriangleTest {

    @Test
    public void areaTest(){
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 4);
        Point pointC = new Point(3, 0);
        
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        
        double actualResult = triangle.area();
        double expected = 6D;
        assertThat(actualResult, closeTo(expected, 0.1));
    }

    @Test
    public void distanceTest() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(10, 0);
        Point pointC = new Point(0, 15.6);
        
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        
        double disAB = triangle.distance(pointA, pointB);
        double disBC = triangle.distance(pointB, pointC);
        double disAC = triangle.distance(pointA, pointC);
        
        assertEquals(10D, disAB, 0.1);
        assertEquals(18.5D, disBC, 0.1);
        assertEquals(15.6D, disAC, 0.1);
    }

    @Test
    public void whenDistanceDiffPointThen5() {
        Point a = new Point(10, 4);
        Point b = new Point(3, 10);
        
        Triangle tr = new Triangle(null,null,null);
        
        double result = tr.distance(a,b);
        assertEquals(9.2D, result, 0.1);
    }

    @Test
    public void perimeterTest() {
        Point a = new Point(5,5);
        Point b = new Point(10,10);
        Point c = new Point(15,5);
        
        Triangle tr = new Triangle(a, b, c);
        double ab = tr.distance(a, b);
        double ac = tr.distance(a, c);
        double bc = tr.distance(b, c);
        double actualResult = tr.perimeter(ab, ac, bc);
        
        assertEquals(12.07, actualResult, 0.1);
    }

    /*@Test //существование треугольника
    public void testExistTriangle() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 10);

        Triangle triangle = new Triangle(a, b, c);

        double ab = triangle.distance(a, b);
        double ac = triangle.distance(a, c);
        double bc = triangle.distance(b, c);
        //не существует такого треугольника.
        assertEquals(false, triangle.exist(ab, ac, bc)); 
    }*/
}
