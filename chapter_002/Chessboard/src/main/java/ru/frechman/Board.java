package ru.frechman;

public class Board {
    /**
     * Клетки шахматной доски.содержит фигуры.
     */
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    /**
     * @param source
     * @param dest
     * @return
     *  Проверить Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     *  - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)
     * @throws ImpossibleMoveException Проверить может ли она так двигаться. Если нет то упадет исключение
     * @throws OccupiedWayException    Проверить что полученный путь не занят фигурами. Если занят выкинуть исключение
     * @throws FigureNotFoundException Что в заданной ячейки есть фигура, если нет, то выкинуть исключение
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        //Figure copy(dest);
        return true;
    }
}
