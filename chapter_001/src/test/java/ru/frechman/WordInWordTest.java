package ru.frechman;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordInWordTest {

    @Test
    public void containsTrue() {
        String origin = "Привет";
        String sub = "иве";
        WordInWord ww = new WordInWord();
        boolean actual = ww.contains(origin, sub);
        assertThat(actual, is(true));
    }

    @Test
    public void containsFalse() {
        String origin = "Hello, World";
        String sub = "Happy";
        WordInWord ww = new WordInWord();
        boolean actual = ww.contains(origin, sub);
        assertThat(actual, is(false));
    }
}