package ru.frechman.start;

import ru.frechman.models.Item;

import java.util.Date;

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "1";

    /**
     * Константа для выхода из цикла.
     */
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
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String userChoice = this.input.ask("Введите пункт меню : ");
            switch (userChoice) {
                case "1":
                    this.createItem();
                    break;
                case "2":
                    this.showAllItems();
                    break;
                case "3":
                    this.editItem();
                    break;
                case "4":
                    this.deleteItem();
                    break;
                case "5":
                    this.findItemById();
                    break;
                case "6":
                    this.findItemsByName();
                    break;
                case "7":
                    exit = true;
                    break;
                default:
                    System.out.println("Error!. The item menu is not exist.");
                    break;
            }
        }
    }

    private void showAllItems() {
        Item[] allItems = tracker.findAll();
        System.out.println("-------------- LIST ALL ITEMS --------------");
        printItem(allItems);
        System.out.println("------------ END list all Items ------------");
    }

    private void editItem() {
        System.out.println("---------------- EDIT ITEM ----------------");
        String foundID = this.input.ask("Введите ID заявки, которую хотите изменить : ");
        if (validIsFoundItem(foundID)) {
            String newName = this.input.ask("Введите НОВОЕ имя заявки : ");
            String newDesc = this.input.ask("Введите НОВОЕ описание заявки : ");
            Item newItem = new Item(newName, newDesc, System.currentTimeMillis());
            this.tracker.edit(foundID, newItem);
            System.out.println("### Заявка изменена. ###");
        } else {
            System.out.println("    ### Заявка не найдена. ###    ");
        }
        System.out.println("-------------- END edit item --------------");
    }

    private void deleteItem() {
        System.out.println("---------------- DELETE ITEM ----------------");
        String foundID = this.input.ask("Введите ID заявки, которую хотите удалить : ");
        if (validIsFoundItem(foundID)) {
            this.tracker.delete(foundID);
            System.out.println("### Заявка удалена. ###");
        } else {
            System.out.println("    ### Заявка не найдена. ###    ");
        }
        System.out.println("-------------- END delete item --------------");
    }

    private void findItemById() {
        System.out.println("---------------- FIND ITEM ----------------");
        String foundID = this.input.ask("Введите ID заявки, которую хотите найти : ");
        if (validIsFoundItem(foundID)) {
            printItem(this.tracker.findById(foundID));
        } else {
            System.out.println("    ### Заявка не найдена. ###    ");
        }
        System.out.println("-------------- END find item --------------");
    }

    private void findItemsByName() {
        System.out.println("-------------- LIST FOUNDS ALL ITEMS --------------");
        String findsName = this.input.ask("Введите ИМЯ заявки, которую хотите найти : ");
        Item[] allItems = tracker.findByName(findsName);
        printItem(allItems);
        System.out.println("------------ END founds list all Items ------------");

    }

    /**
     * Method checking exist ID items.
     *
     * @param id item.
     * @return true if ID item exist, else - false.
     */
    private boolean validIsFoundItem(String id) {
        return this.tracker.findById(id) != null;
    }

    /**
     * Method print all items in array.
     *
     * @param allItems array to print.
     */
    private void printItem(Item... allItems) {
        System.out.println("    ### Найденные заявки: ###    ");
        for (int i = 0; i < allItems.length; i++) {
            System.out.println("" + (i + 1) + ". " + " Name: " + allItems[i].getName());
            System.out.println("    Description: " + allItems[i].getDescription());
            Date date = new Date(allItems[i].getCreate());
            System.out.println("    Date of creation: " + date);
            System.out.println("    ID : " + allItems[i].getId());
        }
    }

    /**
     * Метод реализует добавления новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("-------------- Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("--- Создана новая заявка с getId : " + item.getId() + " ---");
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
}
