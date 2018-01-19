package ru.frechman;

abstract class Figure {

    /**
     * ячейка на шахматной доске.
     */
    final Cell position;

    Figure(Cell position) {
        this.position = position;
    }

    /**
     * @param source исходные координаты
     * @param dest   задают ячейку куда следует пойти
     * @return Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура
     * @throws ImpossibleMoveException Если фигура туда пойти не может.
     */
    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);
}