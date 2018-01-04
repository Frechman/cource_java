package ru.frechman.start;

public class StartUI {

    /**
     * Константа для выхода из программы.
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
     * @param args Args command line.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        boolean exit = false;
        while (!exit) {
            menu.showMenu();
            String userChoice = this.input.ask("Введите пункт меню : ");
            menu.select(Integer.valueOf(userChoice));
            if (EXIT.equals(userChoice)) {
                exit = true;
            }
        }
    }
}
