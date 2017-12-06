package ru.frechman.loop;

/**
 * Псевдо-шахматная доска.
 *
 */
public class Board {

    /**
     * Рисунок псевдо-шахматной доски.
     *
     * @param width Ширина доски.
     * @param height Высота доски. 
     * @return Строку вида "шахматная доска".
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 != 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}