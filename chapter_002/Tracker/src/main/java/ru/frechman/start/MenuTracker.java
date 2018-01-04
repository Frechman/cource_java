package ru.frechman.start;

import ru.frechman.models.Item;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    /**
     * Пункты меню.
     */
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполняет наше меню пунктами.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemsByName();
        this.actions[6] = new Exit();
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

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 1;
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

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Add new Item.");
        }
    }

    /**
     * Item menu - Show All Items.
     */
    private static class ShowAllItems implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] allItems = tracker.findAll();
            System.out.println("-------------- LIST ALL ITEMS --------------");
            printItem(allItems);
            System.out.println("------------ END list all Items ------------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Show all items.");
        }
    }


    private class EditItem implements UserAction {

        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Edit item.");
        }
    }

    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Delete item.");
        }
    }

    private static class FindItemById implements UserAction {
        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Find item by Id.");
        }
    }

    private static class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 6;
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

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Find items by name.");
        }
    }
}

class Exit implements UserAction {

    @Override
    public int key() {
        return 7;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("I'll be back!");
    }

    @Override
    public String info() {
        return String.format("%s. %s", key(), "Exit Program.");
    }
}