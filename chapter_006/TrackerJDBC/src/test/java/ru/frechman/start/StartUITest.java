package ru.frechman.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.frechman.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private Tracker tracker;
    private ClassLoader cl = TrackerTest.class.getClassLoader();
    private URL resource = cl.getResource("appH2DB.properties");
    private File config = new File(resource.getPath());
    /**
     * StringBuilder Menu.
     */
    private final StringBuilder sbMenu = new StringBuilder()
            .append("1. Add new item.").append(System.lineSeparator())
            .append("2. Show all items.").append(System.lineSeparator())
            .append("3. Edit item.").append(System.lineSeparator())
            .append("4. Delete item.").append(System.lineSeparator())
            .append("5. Find item by id.").append(System.lineSeparator())
            .append("6. Find items by name.").append(System.lineSeparator())
            .append("7. Exit program.").append(System.lineSeparator())
            .append(System.lineSeparator());

    /**
     * Output stream "goes" to the console.
     */
    private final PrintStream stdout = System.out;
    /**
     * Output stream "goes" to the byte's array.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
        this.tracker = new Tracker(config);
    }

    @After
    public void backOutput() throws SQLException {
        System.setOut(this.stdout);
        tracker.dropTable();
    }

    @Test
    public void testItemMenuAddStartUI() {
        //User actions in the menu: add item and exit.
        String[] actionUser = {"1", "test1", "decs1", "7"};
        new StartUI(new StubInput(actionUser), tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test1"));
        assertThat(tracker.findAll().get(0).getDescription(), is("decs1"));
    }

    @Test
    public void testItemMenuEditItemStartUI() {
        Item newItem = tracker.add(new Item("test1", "desc1", 0L));
        //User actions in the menu: edit item and exit.
        String[] actionUser = {"3", newItem.getId(), "EDIT1", "EDIT", "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(tracker.findById(newItem.getId()).getName(), is("EDIT1"));
        assertThat(tracker.findById(newItem.getId()).getDescription(), is("EDIT"));
    }

    @Test
    public void testItemMenuDeleteStartUI() {
        //Add two items
        Item item1 = tracker.add(new Item("111", "description", 0L));
        Item item2 = tracker.add(new Item("111", "desc2", 2L));
        //Delete first Item
        String[] actionUser = {"4", item1.getId(), "5", item1.getId(), "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        //Should remain only Item2
        assertThat(tracker.findAll().get(0).getId(), is(item2.getId()));
        //Check for NULL, then the object does not exist (deleted)
        assertNull(tracker.findById(item1.getId()));
    }

    @Test
    public void testItemMenuShowAllItemStartUI() {
        Item item = tracker.add(new Item("test", "test", 1L));
        //User actions in the menu: show all items and exit.
        String[] actionUser = {"2", "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        String.valueOf(sbMenu) +
                                "-------------- LIST ALL ITEMS --------------" +
                                System.lineSeparator() +
                                "    ### Найденные заявки: ###    " +
                                System.lineSeparator() +
                                "1.  Name: " + item.getName() +
                                System.lineSeparator() +
                                "    Description: " + item.getDescription() +
                                System.lineSeparator() +
                                "    Date of creation: " + item.getCreateDate() +
                                System.lineSeparator() +
                                "    ID : " + item.getId() +
                                System.lineSeparator() +
                                "------------ END list all Items ------------" +
                                System.lineSeparator() +
                                sbMenu +
                                "I'll be back!" + System.lineSeparator()
                ));
    }

    @Test
    public void testItemMenuFindById() {
        Item item = tracker.add(new Item("Bug", "Big Bug", 9L));
        //User actions in the menu: find by id and exit.
        String[] actionUser = {"5", item.getId(), "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        String.valueOf(sbMenu) +
                                "---------------- FIND ITEM ----------------" +
                                System.lineSeparator() +
                                "    ### Найденные заявки: ###    " +
                                System.lineSeparator() +
                                "1.  Name: " + item.getName() +
                                System.lineSeparator() +
                                "    Description: " + item.getDescription() +
                                System.lineSeparator() +
                                "    Date of creation: " + item.getCreateDate() +
                                System.lineSeparator() +
                                "    ID : " + item.getId() +
                                System.lineSeparator() +
                                "-------------- END find item --------------" +
                                System.lineSeparator() +
                                sbMenu +
                                "I'll be back!" + System.lineSeparator()
                ));
    }

    @Test
    public void testItemMenuFindByIdNotFoundItem() {
        Item item = tracker.add(new Item("Bug", "Big Bug", 9L));
        //User actions in the menu: find by the wrong id and exit.
        String[] actionUser = {"5", item.getId() + 1, "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        String.valueOf(sbMenu) +
                                "---------------- FIND ITEM ----------------" +
                                System.lineSeparator() +
                                "    ### Заявка не найдена. ###    " +
                                System.lineSeparator() +
                                "-------------- END find item --------------" +
                                System.lineSeparator() +
                                sbMenu +
                                "I'll be back!" + System.lineSeparator()
                ));
    }

    @Test
    public void testItemMenuFindByName() {
        Item newItem = tracker.add(new Item("nameBug", "descBigBUg", 999L));
        //User actions in the menu: find by name and exit.
        String[] actionUser = {"6", "nameBug", "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(new String(this.out.toByteArray()),
                is(
                        String.valueOf(sbMenu) +
                                "-------------- LIST FOUNDS ALL ITEMS --------------" +
                                System.lineSeparator() +
                                "    ### Найденные заявки: ###    " +
                                System.lineSeparator() +
                                "1.  Name: " + newItem.getName() +
                                System.lineSeparator() +
                                "    Description: " + newItem.getDescription() +
                                System.lineSeparator() +
                                "    Date of creation: " + newItem.getCreateDate() +
                                System.lineSeparator() +
                                "    ID : " + newItem.getId() +
                                System.lineSeparator() +
                                "------------ END founds list all Items ------------" +
                                System.lineSeparator() +
                                sbMenu +
                                "I'll be back!" + System.lineSeparator()
                ));
    }
}
