package ru.frechman.start;

import org.junit.Test;
import ru.frechman.models.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenEditNameThenReturnNewName() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item item1 = new Item("test2", "testDecs", 31L);
        Item item2 = new Item("test3", "testDecs", 31L);
        Item item3 = new Item("test4", "testDecs", 31L);

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //get ID item 1
        String foundId = tracker.getAll().get(0).getId();
        Item expectedNewItem = new Item("55", "55", 55L);

        tracker.edit(foundId, expectedNewItem);
        String foundNewId = tracker.getAll().get(0).getId();
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
        String foundId = tracker.getAll().get(1).getId();
        //delete found Item by Id item2
        tracker.delete(foundId);
        //Set up expected Array
        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item3);

        assertThat(tracker.findAll(), is(expectedItems));
        assertEquals(expectedItems, tracker.findAll());

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

        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);

        assertEquals(expectedItems, tracker.findAll());
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

        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);
        assertThat(tracker.getAll(), is(expectedItems));
        assertEquals(expectedItems, tracker.getAll());
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

        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(item1);
        expectedItems.add(item31);

        assertThat(tracker.findByName("test1"), is(expectedItems));
        assertEquals(expectedItems, tracker.findByName("test1"));
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

        String id = tracker.getAll().get(2).getId();//Id Item3

        Item actual = tracker.findById(id);

        assertThat(actual, is(item3));

    }
}