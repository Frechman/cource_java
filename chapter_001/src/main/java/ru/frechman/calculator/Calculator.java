package ru.frechman.calculator;

/**
 * Класс реализует работу калькулятора.
 */
public class Calculator {

    /**
     * Значение результата.
     */
    private double result;

    /**
     * Метод, реализующий суммирование 2х чисел.
     *
     * @param first  первое число (слагаемое).
     * @param second второе число (слагаемое).
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод, реализующий разность 2х чисел.
     *
     * @param first  первое число (уменьшаемое).
     * @param second второе число (вычитаемое).
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод, реализующий частное (деление) 2х чисел.
     *
     * @param first  первое число (делимое).
     * @param second второе число (делитель).
     */
    public void div(double first, double second) {
        if (second == 0) {
            System.out.println("Error! Divide By Zero. Делить на нуль нельзя!");
        }
        try {
            this.result = first / second;
        } catch (ArithmeticException divideByZero) {
            System.out.println("Error! Неверная арифметическая операция.");
        }
    }

    /**
     * Метод, реализующий произведение 2х чисел.
     *
     * @param first  первое число (множитель).
     * @param second второе число (множитель).
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод возвращает результат вычисления.
     *
     * @return возвращает значение переменной result.
     */
    public double getResult() {
        return result;
    }

}
