package ru.frechman.start;

import ru.frechman.models.Item;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private int position = 0;
    /**
     * Пункты меню.
     */
    private UserAction[] actions = new UserAction[10];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполняет наше меню пунктами.
     */
    public void fillActions() {
        this.actions[position++] = new AddItem(position, "Add new Item.");
        this.actions[position++] = new ShowAllItems(position, "Show all items.");
        this.actions[position++] = new EditItem(position, "Edit item.");
        this.actions[position++] = new DeleteItem(position, "Delete item.");
        this.actions[position++] = new FindItemById(position, "Find item by Id.");
        this.actions[position++] = new FindItemsByName(position, "Find items by name.");
        this.actions[position++] = new Exit(position, "Exit Program.");
    }

    /**
     * Add item menu.
     *
     * @param action new item menu.
     */
    public void actionAdd(UserAction action) {
        this.actions[position++] = action;
    }
    /**
     * Выбор меню пользователем.
     *
     * @param key номер меню.
     */
    public void select(int key) {
        this.actions[key - 1].execute(this.input, this.tracker);
    }

    /**
     * Вывод меню на экран.
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
    private static void printItem(Item... allItems) {
        System.out.println("    ### Найденные заявки: ###    ");
        for (int i = 0; i < allItems.length; i++) {
            System.out.println("" + (i + 1) + ". " + " Name: " + allItems[i].getName());
            System.out.println("    Description: " + allItems[i].getDescription());
            //Date date = new Date(allItems[i].getCreate());
            System.out.println("    Date of creation: " + allItems[i].getCreate()/*date*/);
            System.out.println("    ID : " + allItems[i].getId());
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(final int key, final String name) {
            super(key, name);
        }

        /**
         * Метод реализует добавления новый заявки в хранилище.
         */
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
            Item[] allItems = tracker.findAll();
            System.out.println("-------------- LIST ALL ITEMS --------------");
            printItem(allItems);
            System.out.println("------------ END list all Items ------------");
        }
    }


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

    private static class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------- FIND ITEM ----------------");
            String foundID = input.ask("Введите ID заявки, которую хотите найти : ");
            if (tracker.findById(foundID) != null) {
                printItem(tracker.findById(foundID));
            } else {
                System.out.println("    ### Заявка не найдена. ###    ");
            }
            System.out.println("-------------- END find item --------------");
        }
    }

    private static class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------- LIST FOUNDS ALL ITEMS --------------");
            String findsName = input.ask("Введите ИМЯ заявки, которую хотите найти : ");
            Item[] allItems = tracker.findByName(findsName);
            if (allItems.length != 0) {
                printItem(allItems);
            } else {
                System.out.println("    ### Заявки не найдены. ###    ");
            }
            System.out.println("------------ END founds list all Items ------------");

        }
    }
}

class Exit extends BaseAction {

    public Exit(final int key, final String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("I'll be back!");
    }

}