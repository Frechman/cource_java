package ru.frechman.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.frechman.models.Item;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    private Tracker tracker;
    private ClassLoader cl = TrackerTest.class.getClassLoader();
    private URL resource = cl.getResource("appH2DB.properties");
    private File config = new File(resource.getPath());

    @Before
    public void createTracker() {
        this.tracker = new Tracker(config);
    }

    @After
    public void dropTableTracker() throws SQLException {
        tracker.dropTable();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    @Test
    public void whenEditNameThenReturnNewName() {
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.edit(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void testEdit() {
        Item item1 = new Item("test2", "testDecs", 31L);
        Item item2 = new Item("test3", "testDecs", 31L);
        Item item3 = new Item("test4", "testDecs", 31L);

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //get ID item 1
        String foundId = tracker.findAll().get(0).getId();
        //Edit item.
        Item expectedNewItem = new Item("55", "55", 55L);
        tracker.edit(foundId, expectedNewItem);

        Item actual = tracker.findById(foundId);
        assertThat(actual.getName(), is(expectedNewItem.getName()));
        assertThat(actual.getDescription(), is(expectedNewItem.getDescription()));
        assertThat(actual.getCreateDate(), is(expectedNewItem.getCreateDate()));
    }

    @Test
    public void testDelete() {
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //Get ID item2
        String foundId = tracker.findAll().get(1).getId();
        //Delete found item
        tracker.delete(foundId);

        assertNull(tracker.findById(foundId));
    }

    @Test
    public void testFindAll() {
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);

        String i1 = tracker.add(item1).getId();
        String i2 = tracker.add(item2).getId();
        String i3 = tracker.add(item3).getId();

        assertEquals(item1.getName(), tracker.findById(i1).getName());
        assertEquals(item2.getName(), tracker.findById(i2).getName());
        assertEquals(item3.getName(), tracker.findById(i3).getName());
    }

    @Test
    public void testFindByName() {
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);
        Item item31 = new Item("test1", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item31);

        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item31);

        assertThat(tracker.findByName("test1"), is(expectedItems));
        assertEquals(expectedItems, tracker.findByName("test1"));
    }

    @Test
    public void testFindById() {
        Item item1 = new Item("test3", "testDecs1", 1L);
        Item item2 = new Item("test3", "testDecs2", 12L);
        Item item3 = new Item("test5", "testDecs3", 123L);
        Item item31 = new Item("test3", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item31);

        String id = tracker.findAll().get(2).getId();//Id Item3

        Item actual = tracker.findById(id);

        assertThat(actual, is(item3));
    }
}