package ru.frechman.start;

import ru.frechman.models.Item;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    /**
     * Пункты меню.
     */
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполняет наше меню пунктами.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItem();
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
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 1;
        }

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

    private static class ShowAllItem implements UserAction {

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

        private void printItem(Item... allItems) {
            System.out.println("    ### Найденные заявки: ###    ");
            for (int i = 0; i < allItems.length; i++) {
                System.out.println("" + (i + 1) + ". " + " Name: " + allItems[i].getName());
                System.out.println("    Description: " + allItems[i].getDescription());
                //Date date = new Date(allItems[i].getCreate());
                System.out.println("    Date of creation: " + allItems[i].getCreate()/*date*/);
                System.out.println("    ID : " + allItems[i].getId());
            }
        }
    }
}
