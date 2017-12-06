package ru.frechman.loop;

public class Paint {

    /**
     * Рисунок пирамиды.
     *
     * @param width Ширина доски.
     * @param height Высота доски. 
     * @return Строку вида "шахматная доска".
     */
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < h; i++) {
            for (int j = 1; j <= ((h * 2) - 1); j++) {
                if (j >= h - i && j <= h + i) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}