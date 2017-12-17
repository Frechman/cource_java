package ru.frechman.start;

import org.junit.Test;
import ru.frechman.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void testItemMenuADDStartUI() {
        Tracker tracker = new Tracker();
        String[] actionUser = {"1", "test1", "decs1", "7"};

        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(tracker.getAll()[0].getName(), is("test1"));
        assertThat(tracker.getAll()[0].getDescription(), is("decs1"));
    }

    @Test
    public void testItemMenuEditItemsStartUI() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("test1", "desc1", 0L);
        tracker.add(newItem);

        String[] actionUser = {"3", newItem.getId(), "EDIT1", "EDIT", "7"};
        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(tracker.findById(newItem.getId()).getName(), is("EDIT1"));
        assertThat(tracker.findById(newItem.getId()).getDescription(), is("EDIT"));
    }

    @Test
    public void testItemMenuDeleteStartUI() {
        Tracker tracker = new Tracker();
        //добавляем два элемента
        Item item1 = tracker.add(new Item("111", "description", 0L));
        Item item2 = tracker.add(new Item("111", "desc2", 2L));
        //удаляем 1-й Item
        String[] actionUser = {"4", item1.getId(), "5", item1.getId(), "7"};
        new StartUI(new StubInput(actionUser), tracker).init();
        //теперь должен остаться лишь Item2
        assertThat(tracker.findAll()[0], is(item2));
        //проверка на NULL, значит объект не существует (удалён)
        assertNull(tracker.findById(item1.getId()));
    }

    /*
    А смысл этот пункт меню и другие пункты,
    которые не производят над объектами ни каких действий,
    тестировать таким образом??
    Таким образом, мы не как не протестируем пункты ShowAllItems, FindById, FindByName
    потому у них основная работа это просто вывод на экран.
    А тестировать имеенно вывод на консоль будет в следующей задаче.
    А сами методы для работы этих пунктов уже протестированы в TrackerTest.
    */
    @Test
    public void testItemMenuShowAllItemStartUI() {
        Tracker tracker = new Tracker();
        String[] actionUser = {"1", "test1", "decs1", "1", "test2", "decs2", "2", "7"};
        //Тут даже не протестируешь ShowAllItems, потому что он просто показывает на экран
        //А работа метода с помощью которого
        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(tracker.findAll()[0].getName(), is("test1"));
        assertThat(tracker.findAll()[0].getDescription(), is("decs1"));
        assertThat(tracker.findAll()[1].getName(), is("test2"));
        assertThat(tracker.findAll()[1].getDescription(), is("decs2"));
    }
}
