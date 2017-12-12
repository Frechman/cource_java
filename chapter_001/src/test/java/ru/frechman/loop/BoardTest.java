package ru.frechman.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Board.
 */
public class BoardTest {

    @Test
    public void testPaintWhen3x3() {
        Board board = new Board();
        String ln = System.lineSeparator();
        String rsl = board.paint(3, 3);
        assertThat(rsl, is(
                String.format(" X %sX X%s X %s", ln, ln, ln)
                )
        );
    }

    @Test
    public void testPaintWhen5x4() {
        Board board = new Board();
        //StackOverflow говорит, что %n кросплатформенный
        assertThat(board.paint(5, 4), is(
                String.format(" X X %nX X X%n X X %nX X X%n")
                )
        );
    }
}