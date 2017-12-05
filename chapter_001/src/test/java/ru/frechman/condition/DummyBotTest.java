package ru.frechman.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Тесты глупого бота.
 */
public class DummyBotTest {

    @Test
    public void whenGreetBot() {
        DummyBot dmBot = new DummyBot();
        String expect = "Привет, умник.";
        String actualResult = dmBot.answer("Привет, Бот!");
        assertThat(actualResult, is(expect));
    }

    @Test
    public void whenByeBot() {
        DummyBot dmBot = new DummyBot();
        String expect = "До скорой встречи.";
        String actualResult = dmBot.answer("Пока.");
        assertThat(actualResult, is(expect));
    }

    @Test
    public void whenUnknowBot() {
        DummyBot dmBot = new DummyBot();
        String expect = "Это ставит меня в тупик. Спросите другой вопрос.";
        String actualResult = dmBot.answer("Как дела?");
        assertThat(actualResult, is(expect));
    }
}