package ru.frechman.start;

import ru.frechman.models.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuTracker {

    private Input input;
    private Tracker tracker;

    /**
     * Menu items. Actions.
     */
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Fill menu with items.
     */
    public void fillActions() {
        actions.add(new AddItem(1, "Add new item."));
        actions.add(new ShowAllItems(2, "Show all items."));
        actions.add(new EditItem(3, "Edit item."));
        actions.add(new DeleteItem(4, "Delete item."));
        actions.add(new FindItemById(5, "Find item by id."));
        actions.add(new FindItemsByName(6, "Find items by name."));
        actions.add(new Exit(7, "Exit program."));
    }

    /**
     * Add menu item.
     *
     * @param action new menu item.
     */
    public void actionAdd(UserAction action) {
        this.actions.add(action);
    }

    /**
     * User select menu item.
     *
     * @param key the menu item.
     */
    public void select(int key) {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * Output menu on display.
     */
    public void showMenu() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println();
    }

    /**
     * Method print all items in array.
     *
     * @param allItems array to print.
     */
    private static void printItem(List<Item> allItems) {
        System.out.println("    ### Найденные заявки: ###    ");
        int i = 1;
        for (Item item : allItems) {
            System.out.println("" + i + ". " + " Name: " + item.getName());
            System.out.println("    Description: " + item.getDescription());
            //Date date = new Date(allItems[i].getCreateDate());
            System.out.println("    Date of creation: " + item.getCreateDate()/*date*/);
            System.out.println("    ID : " + item.getId());
            i++;
        }
    }

    /**
     * The class implements adding a new item to the tracker.
     */
    private class AddItem extends BaseAction {

        public AddItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------- Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = tracker.add(new Item(name, desc, System.currentTimeMillis()));
            System.out.println("--- Создана новая заявка с getId : " + item.getId() + " ---");
        }
    }

    /**
     * Item menu - Show All Items.
     */
    private static class ShowAllItems extends BaseAction {

        public ShowAllItems(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> allItems = tracker.findAll();
            System.out.println("-------------- LIST ALL ITEMS --------------");
            printItem(allItems);
            System.out.println("------------ END list all Items ------------");
        }
    }

    /**
     * The class implements editing the item from the tracker.
     */
    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------- EDIT ITEM ----------------");
            String foundID = input.ask("Введите ID заявки, которую хотите изменить : ");
            if (tracker.findById(foundID) != null) {
                String newName = input.ask("Введите НОВОЕ имя заявки : ");
                String newDesc = input.ask("Введите НОВОЕ описание заявки : ");
                tracker.edit(foundID, new Item(newName, newDesc, System.currentTimeMillis()));
                System.out.println("### Заявка изменена. ###");
            } else {
                System.out.println("    ### Заявка не найдена. ###    ");
            }
            System.out.println("-------------- END edit item --------------");
        }
    }

    /**
     * The class implements deleting the item from the tracker.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------- DELETE ITEM ----------------");
            String foundID = input.ask("Введите ID заявки, которую хотите удалить : ");
            if (tracker.findById(foundID) != null) {
                tracker.delete(foundID);
                System.out.println("### Заявка удалена. ###");
            } else {
                System.out.println("    ### Заявка не найдена. ###    ");
            }
            System.out.println("-------------- END delete item --------------");
        }
    }

    /**
     * The class implements finding the item by id from the tracker.
     * <p>
     * P.s. Static class - just learning type classes.
     */
    private static class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------- FIND ITEM ----------------");
            String foundID = input.ask("Введите ID заявки, которую хотите найти : ");
            if (tracker.findById(foundID) != null) {
                printItem(Collections.singletonList(tracker.findById(foundID)));
            } else {
                System.out.println("    ### Заявка не найдена. ###    ");
            }
            System.out.println("-------------- END find item --------------");
        }
    }

    /**
     * The class implements finding the item by name from the tracker.
     * <p>
     * P.s. Static class - just learning type classes.
     */
    private static class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------- LIST FOUNDS ALL ITEMS --------------");
            String findsName = input.ask("Введите ИМЯ заявки, которую хотите найти : ");
            List<Item> allItems = tracker.findByName(findsName);
            if (!allItems.isEmpty()) {
                printItem(allItems);
            } else {
                System.out.println("    ### Заявки не найдены. ###    ");
            }
            System.out.println("------------ END founds list all Items ------------");
        }
    }
}

/**
 * The class implements exit from menu.
 * <p>
 * P.s. Outer class - just learning type classes.
 */
class Exit extends BaseAction {

    public Exit(final int key, final String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("I'll be back!");
    }

}