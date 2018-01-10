package ru.frechman;

/**
 * Слон.
 */
public class Bishop extends Figure {

    protected Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        /*if (source < dest) {

        }*/
        return new Cell[0];
    }

    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
