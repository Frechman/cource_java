package ru.frechman.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.frechman.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

    /**
     * Tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * StringBuilder Menu.
     */
    private final StringBuilder sbMenu = new StringBuilder()
            .append("1. Add new Item.").append(System.lineSeparator())
            .append("2. Show all items.").append(System.lineSeparator())
            .append("3. Edit item.").append(System.lineSeparator())
            .append("4. Delete item.").append(System.lineSeparator())
            .append("5. Find item by Id.").append(System.lineSeparator())
            .append("6. Find items by name.").append(System.lineSeparator())
            .append("7. Exit Program.").append(System.lineSeparator())
            .append(System.lineSeparator());

    /**
     * Выходной поток "идёт" в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Выходной поток "идёт" в массив байт.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void testItemMenuADDStartUI() {
        String[] actionUser = {"1", "test1", "decs1", "7"};
        new StartUI(new StubInput(actionUser), this.tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test1"));
        assertThat(tracker.getAll().get(0).getDescription(), is("decs1"));
    }

    @Test
    public void testItemMenuEditItemsStartUI() {
        Item newItem = tracker.add(new Item("test1", "desc1", 0L));
        //Действия пользователя в меню.
        String[] actionUser = {"3", newItem.getId(), "EDIT1", "EDIT", "7"};

        new StartUI(new StubInput(actionUser), this.tracker).init();

        assertThat(tracker.findById(newItem.getId()).getName(), is("EDIT1"));
        assertThat(tracker.findById(newItem.getId()).getDescription(), is("EDIT"));
    }

    @Test
    public void testItemMenuDeleteStartUI() {
        //добавляем два элемента
        Item item1 = tracker.add(new Item("111", "description", 0L));
        Item item2 = tracker.add(new Item("111", "desc2", 2L));
        //удаляем 1-й Item
        String[] actionUser = {"4", item1.getId(), "5", item1.getId(), "7"};

        new StartUI(new StubInput(actionUser), this.tracker).init();

        //теперь должен остаться лишь Item2
        assertThat(tracker.findAll().get(0), is(item2));
        //проверка на NULL, значит объект не существует (удалён)
        assertNull(tracker.findById(item1.getId()));
    }


    @Test
    public void testItemMenuShowAllItemStartUI() {
        Item item = tracker.add(new Item("test", "test", 1L));

        //Действия пользователя.
        String[] actionUser = {"2", "7"};

        new StartUI(new StubInput(actionUser), this.tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sbMenu)
                                .append("-------------- LIST ALL ITEMS --------------")
                                .append(System.lineSeparator())
                                .append("    ### Найденные заявки: ###    ")
                                .append(System.lineSeparator())
                                .append("1.  Name: ").append(item.getName())
                                .append(System.lineSeparator())
                                .append("    Description: ").append(item.getDescription())
                                .append(System.lineSeparator())
                                .append("    Date of creation: ").append(item.getCreate())
                                .append(System.lineSeparator())
                                .append("    ID : ").append(item.getId())
                                .append(System.lineSeparator())
                                .append("------------ END list all Items ------------")
                                .append(System.lineSeparator())
                                .append(sbMenu)
                                .append("I'll be back!").append(System.lineSeparator())
                                .toString()
                ));
    }

    @Test
    public void testItemMenuFindById() {
        Item item = tracker.add(new Item("Bug", "Big Bug", 9L));

        //Действия пользователя.
        String[] actionUser = {"5", item.getId(), "7"};

        new StartUI(new StubInput(actionUser), this.tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sbMenu)
                                .append("---------------- FIND ITEM ----------------")
                                .append(System.lineSeparator())
                                .append("    ### Найденные заявки: ###    ")
                                .append(System.lineSeparator())
                                .append("1.  Name: ").append(item.getName())
                                .append(System.lineSeparator())
                                .append("    Description: ").append(item.getDescription())
                                .append(System.lineSeparator())
                                .append("    Date of creation: ").append(item.getCreate())
                                .append(System.lineSeparator())
                                .append("    ID : ").append(item.getId())
                                .append(System.lineSeparator())
                                .append("-------------- END find item --------------")
                                .append(System.lineSeparator())
                                .append(sbMenu)
                                .append("I'll be back!").append(System.lineSeparator())
                                .toString()
                ));
    }

    @Test
    public void testItemMenuFindByIdNotFoundItem() {
        Item item = tracker.add(new Item("Bug", "Big Bug", 9L));

        //Действия пользователя. //Неправильный ID
        String[] actionUser = {"5", item.getId() + 1, "7"};

        new StartUI(new StubInput(actionUser), this.tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sbMenu)
                                .append("---------------- FIND ITEM ----------------")
                                .append(System.lineSeparator())
                                .append("    ### Заявка не найдена. ###    ")
                                .append(System.lineSeparator())
                                .append("-------------- END find item --------------")
                                .append(System.lineSeparator())
                                .append(sbMenu)
                                .append("I'll be back!").append(System.lineSeparator())
                                .toString()
                ));
    }

    @Test
    public void testItemMenuFindByName() {
        Item newItem = tracker.add(new Item("nameBug", "descBigBUg", 999L));

        String[] actionUser = {"6", "nameBug", "7"};

        new StartUI(new StubInput(actionUser), this.tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(sbMenu)
                                .append("-------------- LIST FOUNDS ALL ITEMS --------------")
                                .append(System.lineSeparator())
                                .append("    ### Найденные заявки: ###    ")
                                .append(System.lineSeparator())
                                .append("1.  Name: ").append(newItem.getName())
                                .append(System.lineSeparator())
                                .append("    Description: ").append(newItem.getDescription())
                                .append(System.lineSeparator())
                                .append("    Date of creation: ").append(newItem.getCreate())
                                .append(System.lineSeparator())
                                .append("    ID : ").append(newItem.getId())
                                .append(System.lineSeparator())
                                .append("------------ END founds list all Items ------------")
                                .append(System.lineSeparator())
                                .append(sbMenu)
                                .append("I'll be back!").append(System.lineSeparator())
                                .toString()
                ));
    }
}
