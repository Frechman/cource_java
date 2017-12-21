package ru.frechman.start;

public class StartUI {

    /**
     * Константы для пунктов меню.
     */
    private static final String ADD_ITEM = "1";
    private static final String SHOW_ALL_ITEMS = "2";
    private static final String EDIT_ITEM = "3";
    private static final String DELETE_ITEM = "4";
    private static final String FIND_ITEM_BY_ID = "5";
    private static final String FIND_ITEMS_BY_NAME = "6";
    private static final String EXIT = "7";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запуск программы.
     *
     * @param args Args command line.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        while (true) {
            menu.showMenu();
            String userChoice = this.input.ask("Введите пункт меню : ");
            menu.select(Integer.valueOf(userChoice));
        }
/*
        boolean exit = false;
        while (!exit) {
            this.showSimpleMenu();
            String userChoice = this.input.ask("Введите пункт меню : ");
            switch (userChoice) {
                case ADD_ITEM:
                    this.createItem();
                    break;
                case SHOW_ALL_ITEMS:
                    this.showAllItems();
                    break;
                case EDIT_ITEM:
                    this.editItem();
                    break;
                case DELETE_ITEM:
                    this.deleteItem();
                    break;
                case FIND_ITEM_BY_ID:
                    this.findItemById();
                    break;
                case FIND_ITEMS_BY_NAME:
                    this.findItemsByName();
                    break;
                case EXIT:
                    exit = true;
                    System.out.println("I'll be back!");
                    break;
                default:
                    System.out.println("Error!. The item menu is not exist.");
                    break;
            }
        }*/
    }

    private void showMenu() {
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        System.out.println("|##     ## ######## ##    ## ##     ##  |");
        System.out.println("|###   ### ##       ###   ## ##     ##  |");
        System.out.println("|#### #### ##       ####  ## ##     ##  |");
        System.out.println("|## ### ## ######   ## ## ## ##     ##  |");
        System.out.println("|##     ## ##       ##  #### ##     ##  |");
        System.out.println("|##     ## ##       ##   ### ##     ##  |");
        System.out.println("|##     ## ######## ##    ##  #######   |");
        System.out.println("|                                       |");
        System.out.println("|        1. Add new Item.               |");
        System.out.println("|        2. Show all items.             |");
        System.out.println("|        3. Edit item.                  |");
        System.out.println("|        4. Delete item.                |");
        System.out.println("|        5. Find item by Id.            |");
        System.out.println("|        6. Find items by name.         |");
        System.out.println("|        7. Exit Program.               |");
        System.out.println("|_______________________________________|");
    }

    private void showSimpleMenu() {
        StringBuilder sb = new StringBuilder()
                .append("1. Add new Item.").append(System.lineSeparator())
                .append("2. Show all items.").append(System.lineSeparator())
                .append("3. Edit item.").append(System.lineSeparator())
                .append("4. Delete item.").append(System.lineSeparator())
                .append("5. Find item by Id.").append(System.lineSeparator())
                .append("6. Find items by name.").append(System.lineSeparator())
                .append("7. Exit Program.").append(System.lineSeparator());
        System.out.println(sb.toString());
    }
}
