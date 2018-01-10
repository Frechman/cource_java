package ru.frechman;

public class Board {
    /**
     * Клетки шахматной доски.содержит фигуры.
     */
    Figure[][] figures = new Figure[8][8];

    /**
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException Проверить может ли она так двигаться. Если нет то упадет исключение
     * @throws OccupiedWayException    Проверить что полученный путь не занят фигурами. Если занят выкинуть исключение
     * @throws FigureNotFoundException Что в заданной ячейки есть фигура, если нет, то выкинуть исключение
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        //Figure copy(dest);
        return true;
    }
}
