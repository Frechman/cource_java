package ru.frechman.pseudo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void testDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                .append("   ^   ").append(System.lineSeparator())
                .append("  ^^^  ").append(System.lineSeparator())
                .append(" ^^^^^ ").append(System.lineSeparator())
                .append("^^^^^^^").append(System.lineSeparator())
                .toString()));
    }
}