package ru.frechman.start;

import org.junit.Test;
import ru.frechman.models.Item;

import static org.hamcrest.core.Is.is;
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
        tracker.add(new Item("test1", "desc1", 0L));

        String[] actionUser = {"3", tracker.findAll()[0].getId(), "EDIT", "EDIT", "7"};
        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(tracker.findAll()[0].getName(), is("EDIT"));
        assertThat(tracker.findAll()[0].getDescription(), is("EDIT"));
    }

    @Test
    public void testItemMenuDeleteStartUI() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("111", "description", 0L));
        Item item1 = tracker.add(new Item("111", "desc2", 2L));

        String[] actionUser = {"4", item.getId(), "7"};
        new StartUI(new StubInput(actionUser), tracker).init();

        assertThat(tracker.findAll()[0], is(item1));
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
