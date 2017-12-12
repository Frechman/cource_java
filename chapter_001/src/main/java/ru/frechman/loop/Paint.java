package ru.frechman.loop;

public class Paint {
    /**
     * Drawing pyramid.
     *
     * @param h height pyramid.
     * @return draw pseudo pyramid.
     */
    public String pyramid(int h) {
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