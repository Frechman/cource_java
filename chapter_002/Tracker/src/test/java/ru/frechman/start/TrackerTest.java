package ru.frechman.start;

import org.junit.Test;
import ru.frechman.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void testReplace() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test2", "testDecs", 31L);
        Item item2 = new Item("test3", "testDecs", 31L);
        Item item3 = new Item("test4", "testDecs", 31L);

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //get ID item 1
        String foundId = tracker.getAll()[0].getId();
        Item expectedNewItem = new Item("55", "55", 55L);

        tracker.replace(foundId, expectedNewItem);
        String foundNewId = tracker.getAll()[0].getId();
        Item actREs = tracker.findById(foundNewId);
        assertThat(actREs, is(expectedNewItem));
    }

    @Test
    public void testDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //get ID item2
        String foundId = tracker.getAll()[1].getId();
        //delete found Item by Id item2
        tracker.delete(foundId);
        //Set up expected Array
        Item[] expectedItems = new Item[2];
        expectedItems[0] = item1;
        expectedItems[1] = item3;

        assertThat(tracker.findAll(), is(expectedItems));
        assertArrayEquals(expectedItems, tracker.findAll());

    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] expectedItems = new Item[3];
        expectedItems[0] = item1;
        expectedItems[1] = item2;
        expectedItems[2] = item3;

        assertArrayEquals(expectedItems, tracker.findAll());
    }

    @Test
    public void getAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] expectedItems = new Item[100];
        expectedItems[0] = item1;
        expectedItems[1] = item2;
        expectedItems[2] = item3;
        assertThat(tracker.getAll(), is(expectedItems));
        assertArrayEquals(expectedItems, tracker.getAll());
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDecs1", 1L);
        Item item2 = new Item("test2", "testDecs2", 12L);
        Item item3 = new Item("test3", "testDecs3", 123L);
        Item item31 = new Item("test1", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item31);

        Item[] expectedItems = new Item[2];
        expectedItems[0] = item1;
        expectedItems[1] = item31;

        assertThat(tracker.findByName("test1"), is(expectedItems));
        assertArrayEquals(expectedItems, tracker.findByName("test1"));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test3", "testDecs1", 1L);
        Item item2 = new Item("test3", "testDecs2", 12L);
        Item item3 = new Item("test5", "testDecs3", 123L);
        Item item31 = new Item("test3", "testDecs3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item31);

        String id = tracker.getAll()[2].getId();//Id Item3

        Item actual = tracker.findById(id);

        assertThat(actual, is(item3));

    }
}