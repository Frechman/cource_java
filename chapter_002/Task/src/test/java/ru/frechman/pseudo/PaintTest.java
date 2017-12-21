package ru.frechman.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    // Получаем ссылку на стандартный вывод в консоль.
    private final PrintStream stdout = System.out;
    // Создаем буфер для хранения вывода.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Заменяем стандартный вывод на вывод в пямять для тестирования.
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));
    }

    // Возвращаем обратно стандартный вывод в консоль.
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        // Выполняем действия пишущиее в консоль.
        new Paint().draw(new Square());
        // Проверяем результат вычисления
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("++++")
                .append("+  +")
                .append("+  +")
                .append("++++")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenDrawTriangle() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("   ^   ")
                .append("  ^^^  ")
                .append(" ^^^^^ ")
                .append("^^^^^^^")
                .append(System.lineSeparator())
                .toString()));
    }
}